package com.eg.auctioneer.dto.in;

import javax.validation.constraints.NotBlank;

public class CreateUser {
    @NotBlank(message = "username can not be blank")
    public String username;
    @NotBlank(message = "password can not be blank")
    public String password;
}
