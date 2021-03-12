package com.eg.auctioneer.dto.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateAuction {
    @NotBlank(message = "name can not be blank")
    public String name;
    @NotNull(message = "itemId can not be null")
    public Long itemId;
    @NotNull(message = "startAmount can not be null")
    public BigDecimal startAmount;
    @NotNull(message = "auctionBegin can not be null")
    public LocalDateTime auctionBegin;
    @NotNull(message = "auctionEnd can not be null")
    public LocalDateTime auctionEnd;

    public BigDecimal buyNowAmount;
}
