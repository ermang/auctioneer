package com.eg.auctioneer.controller;

import com.eg.auctioneer.dto.in.CreateUser;
import com.eg.auctioneer.service.UserCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/login")
    public void login(){
        return;
    }

    @PostMapping()
    public void createUser(@RequestBody @Valid CreateUser createUser){
        userCommandService.createUser(createUser);
    }
}
