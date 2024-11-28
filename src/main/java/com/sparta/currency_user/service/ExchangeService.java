package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserCurrency;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.status.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserService userService;
    private final CurrencyService currencyService;

    public ExchangeResponseDto createExchange(ExchangeRequestDto requestDto) {
        User findUser = userService.findUserById(requestDto.getUserId());
        Currency findCurrency = currencyService.findCurrencyById(requestDto.getCurrencyId());
        BigDecimal afterAmount = requestDto.getBeforeAmount().divide(findCurrency.getExchangeRate(),2, RoundingMode.HALF_UP);
        UserCurrency userCurrency = new UserCurrency(findUser, findCurrency, requestDto.getBeforeAmount(), afterAmount, Status.normal);
        UserCurrency savedUserCurrency = exchangeRepository.save(userCurrency);

        return new ExchangeResponseDto(savedUserCurrency);
    }
}
