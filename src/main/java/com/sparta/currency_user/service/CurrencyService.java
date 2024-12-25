package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CurrencyRequestDto;
import com.sparta.currency_user.dto.CurrencyResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResponseDto findById(Long id) {
        return new CurrencyResponseDto(findCurrencyById(id));
    }

    public Currency findCurrencyById(Long id) {
        return currencyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "통화를 찾을 수 없습니다."));
    }

    public List<CurrencyResponseDto> findAll() {
        return currencyRepository.findAll().stream().map(CurrencyResponseDto::toDto).toList();
    }

    @Transactional
    public CurrencyResponseDto save(CurrencyRequestDto currencyRequestDto) {
        validateExchangeRate(currencyRequestDto.getExchangeRate());
        Currency savedCurrency = currencyRepository.save(currencyRequestDto.toEntity());
        return new CurrencyResponseDto(savedCurrency);
    }

    private void validateExchangeRate(BigDecimal exchangeRate) {
        if (exchangeRate.signum() <= 0) {
            log.error("입력하신 환율을 다시 확인해주세요.");
            throw new IllegalArgumentException("INVALID_EXCHANGE_RATE");
        }
    }

    @PostConstruct
    public void initValidateExchangeRate(){
        List<Currency> currencyList = currencyRepository.findAll();

        if (currencyList.isEmpty()) {
            log.info("등록된 환율 정보가 없습니다.");
            return;
        }

        for(Currency currency : currencyList) {
            BigDecimal exchangeRate = currency.getExchangeRate();

            if(exchangeRate.signum()<=0) {
                log.error("환율이 유효하지 않습니다. ID={}, 환율={}", currency.getId(), currency.getExchangeRate());
                throw new IllegalArgumentException("INVALID_EXCHANGE_RATE");
            }
        }
        log.info("초기 환율 데이터 검증 완료: 총 {}개의 환율 정보 확인", currencyList.size());
    }
}
