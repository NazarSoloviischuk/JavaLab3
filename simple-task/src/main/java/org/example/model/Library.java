package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Library {

    private final Book[] books;

    public Library(Book[] books) {
        this.books = books.clone();
    }

    public Book[] getBooks() {
        return books.clone();
    }

    // 1. Книги вказаного автора
    public Book[] findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }

    // 2. Книги вказаного видавництва
    public Book[] findByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }

    // 3. Книги, видані пізніше вказаного року
    public Book[] findPublishedAfter(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }

    // 4. Сортування за видавництвами (при однаковому видавництві за назвою)
    public Book[] sortByPublisher() {
        Comparator<Book> byPublisher = new Comparator<Book>() {
            @Override
            public int compare(Book a, Book b) {
                int result = a.getPublisher().compareTo(b.getPublisher());
                if (result != 0) {
                    return result;
                }
                return a.getTitle().compareTo(b.getTitle());
            }
        };

        Book[] sorted = books.clone();
        Arrays.sort(sorted, byPublisher);
        return sorted;
    }
}