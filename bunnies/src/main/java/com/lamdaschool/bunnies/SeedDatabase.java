package com.lamdaschool.bunnies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeedDatabase
{
    @Bean
    public CommandLineRunner initDB(BunnyRepository bunnyrepos)
    {
        return args ->
        {
            log.info("Seeding " + bunnyrepos.save(new Bunny("Barn Barn", 5.1)));
            log.info("Seeding " + bunnyrepos.save(new Bunny("Cinnamon", 4.3)));
            log.info("Seeding " + bunnyrepos.save(new Bunny("Jessica", 4.7)));
        };
    }
}
