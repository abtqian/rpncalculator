package com.albert.rpncalculator.op.impl;

import com.albert.rpncalculator.annotation.OperatorClass;
import com.albert.rpncalculator.op.AbstractUnitOperator;
import org.springframework.stereotype.Component;

@OperatorClass
@Component
public class Sqrt extends AbstractUnitOperator {

    private static final String SYMBOL = "sqrt";

    @Override
    public Double calculate(Double number) throws Exception {
        if(number < 0.0) {
            throw new Exception("Negative numbers cannot sqrt!");
        }
        return Math.sqrt(number);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
