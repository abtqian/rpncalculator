package com.albert.rpncalculator.storage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Stack;

@Component(value = "preservableStack")
@Scope("singleton")
public class PreservableStack extends Stack<Double> implements Preservable {

    private Stack<Stack<Double>> historyStack = new Stack<>();

    @Override
    public void save() {
        Stack<Double> newStack = new Stack<>();
        newStack.addAll(this);
        historyStack.push(newStack);
    }

    @Override
    public void load() {
        historyStack.pop();
        this.clear();
        if(historyStack.size() != 0) {
            this.addAll(historyStack.pop());
        }
    }

    @Override
    public void recovery() {
        this.clear();
        if(historyStack.size() != 0) {
            this.addAll(historyStack.peek());
        }
    }
}
