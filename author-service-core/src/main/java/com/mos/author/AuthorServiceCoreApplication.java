package com.mos.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorServiceCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorServiceCoreApplication.class, args);
        System.out.println("author service core start");
    }
}
