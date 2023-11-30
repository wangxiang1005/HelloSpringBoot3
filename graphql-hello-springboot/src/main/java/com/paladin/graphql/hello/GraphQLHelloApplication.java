package com.paladin.graphql.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.paladin")
public class GraphQLHelloApplication {
    public static void main(String[] objArgs)
    {
        SpringApplication.run(GraphQLHelloApplication.class, objArgs);
    }
}