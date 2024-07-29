package com.example.calculator.services.impl;

import com.example.calculator.dtos.MathResponseDto;
import com.example.calculator.services.MathServices;
import org.springframework.stereotype.Service;

@Service
public class MathServicesImpl implements MathServices {
    public MathResponseDto performSum(String numberOne, String numberTwo){
        return new MathResponseDto(convertToDouble(numberOne) + convertToDouble(numberTwo));
    }
    public MathResponseDto performSubtraction(String numberOne, String numberTwo){
        return new MathResponseDto(convertToDouble(numberOne) - convertToDouble(numberTwo));
    }
    public MathResponseDto performDivision(String numberOne, String numberTwo){
        return new MathResponseDto(convertToDouble(numberOne) / convertToDouble(numberTwo));
    }
    public MathResponseDto performMultiplication(String numberOne, String numberTwo){
        return new MathResponseDto(convertToDouble(numberOne) * convertToDouble(numberTwo));
    }
    public boolean isNotNumeric(String number){
        if(number == null) return true;
        number = number.replaceAll(",", ".");
        return !number.matches("[+-]?[0-9]+(\\.)?[0-9]*");
    }
    public boolean isZero(String strNumber){
        double number = convertToDouble(strNumber);
        return number == 0;
    }
    private double convertToDouble(String number) {
        number = number.replaceAll(",", ".");
        return Double.parseDouble(number);
    }
}
