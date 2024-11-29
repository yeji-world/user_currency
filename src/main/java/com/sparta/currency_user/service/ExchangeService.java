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
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserService userService;
    private final CurrencyService currencyService;

    public ExchangeResponseDto createExchange(ExchangeRequestDto requestDto) {
        User findUser = userService.findUserById(requestDto.getUserId());
        Currency findCurrency = currencyService.findCurrencyById(requestDto.getCurrencyId());
        BigDecimal afterAmount = exchangeMoney(findCurrency.getExchangeRate(), requestDto.getBeforeAmount());
        UserCurrency userCurrency = new UserCurrency(findUser, findCurrency, requestDto.getBeforeAmount(), afterAmount, Status.NORMAL);
        UserCurrency savedUserCurrency = exchangeRepository.save(userCurrency);

        return new ExchangeResponseDto(savedUserCurrency);
    }

    public List<ExchangeResponseDto> findExchange(Long userId) {
        List<UserCurrency> findExchangeList = exchangeRepository.findAllByUserId(userId);

        return findExchangeList.stream().map(ExchangeResponseDto::new).toList();
    }

    public ExchangeResponseDto cancelExchange(Long currencyId) {
        UserCurrency findUserCurrency = exchangeRepository.findByIdOrElseThrows(currencyId);
        findUserCurrency.cancelExchange(Status.CANCELLED);
        UserCurrency savedUserCurrency = exchangeRepository.save(findUserCurrency);

        return new ExchangeResponseDto(savedUserCurrency);
    }

    private BigDecimal exchangeMoney(BigDecimal exchangeRate, BigDecimal beforeAmount){

        return beforeAmount.divide(exchangeRate,2, RoundingMode.HALF_UP);
    }
}
