package com.liu.util;

public class Calculator {
    public double operator(String firstParameter, String operator, String secondParameter) {
        double num = 0;
        Double f = Double.valueOf(firstParameter);
        Double s = Double.valueOf(secondParameter);
        if (operator.equals("+")) {
            num = f + s;
        }
        if (operator.equals("-")) {
            num = f - s;
        }
        if (operator.equals("*")) {
            num = f * s;
        }
        if (operator.equals("/")) {
            num = f / s;
        }
        if (operator.equals("%")) {
            num = f % s;
        }
        return num;
    }
}

