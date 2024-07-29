package com.example.calculator.controllers;

import com.example.calculator.dtos.MathResponseDto;
import com.example.calculator.exceptions.AttemptToDivideByZeroException;
import com.example.calculator.exceptions.UnsupportedMathOperationException;
import com.example.calculator.services.MathServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    private final MathServices mathServices;

    public MathController(MathServices mathServices){
        this.mathServices = mathServices;
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public ResponseEntity<MathResponseDto> sum(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo) throws Exception{
        if(mathServices.isNotNumeric(numberOne) || mathServices.isNotNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return new ResponseEntity<>(mathServices.performSum(numberOne, numberTwo), HttpStatus.OK);
    }
    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public ResponseEntity<MathResponseDto> subtraction(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo) throws Exception{
        if(mathServices.isNotNumeric(numberOne) || mathServices.isNotNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return new ResponseEntity<>(mathServices.performSubtraction(numberOne, numberTwo), HttpStatus.OK);
    }
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public ResponseEntity<MathResponseDto> division(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo) throws Exception{
        if(mathServices.isNotNumeric(numberOne) || mathServices.isNotNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        if(mathServices.isZero(numberTwo)){
            throw new AttemptToDivideByZeroException("Please define a non-zero divisor!");
        }
        return new ResponseEntity<>(mathServices.performDivision(numberOne, numberTwo), HttpStatus.OK);
    }
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public ResponseEntity<MathResponseDto> multiplication(
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo) throws Exception{
        if(mathServices.isNotNumeric(numberOne) || mathServices.isNotNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, set a numeric value!");
        }
        return new ResponseEntity<>(mathServices.performMultiplication(numberOne, numberTwo), HttpStatus.OK);
    }
}
