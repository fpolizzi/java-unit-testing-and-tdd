package com.fpolizzi.exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource({
            "-100",
            "-1",
            "101",
            "150"
    })
    void itShouldThrowWhenInvalidGrade(int grade) {

        assertThatThrownBy(() -> underTest.getGrade(grade))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Score must be between 0 and 100");

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
        var scores = List.of(1, 2, 3 ,4, 5);

        // When
        double actual = underTest.calculateAverage(scores);

        // Then
        double expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldCalculateAverageWhenNull() {

        // Given
        List<Integer> scores = null;

        // When
        double actual = underTest.calculateAverage(scores);

        // Then
        double expected = 0.0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldCalculateAverageWhenEmptyList() {

        // Given
        List<Integer> scores = List.of();

        // When
        double actual = underTest.calculateAverage(scores);

        // Then
        double expected = 0.0;
        assertThat(actual).isEqualTo(expected);
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
        var students = List.of(
                new Student("Alex", 10),
                new Student("Jamila", 80),
                new Student("Ana", 7),
                new Student("George", 18),
                new Student("Sally", 54)
        );

        var threshold = 50;

        // When
        var actual = underTest.getTopStudents(students, threshold);

        // Then
        var expected = List.of(
                new Student("Jamila", 80),
                new Student("Sally", 54)
        );
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldGetTopStudentsWhenOneHasNegativeScore() {

        // Given
        var students = List.of(
                new Student("Alex", 10),
                new Student("Jamila", 80),
                new Student("Ana", 7),
                new Student("George", 18),
                new Student("Sally", 54)
        );

        var threshold = 50;

        // When
        var actual = underTest.getTopStudents(students, threshold);

        // Then
        var expected = List.of(
                new Student("Jamila", 80),
                new Student("Sally", 54)
        );
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldReturnEmptyListWhenStudentsAreNull() {

        // Given
        List<Student> students = null;

        var threshold = 50;

        // When
        var actual = underTest.getTopStudents(students, threshold);

        // Then
        var expected = List.of();
        assertThat(actual).isEqualTo(expected);
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