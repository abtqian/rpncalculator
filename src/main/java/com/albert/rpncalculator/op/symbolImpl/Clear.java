package com.albert.rpncalculator.op.symbolImpl;

import com.albert.rpncalculator.annotation.SymbolOperatorClass;
import com.albert.rpncalculator.op.SymbolOperator;
import com.albert.rpncalculator.storage.PreservableStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SymbolOperatorClass
@Component
public class Clear implements SymbolOperator {

    private static final String SYMBOL = "clear";

    @Autowired
    private PreservableStack preservableStack;

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public void operate() throws Exception {
        preservableStack.clear();
    }
}
