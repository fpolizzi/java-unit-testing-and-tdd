package com.fpolizzi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fpolizzi on 08.04.26
 */
class CalculatorTest {

    @Test
    void canAddNumbers() {

        var calculator = new Calculator();

        var result = calculator.add(3, 3);

        assertEquals(6, result);
    }
}