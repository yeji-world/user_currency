package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @NotBlank(message = "어떤 통화로 환전하실 지 입력해주세요.")
    @Pattern(regexp = "^[A-Z]*$", message = "대문자로 입력해주세요.")
    private String currencyName;
    @NotNull(message = "해당하는 환율을 입력해주세요.")
//    @Positive
    private BigDecimal exchangeRate;
    @NotBlank(message = "통화 기호를 입력해주세요.")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}
