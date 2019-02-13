package com.lamdaschool.bunnies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@Service
public class BunnyMessageSender
{
    private final RabbitTemplate rt;
    private final BunnyRepository bunnyrepos;

    public BunnyMessageSender(RabbitTemplate rt, BunnyRepository bunnyrepos)
    {
        this.rt = rt;
        this.bunnyrepos = bunnyrepos;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage()
    {
        // var rabbits = new ArrayList<Rabbit>();
        ArrayList<Bunny> bunnies = new ArrayList<Bunny>();

        bunnies.addAll(bunnyrepos.findAll());

        for (Bunny b: bunnies)
        {
            int rand = new Random().nextInt(10);
            boolean randBool = new Random().nextBoolean();
            final BunnyMessage message = new BunnyMessage(b.toString(), rand, randBool);
            // do not send out priority 7 message

            // font - end
            // middleware - business application, requirements
            // back - end
            if (rand <= 5)
            {
                log.info("Sending message HIGH");
                rt.convertAndSend(BunniesApplication.QUEUE_NAME_HIGH, message);
            }
            else
            {
                log.info("Sending message LOW");
                rt.convertAndSend(BunniesApplication.QUEUE_NAME_LOW, message);
            }
        }
    }
}
