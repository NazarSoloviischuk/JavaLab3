package org.example.view;

import org.example.model.Book;

import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public void showBooks(String title, Book[] books) {
        System.out.println();
        System.out.println(title);
        if (books.length == 0) {
            System.out.println("Книг не знайдено.");
            return;
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }

    public void showMenu() {
        System.out.println();
        System.out.println("=== Меню ===");
        System.out.println("1. Книги вказаного автора");
        System.out.println("2. Книги вказаного видавництва");
        System.out.println("3. Книги, видані пізніше вказаного року");
        System.out.println("4. Відсортувати книги за видавництвами");
        System.out.println("5. Показати всі книги");
        System.out.println("0. Вихід");
    }

    // Повертає номер пункту меню, а при некоректному введенні -1
    public int readChoice() {
        System.out.print("Ваш вибір: ");
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}