package com.sparta.currency_user.enums;

import lombok.Getter;

@Getter
public enum CurrencyName {
    USD("$", true, false),
    JPY("円", false, true),
    EUR("€", true, false);

    private final String symbol;
    private final boolean hasDecimalPoint;
    private final boolean useHundredUnit;

    CurrencyName(String symbol, boolean hasDecimalPoint, boolean useHundredUnit) {
        this.symbol = symbol;
        this.hasDecimalPoint = hasDecimalPoint;
        this.useHundredUnit = useHundredUnit;
    }
}
