package com.albert.rpncalculator.op.impl;

import com.albert.rpncalculator.annotation.OperatorClass;
import com.albert.rpncalculator.op.AbstractBinaryOperator;
import org.springframework.stereotype.Component;

@OperatorClass
@Component
public class Divide extends AbstractBinaryOperator {

    private static final String SYMBOL = "/";

    @Override
    public Double calculate(Double number1, Double number2) throws Exception {
        if(number2.equals(0.0)) {
            throw new Exception("zero cannot be divided!");
        }
        return number1 / number2;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
