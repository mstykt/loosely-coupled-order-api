package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableFeignClients
@EnableCaching
@EnableKafka
@SpringBootApplication
public class LooselyCoupledOrderApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LooselyCoupledOrderApiApplication.class, args);
    }
}
