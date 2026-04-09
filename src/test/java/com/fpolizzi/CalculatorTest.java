package com.fpolizzi;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 08.04.26
 */
class CalculatorTest {

    private Calculator underTest;

    @BeforeEach
    void setUp() {
        System.out.println("setup");

        underTest = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before class create");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after class destroy");
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