package com.oxiane.katas.movie.rental.reports;

import java.util.ArrayList;
import java.util.List;

public class ReportData {
  private final String customerName;
  private int totalFrequentRenterPoint;
  private double totalAmount;
  private final List<RentalData> rentals;

  public ReportData(String customerName) {
    this.customerName = customerName;
    totalAmount = 0d;
    totalFrequentRenterPoint = 0;
    rentals = new ArrayList<>();
  }

  public String getCustomerName() {
    return customerName;
  }
  public void addRental(RentalData rental) {
    rentals.add(rental);
    totalAmount += rental.amount();
    totalFrequentRenterPoint += rental.frequentRenterPoints();
  }

  public List<RentalData> getRentals() {
    return rentals;
  }

  public int getTotalFrequentRenterPoint() {
    return totalFrequentRenterPoint;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public record RentalData(String title, double amount, int frequentRenterPoints) { }
}
