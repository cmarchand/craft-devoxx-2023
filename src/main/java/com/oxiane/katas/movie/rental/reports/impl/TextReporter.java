package com.oxiane.katas.movie.rental.reports.impl;

import com.oxiane.katas.movie.rental.reports.ReportData;
import com.oxiane.katas.movie.rental.reports.Reporter;

public class TextReporter implements Reporter {
  @Override
  public String getReport(ReportData data) {
    return getReportHeader(data) + getReportBody(data) + getReportFooter(data);
  }
  private String getReportHeader(ReportData data) {
    return "Rental Record for " + data.getCustomerName() + "\n";
  }

  private String getReportBody(ReportData data) {
    String result = "";
    for (ReportData.RentalData rental: data.getRentals()) {
      result += getRentalReport(rental);
    }
    return result;
  }
  private String getRentalReport(ReportData.RentalData rental) {
    return "\t" + rental.title() + "\t" + rental.amount() + "\n";
  }


  private String getReportFooter(ReportData data) {
    return "Amount owed is " + data.getTotalAmount()  +
        "\nYou earned " + data.getTotalFrequentRenterPoint() + " frequent renter points";
  }

}
