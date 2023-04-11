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
  @DisplayName("Given number is one, FizzBuzz should return \"1\"")
  public void given_2_should_return_2() {
    // Given
    int input = 2;
    String expected = "2";
    // When
    String actual = FizzBuzz.fizzBuzz(input);
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
