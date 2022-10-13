package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    public String statement(String customerName, Rentals rentals) {
        return header(customerName).append(body(rentals)).append(footer(rentals.sum(), rentals.frequentRenterPoints())).toString();
    }

    StringBuilder header(String customerName) {
        return new StringBuilder("Rental Record for " + customerName + "\n");
    }

    StringBuilder body(List<Rental> rentals) {
        StringBuilder body = new StringBuilder();
        for (Rental rental : rentals) {
            double thisAmount = rental.amount();
            body.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
        }
        return body;
    }

    StringBuilder footer(double totalAmount, int frequentRenterPoints) {
        StringBuilder footer = new StringBuilder("");
        footer.append("Amount owed is ").append(totalAmount).append("\n");
        footer.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return footer;
    }
}