package com.albert.rpncalculator.storage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayDeque;

@Component
@Scope("singleton")
public class ResultStackImpl implements ResultStack {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    private ArrayDeque<Double> currentStack = new ArrayDeque<Double>();
    private ArrayDeque<ArrayDeque<Double>> historyStack = new ArrayDeque<ArrayDeque<Double>>();

    @Override
    public void push(Double num) {
        currentStack.addLast(num);
    }

    @Override
    public Double pop() throws Exception {
        if(currentStack.size() == 0) {
            throw new Exception("insucient parameters");
        }

        return currentStack.pollLast();
    }

    @Override
    public void clear() {
        currentStack.clear();
    }

    @Override
    public String printStack() {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: ");
        currentStack.stream().forEach( number -> sb.append(decimalFormat.format(number) + " "));
        return sb.toString();
    }

    @Override
    public void save() {
        ArrayDeque<Double> copyQueue = new ArrayDeque<Double>();
        for(Double number : currentStack) {
            copyQueue.addLast(number);
        }
        historyStack.addLast(copyQueue);
    }

    @Override
    public void load() {
        historyStack.pollLast();
        if(historyStack.size() == 0) {
            currentStack.clear();
        } else {
            currentStack = null;
            currentStack = historyStack.pollLast();
        }
    }

    @Override
    public void recovery() {
        if(historyStack.size() == 0) {
            currentStack.clear();
        } else {
            currentStack = new ArrayDeque<Double>();
            for(Double number : historyStack.getLast()) {
                currentStack.addLast(number);
            }
        }
    }
}
