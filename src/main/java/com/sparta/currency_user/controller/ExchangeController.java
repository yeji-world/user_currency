package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.ExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exchanges")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(
            @PathVariable Long user_id,
            @Valid @RequestBody ExchangeRequestDto requestDto
    ){
        ExchangeResponseDto responseDto = exchangeService.createExchange(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
