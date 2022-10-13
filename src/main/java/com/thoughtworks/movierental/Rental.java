package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;
    private Regular regular = new Regular();

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double amount() {
        double thisAmount = 0;
        //determine amounts for rental line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount = regular.amount(getDaysRented());
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3) {
                    thisAmount += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}