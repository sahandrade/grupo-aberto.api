package com.heroku.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/hello")
public class oi {
    @GetMapping(value="")
    public String getMethodName(){
        return "hello";
    }
    
}
