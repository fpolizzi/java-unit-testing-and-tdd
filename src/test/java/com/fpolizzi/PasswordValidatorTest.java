package com.fpolizzi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 10.04.26
 */
class PasswordValidatorTest {

    private final PasswordValidator underTest =
            new PasswordValidator();

    @Test
    void willFailIfPasswordIsNull() {

        // Given
        String password = null;

        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void willFailIfPasswordIsEmpty() {

        // Given
        String password = "";

        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void willFailIfPasswordHasEmptySpaces() {

        // Given
        String password = "    ";

        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotMeetsMinimumLengthRequiredAfterTrimming() {

        // Given
        String password = "  pass  ";

        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotContainsAtLeastOneDigit() {

        // Given
        String password = "password";

        // When
        var actual = underTest.test(password);
        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void willFailIfPasswordDoesNotContainsAtLeastOneSpecialChar() {

        // Given
        String password = "password1";

        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "Password1!, true",
            "Password1@, true",
            "Password1#, true",
            "Password1$, true",
            "Password1%, true",
            "Password1^, true",
            "Password1&, true",
            "Password1*, true",
            "Password1(, true",
            "Password1), true",
            "Password1_, true",
            "Password1+, true",
            "Password1=, true",
            "Password1<, true",
            "Password1>, true",
            "Password1?, true",
            "Password1/, true",
            "Password1[, true",
            "Password1], true",
            "Password1{, true",
            "Password1}, true",
            "Password1|, true",
            "Password1€, false",
    })
    void canValidateEspecialCharacters(String password,
                                       boolean expected) {
        // When
        var actual = underTest.test(password);

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}
