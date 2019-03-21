package com.albert.rpncalculator.op.impl;

import com.albert.rpncalculator.annotation.OperatorClass;
import com.albert.rpncalculator.op.AbstractBinaryOperator;
import org.springframework.stereotype.Component;

@OperatorClass
@Component
public class Add extends AbstractBinaryOperator {

    private static final String SYMBOL = "+";

    @Override
    public Double calculate(Double number1, Double number2) throws Exception {
        return number1 + number2;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
