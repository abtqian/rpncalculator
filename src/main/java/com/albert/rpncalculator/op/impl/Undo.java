package com.albert.rpncalculator.op.impl;

import com.albert.rpncalculator.annotation.OperatorClass;
import com.albert.rpncalculator.op.SymbolOperator;
import com.albert.rpncalculator.storage.ResultStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@OperatorClass
@Component
public class Undo implements SymbolOperator {

    private static final String SYMBOL = "undo";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public void operate() throws Exception {
        //Undo operator class do nothing here, see StackBackupAspect.class
    }
}
