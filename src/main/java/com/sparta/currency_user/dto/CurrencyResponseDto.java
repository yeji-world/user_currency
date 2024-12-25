package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.enums.CurrencyName;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyResponseDto {
    private Long id;
    private CurrencyName currencyName;
    private BigDecimal exchangeRate;
    private String symbol;

    public CurrencyResponseDto(Currency currency) {
        this.id = currency.getId();
        this.currencyName = currency.getCurrencyName();
        this.exchangeRate = currency.getExchangeRate();
        this.symbol = currency.getCurrencyName().getSymbol();
    }

    public CurrencyResponseDto(Long id, CurrencyName currencyName, BigDecimal exchangeRate, String symbol) {
        this.id = id;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public static CurrencyResponseDto toDto(Currency currency) {
        return new CurrencyResponseDto(
            currency.getId(),
            currency.getCurrencyName(),
            currency.getExchangeRate(),
            currency.getCurrencyName().getSymbol()
        );
    }
}
