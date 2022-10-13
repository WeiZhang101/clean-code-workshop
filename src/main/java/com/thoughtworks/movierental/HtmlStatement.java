package com.thoughtworks.movierental;

import java.util.List;
import java.util.stream.Collectors;

public class HtmlStatement {
    String statement(String customerName, Rentals rentals) {
        return htmlHeader(customerName).concat(htmlBody(rentals)).concat(htmlFooter(rentals.sum(), rentals.frequentRenterPoints()));
    }

    String htmlFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is <b>" + totalAmount + "</b> <br>" +
                "You earned <b>" + frequentRenterPoints + "</b> frequent renter points <br>" +
                "</body></html>";
    }

    String htmlBody(List<Rental> rentals) {
        List<String> movies = rentals.stream()
                .map(rental -> rental.getMovie().getTitle().concat(" " + rental.amount()).concat(" <br>"))
                .collect(Collectors.toList());
        return String.join("", movies);
    }

    String htmlHeader(String customerName) {
        return "<html><body>" + "<h1>Rental Record for <b>" + customerName + "</b> </h1><br>";
    }
}