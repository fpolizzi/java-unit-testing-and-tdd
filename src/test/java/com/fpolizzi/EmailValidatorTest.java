package com.fpolizzi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 09.04.26
 */
class EmailValidatorTest {

    private EmailValidator underTest = new EmailValidator();

    @Test
    void canValidateCorrectEmail() {

        // Given
        var email = "hello@amigoscode.com";

        // When
        var actual = underTest.test(email);

        // Then
        assertThat(actual).isTrue();
    }
}