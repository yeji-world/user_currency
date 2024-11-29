package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long currencyId;
    @NotNull(message = "환전을 원하시는 금액을 입력해주세요.")
    private BigDecimal beforeAmount;

}
