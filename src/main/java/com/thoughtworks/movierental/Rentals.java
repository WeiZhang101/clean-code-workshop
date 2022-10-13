package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals extends ArrayList<Rental> {
    public Rentals() {
    }

    public double sum() {
        return this.stream().mapToDouble(Rental::amount).sum();
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    &&
                    rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }
}