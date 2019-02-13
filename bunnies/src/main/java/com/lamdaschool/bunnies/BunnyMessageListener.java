package com.lamdaschool.bunnies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BunnyMessageListener
{
    @RabbitListener(queues = BunniesApplication.QUEUE_NAME_HIGH)
    public void receiveMessage(BunnyMessage b)
    {
        log.info("Received Message: {} ", b.toString());
    }
}