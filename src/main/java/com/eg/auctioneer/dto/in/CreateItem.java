package com.eg.auctioneer.dto.in;

import javax.validation.constraints.NotBlank;

public class CreateItem {
    @NotBlank(message = "name can not be blank")
    public String name;
    @NotBlank(message = "description can not be blank")
    public String description;

    public String[] base64EncodedImages;
}
