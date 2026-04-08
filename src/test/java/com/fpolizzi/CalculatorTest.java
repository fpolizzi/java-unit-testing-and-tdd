package com.fpolizzi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 08.04.26
 */
class CalculatorTest {

    private final Calculator underTest = new Calculator();

    @Test
    void canAddNumbers() {

        // given
        var number1 = 3;
        var number2 = 3;

        // when
        var actual = underTest.add(number1, number2);

        // then
        var expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}