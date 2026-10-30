package org.example;

import org.example.controller.BookController;
import org.example.model.BookData;
import org.example.model.Library;
import org.example.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(BookData.createBooks());
        ConsoleView view = new ConsoleView();
        new BookController(library, view).run();
    }
}