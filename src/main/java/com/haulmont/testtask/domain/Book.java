package com.haulmont.testtask.domain;

public class Book {

    private Long id;
    private Author author;
    private Genre genre;
    private Publisher publisher;
    private short year;
    private String city;

    public Book() {
    }

    public Book(Long id, Author author, Genre genre, Publisher publisher, short year, String city) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.year = year;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", genre=" + genre +
                ", publisher=" + publisher +
                ", year=" + year +
                ", city='" + city + '\'' +
                '}';
    }

}
