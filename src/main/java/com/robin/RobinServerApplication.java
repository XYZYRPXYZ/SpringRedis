package com.robin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({})
public class RobinServerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RobinServerApplication.class);
        app.run(args);
    }
}
