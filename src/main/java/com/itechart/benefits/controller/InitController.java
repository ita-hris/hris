package com.itechart.benefits.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benefits")
public class InitController {

    @RequestMapping("/init")
    public String init() {
        return "Hello World";
    }
}