package com.oxiane.katas.roman;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class RomanGlue {
  private int arabic;
  private String actual;

  @Given("arabic number is {int}")
  public void arabic_number_is(int arabic) {
    this.arabic = arabic;
  }
  @When("arabic number is converted to roman")
  public void arabic_number_is_converted_to_roman() {
    actual = RomanConverter.convertToRoman(arabic);
  }
  @Then("roman number returned is {word}")
  public void roman_number_returned_is(String expected) {
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
