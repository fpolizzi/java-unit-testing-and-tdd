package com.fpolizzi.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fpolizzi on 09.04.26
 */
class Exercise1Test {

    private final Exercise1 underTest = new Exercise1();

    @ParameterizedTest
    @CsvSource({
            "90, A",
            "91, A",
            "100, A",
            "80, B",
            "81, B",
            "89, B",
            "70, C",
            "71, C",
            "79, C",
            "60, D",
            "61, D",
            "69, D",
            "50, E",
            "51, E",
            "59, E",
            "49, F",
            "0, F"
    })
    void itShouldGetCorrectGrade(int score, String expectedGrade) {

        // When
        String actual = underTest.getGrade(score);

        // Then
        assertThat(actual).isEqualTo(expectedGrade);
    }

    @Test
    void itShouldCountVowels() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldIsValidStudentId() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldCalculateAverage() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldGenerateUsername() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldGetTopStudents() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldHasDuplicateNames() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldReverseCourses() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldHasPassed() {
        // Given
        // When
        // Then
    }

    @Test
    void itShouldAssignBadge() {
        // Given
        // When
        // Then
    }
}