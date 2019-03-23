package com.albert.rpncalculator.control;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

public class OutputStringUtils {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##########");

    static {
        DECIMAL_FORMAT.setRoundingMode(RoundingMode.DOWN);
    }

    public static String GetStackContent(Stack<Double> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("stack: ");
        stack.stream().forEach( number -> sb.append(DECIMAL_FORMAT.format(number) + " "));

        //This step is to remove the last space in the String
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static String GetExceptionString(String operatorName, int position,String message) {
        return "operator " + operatorName + " (position: " + position + "): " + message;
    }
}
