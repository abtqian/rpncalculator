package com.albert.rpncalculator.control;

import java.text.DecimalFormat;
import java.util.Stack;

public class OutputStringUtils {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    public static String GetStackContent(Stack<Double> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: ");
        stack.stream().forEach( number -> sb.append(decimalFormat.format(number) + " "));
        return sb.toString();
    }

    public static String GetExceptionString(String operatorName, int position,String message) {
        return "operator " + operatorName + " (position: " + position + "): " + message;
    }
}
