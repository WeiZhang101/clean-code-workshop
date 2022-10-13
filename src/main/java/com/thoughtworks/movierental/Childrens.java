package com.thoughtworks.movierental;

public class Childrens extends PriceCode {

    public double amount(int daysRented) {
        double thisAmount = 0;
        thisAmount += 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }
}
