package com.fpolizzi;

/**
 * Created by fpolizzi on 08.04.26
 */
public class Calculator {

    public <T extends Number> double add(T a, T b) {

        return a.doubleValue() + b.doubleValue();
    }
}
