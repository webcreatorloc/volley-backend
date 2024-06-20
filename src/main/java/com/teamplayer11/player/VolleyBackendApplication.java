package com.teamplayer11.player;

import com.teamplayer11.player.player.Player;
import com.teamplayer11.player.player.PlayerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class VolleyBackendApplication {

    private static final Logger log = LoggerFactory.getLogger(VolleyBackendApplication.class);

    public static final String SEC_ALLOWED_ORIGIN = System.getenv("SEC_ALLOWED_ORIGIN");

    public static void main(String[] args) {
        SpringApplication.run(VolleyBackendApplication.class);
    }

   /* @Bean
    public CommandLineRunner volley(PlayerRepository repository) {
        return (args) -> {
            // save a few Players
            repository.save(new Player("Jack", "Nicholson"));
            repository.save(new Player("Chloe", "O'Brian"));
            repository.save(new Player("Kim", "Bauer"));
            repository.save(new Player("David", "Palmer"));
            repository.save(new Player("Michelle", "Dessler"));

            // fetch all Players
            log.info("Players found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(Player -> {
                log.info(Player.toString());
            });
            log.info("");

            // fetch an individual Player by ID
            Player Player = repository.findById(1L);
            log.info("Player found with findById(1L):");
            log.info("--------------------------------");
            log.info(Player.toString());
            log.info("");

            // fetch Players by last name
            log.info("Player found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }*/

}