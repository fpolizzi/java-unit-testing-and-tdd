package com.fpolizzi;

import org.junit.jupiter.api.Test;

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
}
