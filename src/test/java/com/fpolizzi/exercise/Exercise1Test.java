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
public class Exercise1Test {

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

    @ParameterizedTest
    @CsvSource({
            "Alex, 2",
            "Jamila, 3",
            "Ana, 2",
            "George, 3",
            "Sally, 1"
    })
    void countVowelsWhenValidName(String name, int expectedtVowels) {

        // When
        var actual = underTest.countVowels(name);

        // Then
        assertThat(actual).isEqualTo(expectedtVowels);
    }

    @Test
    void countVowelsWhenNull() {

        // When
        var actual = underTest.countVowels(null);

        // Then
        assertThat(actual).isZero();
    }

    @ParameterizedTest
    @CsvSource({
            "S1234, true",
            "S001, false",
            "T1234, false",
            "S123, false",
            "'', false"
    })
    void isValidStudentId(String id, boolean expected) {

        // When
        var actual = underTest.isValidStudentId(id);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldTestIfStudentIdIsNull() {

        // When
        var actual = underTest.isValidStudentId(null);

        // Then
        assertThat(actual).isFalse();
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

        // When
        var actual = underTest.generateUsername("Alex Smith");

        // Then
        String expected = "asmith";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShouldTestInvalidInput() {

        // When
        var actual = underTest.generateUsername("Alex");

        // Then
        assertThat(actual).isEmpty();
    }

    @Test
    void itShouldReturnIsEmptyIfUsernameIsNull() {

        // When
        var actual = underTest.generateUsername(null);

        // Then
        assertThat(actual).isEmpty();
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
                new Student("Sally", 54),
                new Student("Brian", 7)
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
    void itShouldReturnEmptyListWhenStudentsAreEmpty() {

        // Given
        List<Student> students = List.of();

        var threshold = 50;

        // When
        var actual = underTest.getTopStudents(students, threshold);

        // Then
        var expected = List.of();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void itShoulfFindDuplicateNamesIfExists() {

        // Given
        var students = List.of(
                new Student("Alex", 10),
                new Student("alex", 20)
        );

        // When
        var actual = underTest.hasDuplicateNames(students);

        // Then
        assertThat(actual).isTrue();
    }

    @Test
    void isShouldCheckIfThereAreOnlyUniqueNames() {

        // Given
        var students = List.of(
                new Student("Alex", 10),
                new Student("Jamila", 20)
        );

        // When
        var actual = underTest.hasDuplicateNames(students);

        assertThat(actual).isFalse();
    }

    @Test
    void itShouldReturnFalseForDuplicatesWhenStudentsIsNull() {

        // Given
        List<Student> students = null;

        // When
        var actual = underTest.hasDuplicateNames(students);

        // Then
        assertThat(actual).isFalse();
    }

    @Test
    void itShouldReturnFalseForDuplicatesWhenStudentsIsEmpty() {

        // Given
        List<Student> students = List.of();

        // When
        var actual = underTest.hasDuplicateNames(students);

        // Then
        assertThat(actual).isFalse();
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