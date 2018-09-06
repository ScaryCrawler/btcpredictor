package com.db.mlmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MlModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlModuleApplication.class, args);
    }
}
