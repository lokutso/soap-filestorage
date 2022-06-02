package com.lokutson.producing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducingWebServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(FileRepository repository) {
        return (args) -> {
            repository.save(new File("1", "1"));
            repository.save(new File("2", "2"));
            repository.save(new File("3", "3"));
        };
    }

}
