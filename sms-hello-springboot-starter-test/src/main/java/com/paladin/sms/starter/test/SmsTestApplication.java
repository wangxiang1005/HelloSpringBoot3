package com.paladin.sms.starter.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.paladin")
@SpringBootApplication
public class SmsTestApplication {
    public static void main(String[] objArgs)
    {
        SpringApplication.run(SmsTestApplication.class, objArgs);
    }
}