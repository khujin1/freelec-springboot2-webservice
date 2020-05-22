package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    //public Application() {} //default 생성자. 생략 가능

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}