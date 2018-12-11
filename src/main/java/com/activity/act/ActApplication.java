package com.activity.act;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.activity.act.dao")
@EntityScan("com.activity.act.entity")
public class ActApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActApplication.class, args);
    }
}
