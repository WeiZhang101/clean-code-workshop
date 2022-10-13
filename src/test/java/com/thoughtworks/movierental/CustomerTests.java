package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void statementShouldReturnTextStmnt() {
        Customer customer = new Customer("Bob");

        customer.addRental(new Rental(new Movie("movie-1", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("movie-2", Movie.CHILDRENS), 10));
        customer.addRental(new Rental(new Movie("movie-2", Movie.NEW_RELEASE), 15));

        assertEquals("Rental Record for Bob\n" +
                "\tmovie-1\t6.5\n" +
                "\tmovie-2\t12.0\n" +
                "\tmovie-2\t45.0\n" +
                "Amount owed is 63.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void renderHtmlStatment() {
        Customer customer = new Customer("Bob");
        Movie movie = new Movie("movie-1", Movie.CHILDRENS);
        movie.setPriceCode(Movie.CHILDRENS);
        customer.addRental(new Rental(movie, 20));
        assertEquals("<html><body>" +
                "<h1>Rental Record for <b>Bob</b> </h1><br>" +
                "movie-1 27.0 <br>" +
                "Amount owed is <b>27.0</b> <br>" +
                "You earned <b>1</b> frequent renter points <br>" +
                "</body></html>", customer.htmlStatement());
    }
}