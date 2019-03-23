package com.albert.rpncalculator.op.numericImpl;

import com.albert.rpncalculator.op.NumericOperator;
import com.albert.rpncalculator.storage.PreservableStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewNumber implements NumericOperator {

    @Autowired
    private PreservableStack preservableStack;

    @Override
    public void operate(String input) {
        Double inputNumber = Double.parseDouble(input);
        preservableStack.push(inputNumber);
    }

}
