package com.softobt.testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.softobt")
public class TestStartService {
    public static void main(String... args){
        try {
            SpringApplication.run(TestStartService.class, args);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
