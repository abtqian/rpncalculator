package com.albert.rpncalculator.op;

import com.albert.rpncalculator.storage.PreservableStack;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractCalculatonOperator implements SymbolOperator{

    @Autowired
    private PreservableStack preservableStack;

    @Override
    public void operate() throws Exception {
        int operandNum = getOperandNumber();
        if(preservableStack.size() < operandNum) {
            throw new Exception("insucient parameters");
        }

        LinkedList<Double> list = new LinkedList<>();
        for(int i = 0; i < operandNum; i++) {
            list.push(preservableStack.pop());
        }

        Double result = calculate(list);
        preservableStack.push(result);
    }

    protected abstract Double calculate(List<Double> operandList) throws Exception;

    protected abstract int getOperandNumber();

}
