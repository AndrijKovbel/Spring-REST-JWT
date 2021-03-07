package com.kobel.spring.security.rest.controller;

import lombok.Data;


@Data
public class AuthRequest {

    private String login;
    private String password;



}
