package com.lamdaschool.bunnies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@RestController
public class BunnyController
{
    private final BunnyRepository bunnyrepos;
    private final RabbitTemplate rt;

    public BunnyController(BunnyRepository bunnyrepos, RabbitTemplate rt)
    {
        this.bunnyrepos = bunnyrepos;
        this.rt = rt;
    }

    @GetMapping("/rabbits")
    public void findSome()
    {
        ArrayList<Bunny> bunnies = new ArrayList<Bunny>();
        bunnies.addAll(bunnyrepos.findAll());

        for (Bunny b: bunnies)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final BunnyMessage message = new BunnyMessage(b.toString(), rand, randBool);

            log.info("Sending Message...");
            if (rand <= 5)
            {
                rt.convertAndSend(BunniesApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                rt.convertAndSend(BunniesApplication.QUEUE_NAME_LOW, message);
            }
        }
    }
}

