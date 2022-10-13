package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    final Rentals rentals = new Rentals();
    private final TextStatement textStatement = new TextStatement();
    private final HtmlStatement htmlStatement = new HtmlStatement();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return textStatement.statement(getName(), rentals);
    }

    public String htmlStatement() {
        return htmlStatement.statement(getName(), rentals);
    }
}