package com.oxiane.katas.movie.rental;

import com.oxiane.katas.movie.rental.reports.ReportData;
import com.oxiane.katas.movie.rental.reports.Reporter;
import com.oxiane.katas.movie.rental.reports.impl.TextReporter;

import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class Customer {
  private Reporter reporter;

  public static class Tape {

    private final String _serialNumber;
    private final Movie _movie;

    public Tape(String serialNumber, Movie movie) {
      _serialNumber = serialNumber;
      _movie = movie;
    }

    public Movie movie() {
      return _movie;
    }

    public String serialNumber() {
      return _serialNumber;
    }
  }


  public static class Rental {

    private final Tape _tape;
    private final int _daysRented;

    public Rental(Tape tape, int daysRented) {
      _tape = tape;
      _daysRented = daysRented;
    }

    public int daysRented() {
      return _daysRented;
    }

    public Tape tape() {
      return _tape;
    }
  }


  public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final int _priceCode;
    private final String _name;

    public Movie(String name, int priceCode) {
      _name = name;
      _priceCode = priceCode;
    }

    public int priceCode() {
      return _priceCode;
    }

    public String name() {
      return _name;
    }
  }


  private final String _name;
  private final List<Rental> _rentals = new ArrayList<>();

  public Customer(String name) {
    _name = name;
  }

  public String statement() {
    return generateReport();
  }

  private String generateReport() {
    ReportData data = new ReportData(name());
    for(Rental rental: _rentals) {
      data.addRental(new ReportData.RentalData(
          rental.tape().movie().name(),
          MovieTypeStrategy
              .of(rental.tape().movie().priceCode())
              .calculateAmount(rental),
          MovieTypeStrategy
              .of(rental.tape().movie().priceCode())
              .calculateFrequentRenterPoints(rental)));
    }
    return getReporter().getReport(data);
  }

  private Reporter getReporter() {
    if(reporter==null) reporter = new TextReporter();
    return reporter;
  }

  private String name() {
    return _name;
  }

  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  private enum MovieTypeStrategy {
    REGULAR(Movie.REGULAR, rental -> {
      double amount = 2;
      if (rental.daysRented() > 2)
        amount += (rental.daysRented() - 2) * 1.5;
      return amount;
    }, rental -> 1),
    NEW_RELEASE(Movie.NEW_RELEASE,
        rental -> rental.daysRented() * 3.0,
        rental -> rental.daysRented() > 1 ? 2 : 1),
    CHILDRENS(Movie.CHILDRENS, rental -> {
      double amount = 1.5;
      if (rental.daysRented() > 3)
        amount += (rental.daysRented() - 3) * 1.5;
      return amount;
    }, rental -> 1)
    ;

    private final int priceCode;
    private final ToDoubleFunction<Rental> amountCalculator;
    private final ToIntFunction<Rental> frequentRenterPointsCalculator;

    MovieTypeStrategy(int priceCode, ToDoubleFunction<Rental> amountCalculator, ToIntFunction<Rental> frequentRenterPointsCalculator) {
      this.priceCode = priceCode;
      this.amountCalculator = amountCalculator;
      this.frequentRenterPointsCalculator = frequentRenterPointsCalculator;
    }

    public static MovieTypeStrategy of(int priceCode) {
      return Arrays.stream(values())
          .filter(movieTypeStrategy -> movieTypeStrategy.priceCode==priceCode)
          .findFirst()
          .orElseThrow();
    }

    public double calculateAmount(Rental rental) {
      return amountCalculator.applyAsDouble(rental);
    }

    public int calculateFrequentRenterPoints(Rental rental) {
      return frequentRenterPointsCalculator.applyAsInt(rental);
    }
  }
}
