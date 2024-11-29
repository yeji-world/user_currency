package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.UserCurrency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeResponseDto {
    private Long exchangeId;
    private Long userId;
    private String currencyName;
    private BigDecimal exchangeRate;
    private BigDecimal beforeAmount;
    private BigDecimal afterAmount;
    private Enum status;

    public ExchangeResponseDto(UserCurrency userCurrency) {
        this.exchangeId = userCurrency.getId();
        this.userId = userCurrency.getUser().getId();
        this.currencyName = userCurrency.getCurrency().getCurrencyName();
        this.exchangeRate = userCurrency.getCurrency().getExchangeRate();
        this.beforeAmount = userCurrency.getBeforeAmount();
        this.afterAmount = userCurrency.getAfterAmount();
        this.status = userCurrency.getStatus();
    }
}
