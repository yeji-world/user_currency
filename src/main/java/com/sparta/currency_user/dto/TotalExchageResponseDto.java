package com.sparta.currency_user.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TotalExchageResponseDto {
    private final Long count;
    private final BigDecimal totalAmountInKrw;

    public TotalExchageResponseDto(Long count, BigDecimal totalAmountInKrw) {
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}