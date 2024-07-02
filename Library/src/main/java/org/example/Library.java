package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }
    

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public Book searchBookByISBN(String isbn) throws NoSuchElementException {
            return books.stream()
                    .filter(book -> book.getIsbn().equals(isbn))
                    .findAny().get();
    }


    public void displayAllBooks() {
        books.forEach(System.out::println);
    }
}

