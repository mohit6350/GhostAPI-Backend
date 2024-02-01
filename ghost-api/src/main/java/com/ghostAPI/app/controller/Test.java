package com.ghostAPI.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Test {
    @GetMapping("/echo")
    public String echo(){
        return "Hello, world!";
    }

}
