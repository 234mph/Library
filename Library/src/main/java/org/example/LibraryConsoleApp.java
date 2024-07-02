package org.example;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class LibraryConsoleApp {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Добро пожаловать в библиотекой");
            System.out.println("1) Добавить книгу");
            System.out.println("2) Удалить книгу");
            System.out.println("3) Поиск книг");
            System.out.println("4) Показать все книги");
            System.out.println("5) Выйти");
            System.out.print("Введите ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Завершение программы...");
                    return;
                default:
                    System.out.println("Неверный выбор. Введите число от 1 до 5.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите год издания: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, year, isbn);
        library.addBook(book);
        System.out.println("Книга добавлена!");
    }

    private static void removeBook() {
        System.out.print("Введите штрих-код для удаления: ");
        String isbn = scanner.nextLine();
        try {
            Book book = library.searchBookByISBN(isbn);
            library.removeBook(book);
        } catch (NoSuchElementException noSuchElementException){
            System.out.println("Нет такой книги");
        }
    }

    private static void searchBooks() {
        System.out.println("1. Поиск по названию");
        System.out.println("2. Поиск по автору");
        System.out.println("3. Поиск по году издания");
        System.out.print("Введите ваш выбор: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.print("Введите название для поиска: ");
                String searchTitle = scanner.nextLine();
                List<Book> books = library.searchBooksByTitle(searchTitle);
                System.out.println("Ваша книга: " + books);
                break;
            case 2:
                System.out.print("Введите автора для поиска: ");
                String searchAuthor = scanner.nextLine();
                List<Book> books1 = library.searchBooksByAuthor(searchAuthor);
                System.out.println("книга/книги с выбранным автоором" + books1);
                break;
            case 3:
                System.out.print("Введите год издания : ");
                int searchYear = scanner.nextInt();
                List<Book> books2 = library.searchBooksByYear(searchYear);
                System.out.println("Книги написанные в данном году: " + books2);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }
}