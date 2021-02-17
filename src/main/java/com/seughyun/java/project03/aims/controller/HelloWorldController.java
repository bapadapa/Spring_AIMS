package com.seughyun.java.project03.aims.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/api/helloWorld")
    public String helloWorld() {
        return "HelloWorld";
    }
}
