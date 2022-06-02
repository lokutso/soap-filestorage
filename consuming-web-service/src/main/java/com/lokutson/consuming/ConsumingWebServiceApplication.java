package com.lokutson.consuming;

import com.lokutson.consumingwebservice.wsdl.File;
import com.lokutson.consumingwebservice.wsdl.GetFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.GregorianCalendar;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(FileClient.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(FileClient quoteClient) {
        return args -> {

            GetFileResponse response = quoteClient.getFile(0L);
            if (response.getFile() == null) {
                log.info("OK");
            } else {
                throw new RuntimeException();
            }

            File file = new File();
            file.setName("Первый файл");
            file.setDescription("Описание первого файла");

            response = quoteClient.createFile(file);
            if (response.getFile() != null) {
                file = response.getFile();
                log.info(print(file));
            } else {
                throw new RuntimeException();
            }

            file.setName("Второй файл");
            response = quoteClient.updateFile(file);
            if (response.getFile() != null) {
                file = response.getFile();
                log.info(print(file));
            } else {
                throw new RuntimeException();
            }

            response = quoteClient.deleteFile(file.getId());
            if (response.getFile() != null) {
                file = response.getFile();
                log.info(print(file));
            } else {
                throw new RuntimeException();
            }

            response = quoteClient.getFile(file.getId());
            if (response.getFile() == null) {
                log.info("OK");
            } else {
                throw new RuntimeException();
            }
        };
    }

    public static String print(File file) {
        return "File{" +
                "id=" + file.getId() +
                ", name='" + file.getName() + '\'' +
                ", description='" + file.getDescription() + '\'' +
                '}';
    }

}
