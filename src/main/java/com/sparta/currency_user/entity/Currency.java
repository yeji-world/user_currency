package com.sparta.currency_user.entity;

import com.sparta.currency_user.enums.CurrencyName;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
public class Currency extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CurrencyName currencyName;
    private BigDecimal exchangeRate;

    public Currency(CurrencyName currencyName, BigDecimal exchangeRate) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
    }

    public Currency() {}

}
