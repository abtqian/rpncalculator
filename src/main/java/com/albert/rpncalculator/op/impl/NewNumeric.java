package com.albert.rpncalculator.op.impl;

import com.albert.rpncalculator.op.NumericOperator;
import com.albert.rpncalculator.storage.ResultStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewNumeric implements NumericOperator {

    private Double currentNumber;

    @Autowired
    private ResultStack resultStack;

    @Override
    public void operate() throws Exception {
        resultStack.push(currentNumber);
    }

    @Override
    public void setNumber(String input) {
        this.currentNumber = Double.parseDouble(input);
    }
}
