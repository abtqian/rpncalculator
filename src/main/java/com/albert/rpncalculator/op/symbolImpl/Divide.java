package com.albert.rpncalculator.op.symbolImpl;

import com.albert.rpncalculator.annotation.SymbolOperatorClass;
import com.albert.rpncalculator.op.AbstractCalculatonOperator;
import org.springframework.stereotype.Component;

import java.util.List;

@SymbolOperatorClass
@Component
public class Divide extends AbstractCalculatonOperator {

    private static final String SYMBOL = "/";
    private static final int OPERAND_NUMBER = 2;

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    protected Double calculate(List<Double> operandList) throws Exception {
        Double operand1 = operandList.get(0);
        Double operand2 = operandList.get(1);
        if(operand2.equals(0.0)) {
            throw new Exception("zero cannot be divided!");
        }
        return operand1 / operand2;
    }

    @Override
    protected int getOperandNumber() {
        return OPERAND_NUMBER;
    }
}
