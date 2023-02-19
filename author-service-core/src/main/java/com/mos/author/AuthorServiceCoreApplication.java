package com.mos.author;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mos.author.mapper")
public class AuthorServiceCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorServiceCoreApplication.class, args);
        System.out.println("author service core start");
    }
}
