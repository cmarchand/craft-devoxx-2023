package com.oxiane.katas.fizzbuzz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

  @Test
  @DisplayName("Given number is one, FizzBuzz should return \"1\"")
  public void given_1_should_return_1() {
    // Given
    int input = 1;
    String expected = "1";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is two, FizzBuzz should return \"2\"")
  public void given_2_should_return_2() {
    // Given
    int input = 2;
    String expected = "2";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is three, FizzBuzz should return \"Fizz\"")
  public void given_3_should_return_Fizz() {
    // Given
    int input = 3;
    String expected = "Fizz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is five, FizzBuzz should return \"Buzz\"")
  public void given_5_should_return_Buzz() {
    // Given
    int input = 5;
    String expected = "Buzz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is six, FizzBuzz should return \"Fizz\"")
  public void given_6_should_return_Fizz() {
    // Given
    int input = 6;
    String expected = "Fizz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is ten, FizzBuzz should return \"Buzz\"")
  public void given_10_should_return_Buzz() {
    // Given
    int input = 10;
    String expected = "Buzz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is fifteen, FizzBuzz should return \"FizzBuzz\"")
  public void given_15_should_return_FizzBuzz() {
    // Given
    int input = 15;
    String expected = "FizzBuzz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("Given number is thirty, FizzBuzz should return \"FizzBuzz\"")
  public void given_30_should_return_FizzBuzz() {
    // Given
    int input = 30;
    String expected = "FizzBuzz";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
