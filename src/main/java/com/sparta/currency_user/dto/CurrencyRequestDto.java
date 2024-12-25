package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.enums.CurrencyName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @NotNull(message = "통화 종류를 입력해주세요.")
//    @Pattern(regexp = "^[A-Z]*$", message = "대문자로 입력해주세요.")
    private CurrencyName currencyName;
    @NotNull(message = "해당하는 환율을 입력해주세요.")
//    @Positive
    private BigDecimal exchangeRate;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate
        );
    }
}
