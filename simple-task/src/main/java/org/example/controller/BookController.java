package org.example.controller;

import org.example.model.BookData;
import org.example.model.Library;
import org.example.view.ConsoleView;

import java.util.Random;

public class BookController {

    private final Library library;
    private final ConsoleView view;
    private final Random random = new Random();

    public BookController(Library library, ConsoleView view) {
        this.library = library;
        this.view = view;
    }

    public void run() {
        view.showBooks("Початковий набір книг:", library.getBooks());

        boolean running = true;
        while (running) {
            view.showMenu();
            int choice = view.readChoice();

            switch (choice) {
                case 1 -> findByAuthor();
                case 2 -> findByPublisher();
                case 3 -> findPublishedAfter();
                case 4 -> view.showBooks("Книги, відсортовані за видавництвами:", library.sortByPublisher());
                case 5 -> view.showBooks("Усі книги:", library.getBooks());
                case 0 -> running = false;
                default -> view.showMessage("Невірний пункт меню, спробуйте ще раз.");
            }
        }
        view.showMessage("Роботу завершено.");
    }

    private void findByAuthor() {
        String author = pick(BookData.SEARCH_AUTHORS);
        view.showBooks("Книги автора \"" + author + "\":", library.findByAuthor(author));
    }

    private void findByPublisher() {
        String publisher = pick(BookData.SEARCH_PUBLISHERS);
        view.showBooks("Книги видавництва \"" + publisher + "\":", library.findByPublisher(publisher));
    }

    private void findPublishedAfter() {
        int year = BookData.SEARCH_YEARS[random.nextInt(BookData.SEARCH_YEARS.length)];
        view.showBooks("Книги, видані пізніше " + year + " року:", library.findPublishedAfter(year));
    }

    private String pick(String[] values) {
        return values[random.nextInt(values.length)];
    }
}