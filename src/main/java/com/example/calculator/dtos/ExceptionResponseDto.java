package com.example.calculator.dtos;

import java.util.Date;

public record ExceptionResponseDto(
        Date timestamp,
        String message,
        String details) { }
