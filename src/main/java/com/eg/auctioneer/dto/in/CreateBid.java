package com.eg.auctioneer.dto.in;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateBid {
    @NotNull(message = "auctionId can not be blank")
    public Long auctionId;
    @NotNull(message = "amount can not be blank")
    public BigDecimal amount;
}
