package com.albert.rpncalculator.op;

public interface SymbolOperator {
    void operate() throws Exception;
    String getSymbol();
}
