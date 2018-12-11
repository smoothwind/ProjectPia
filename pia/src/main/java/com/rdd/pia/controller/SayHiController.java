package com.rdd.pia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhi")
public class SayHiController {

    @GetMapping
    public String sayHi(){
        return "hi";
    }
}
