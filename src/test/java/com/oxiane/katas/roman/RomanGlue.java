package com.oxiane.katas.roman;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class RomanGlue {
  private int arabic;
  private String actualRoman;
  private String roman;
  private int actualArabic;

  // Arabic to Roman part

  @Given("arabic number is {int}")
  public void arabic_number_is(int arabic) {
    this.arabic = arabic;
  }
  @When("arabic number is converted to roman")
  public void arabic_number_is_converted_to_roman() {
    actualRoman = RomanConverter.convertToRoman(arabic);
  }
  @Then("roman number returned is {word}")
  public void roman_number_returned_is(String expected) {
    Assertions.assertThat(actualRoman).isEqualTo(expected);
  }

  // Roman to arabic part
  @Given("roman number is {word}")
  public void roman_number_is(String roman) {
    this.roman = roman;
  }
  @When("roman number is converted to arabic")
  public void roman_number_is_converted_to_arabic() {
    actualArabic = RomanConverter.convertToArabic(roman);
  }
  @Then("arabic number returned is {int}")
  public void arabic_number_returned_is(int expected) {
    Assertions.assertThat(actualArabic).isEqualTo(expected);
  }

}
