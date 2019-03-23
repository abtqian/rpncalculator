package com.albert.rpncalculator.op.symbolImpl;

import com.albert.rpncalculator.annotation.SymbolOperatorClass;
import com.albert.rpncalculator.op.AbstractCalculatonOperator;
import org.springframework.stereotype.Component;

import java.util.List;

@SymbolOperatorClass
@Component
public class Multiply extends AbstractCalculatonOperator {

    private static final String SYMBOL = "*";
    private static final int OPERAND_NUMBER = 2;

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    protected Double calculate(List<Double> operandList) throws Exception {
        Double number1 = operandList.get(0);
        Double number2 = operandList.get(1);
        return number1 * number2;
    }

    @Override
    protected int getOperandNumber() {
        return OPERAND_NUMBER;
    }
}
