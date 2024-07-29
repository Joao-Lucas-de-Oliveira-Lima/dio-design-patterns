package com.example.calculator.services;

import com.example.calculator.dtos.MathResponseDto;

public interface MathServices {
    public MathResponseDto performSum(String numberOne, String numberTwo);
    public MathResponseDto performSubtraction(String numberOne, String numberTwo);
    public MathResponseDto performDivision(String numberOne, String numberTwo);
    public MathResponseDto performMultiplication(String numberOne, String numberTwo);
    public boolean isZero(String strNumber);
    public boolean isNotNumeric(String number);
}