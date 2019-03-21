package com.albert.rpncalculator.op;

import com.albert.rpncalculator.storage.ResultStack;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUnitOperator implements SymbolOperator {

    @Autowired
    private ResultStack resultStack;

    @Override
    public void operate() throws Exception {
        Double opNum = resultStack.pop();
        Double result = calculate(opNum);
        resultStack.push(result);
    }

    public abstract Double calculate(Double number) throws Exception;

}
