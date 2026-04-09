package com.fpolizzi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 08.04.26
 */
class CalculatorTest {

    private Calculator underTest;

    @BeforeEach
    void setUp() {
        System.out.println("Hello");

        underTest = new Calculator();
    }

    @Test
    void canAddNumbers() {

        System.out.println("canAddNumbers");

        // given
        var number1 = 3;
        var number2 = 3;

        // when
        var actual = underTest.add(number1, number2);

        // then
        var expected = 6;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void name() {

        System.out.println("name");
    }
}