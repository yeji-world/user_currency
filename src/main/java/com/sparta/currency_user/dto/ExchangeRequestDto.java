package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {
    private Long userId;
    private Long currencyId;
    private BigDecimal beforeAmount;

}
