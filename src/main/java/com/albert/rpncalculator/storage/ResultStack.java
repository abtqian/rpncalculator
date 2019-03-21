package com.albert.rpncalculator.storage;

public interface ResultStack {

    void push(Double num);

    Double pop() throws Exception;

    void clear();

    String printStack();

    void save();

    void load();

    void recovery();

}
