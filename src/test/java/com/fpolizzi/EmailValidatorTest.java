package com.fpolizzi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 09.04.26
 */
class EmailValidatorTest {

    private EmailValidator underTest = new EmailValidator();

    @ParameterizedTest
    @CsvSource({
            "hello@amigoscode.com, true",
            "helloamigoscode.com, false",
            "hello@amigoscode.org, true",
            "hello+foo@amigoscode.com, true",
            "'', false"
    })
    void canValidateCorrectEmail(String email, boolean expected) {

        // When
        var actual = underTest.test(email);

        // Then
        assertThat(actual).isEqualTo(expected);
    }
}