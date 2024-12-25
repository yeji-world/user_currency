package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.TotalExchageResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exchanges")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(
            @Valid @RequestBody ExchangeRequestDto requestDto
    ){
        ExchangeResponseDto responseDto = exchangeService.createExchange(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExchangeResponseDto>> findExchange(@PathVariable Long userId){
        List<ExchangeResponseDto> responseDtoList = exchangeService.findExchange(userId);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{userId}/total")
    public ResponseEntity<TotalExchageResponseDto> findTotalExchange(@PathVariable Long userId){
        TotalExchageResponseDto totalDto = exchangeService.findTotalExchange(userId);
        return new ResponseEntity<>(totalDto, HttpStatus.OK);
    }

    @PatchMapping("/{exchangeId}")
    public ResponseEntity<ExchangeResponseDto> cancelExchange(@PathVariable Long exchangeId) {
        ExchangeResponseDto responseDto = exchangeService.cancelExchange(exchangeId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
