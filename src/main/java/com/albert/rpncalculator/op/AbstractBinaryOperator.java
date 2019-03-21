package com.albert.rpncalculator.op;

import com.albert.rpncalculator.storage.ResultStack;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBinaryOperator implements SymbolOperator{

    @Autowired
    private ResultStack resultStack;

    @Override
    public void operate() throws Exception {
        Double opNum2 = resultStack.pop();
        Double opNum1 = resultStack.pop();
        Double result = calculate(opNum1, opNum2);
        resultStack.push(result);
    }

    public abstract Double calculate(Double number1, Double number2) throws Exception;

}
