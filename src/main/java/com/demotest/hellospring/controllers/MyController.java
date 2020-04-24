package com.demotest.hellospring.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {

    @RequestMapping("/hi")
    public String sayHello() {
        return "Hello world";
    }

    @RequestMapping("/")
    public String home() {
        return "welcome back home";
    }

}