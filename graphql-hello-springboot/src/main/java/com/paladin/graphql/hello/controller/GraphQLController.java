package com.paladin.graphql.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GraphQLController {
    @RequestMapping("/world")
    public String hello() {
        return "SUCCESS";
    }
}