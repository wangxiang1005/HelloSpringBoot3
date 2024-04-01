package com.paladin.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.paladin")
public class MinioHelloApplication {
    public static void main(String[] objArgs)
    {
        SpringApplication.run(MinioHelloApplication.class, objArgs);
    }
}