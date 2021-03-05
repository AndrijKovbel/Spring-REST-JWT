package com.kobel.spring.security.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/admin/get")
    public String getAdmin(){
        return "Hello Admin";
    }

    @GetMapping("/user/get")
    public String getUser(){
        return "Hello User";
    }
}
