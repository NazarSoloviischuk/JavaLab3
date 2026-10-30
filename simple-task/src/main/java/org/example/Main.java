package org.example;

import org.example.model.Book;
import org.example.model.BookData;
import org.example.model.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(BookData.createBooks());

        System.out.println("Іван Франко:");
        for (Book b : library.findByAuthor("Іван Франко")) {
            System.out.println(b);
        }

        System.out.println("Видані пізніше 2018:");
        for (Book b : library.findPublishedAfter(2018)) {
            System.out.println(b);
        }

        System.out.println("За видавництвами:");
        for (Book b : library.sortByPublisher()) {
            System.out.println(b);
        }
    }
}