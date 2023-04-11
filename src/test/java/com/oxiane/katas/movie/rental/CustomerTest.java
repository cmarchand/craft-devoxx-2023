package com.oxiane.katas.movie.rental;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

  @Test
  public void given_no_rental_should_return_0_0() {
    // Given
    Customer customer = new Customer("Christophe");
    String expected = """
        Rental Record for Christophe
        Amount owed is 0.0
        You earned 0 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void given_one_regular_should_return_2_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Jaws", 0);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 1);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tJaws	2.0
        Amount owed is 2.0
        You earned 1 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void given_one_regular_for_3_days_should_return_35_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Jaws", 0);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 3);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tJaws	3.5
        Amount owed is 3.5
        You earned 1 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void given_one_new_release_should_return_3_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Super Mario", 1);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 1);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tSuper Mario	3.0
        Amount owed is 3.0
        You earned 1 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
  @Test
  public void given_one_new_release_for_2_days_should_return_3_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Super Mario", 1);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 2);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tSuper Mario	6.0
        Amount owed is 6.0
        You earned 2 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void given_one_childrens_should_return_15_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Le royaume de Naya", 2);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 1);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tLe royaume de Naya	1.5
        Amount owed is 1.5
        You earned 1 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void given_one_childrens_should_return_3_1() {
    // Given
    Customer customer = new Customer("Christophe");
    Customer.Movie movie = customer.new Movie("Le royaume de Naya", 2);
    Customer.Tape tape = new Customer.Tape("123456789", movie);
    Customer.Rental rental = new Customer.Rental(tape, 4);
    customer.addRental(rental);
    String expected = """
        Rental Record for Christophe
        \tLe royaume de Naya	3.0
        Amount owed is 3.0
        You earned 1 frequent renter points""";
    // When
    String actual = customer.statement();
    // Then
    Assertions.assertThat(actual).isEqualTo(expected);
  }
}
