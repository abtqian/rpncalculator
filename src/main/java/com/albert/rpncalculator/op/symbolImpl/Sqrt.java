package com.albert.rpncalculator.op.symbolImpl;

import com.albert.rpncalculator.annotation.SymbolOperatorClass;
import com.albert.rpncalculator.op.AbstractCalculatonOperator;
import org.springframework.stereotype.Component;

import java.util.List;

@SymbolOperatorClass
@Component
public class Sqrt extends AbstractCalculatonOperator {

    private static final String SYMBOL = "sqrt";
    private static final int OPERAND_NUMBER = 1;

    @Override
    public Double calculate(List<Double> list) throws Exception {
        Double operand = list.get(0);
        if(operand < 0.0) {
            throw new Exception("Negative numbers cannot sqrt!");
        }
        return Math.sqrt(operand);
    }

    @Override
    protected int getOperandNumber() {
        return OPERAND_NUMBER;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
