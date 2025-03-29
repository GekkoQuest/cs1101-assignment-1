package quest.gekko.assignment;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Library LIBRARY = new Library();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();

            int choice = getChoice();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> searchBook();
                case 4 -> checkoutBook();
                case 5 -> returnBook();
                case 6 -> LIBRARY.listBooks();
                case 7 -> exitProgram();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add a Book");
        System.out.println("2. Remove a Book");
        System.out.println("3. Search for a Book");
        System.out.println("4. Checkout a Book");
        System.out.println("5. Return a Book");
        System.out.println("6. List All Books");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }


    private static int getChoice() {
        while (!SCANNER.hasNextInt()) {
            System.out.println("Invalid choice. Please enter a number.");
            SCANNER.next();
        }

        final int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        return choice;
    }

    private static void addBook() {
        System.out.println("Enter book title to add: ");
        String addTitle = SCANNER.nextLine();

        System.out.print("Enter author name: ");
        String addAuthor = SCANNER.nextLine();

        LIBRARY.addBook(addTitle, addAuthor);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.println("Enter book title to remove: ");
        final String removeTitle = SCANNER.nextLine();

        System.out.println(LIBRARY.removeBook(removeTitle)
                        ? "Book has been removed successfully."
                        : "Book not found.");
    }

    private static void searchBook() {
        System.out.println("Enter book title to search: ");
        final String searchTitle = SCANNER.nextLine();

        final Book book = LIBRARY.searchBook(searchTitle);

        System.out.println(book != null
                        ? "Book found: " + book
                        : "Book not found.");
    }

    private static void checkoutBook() {
        System.out.println("Enter book title to checkout: ");
        final String checkoutTitle = SCANNER.nextLine();

        final Book book = LIBRARY.searchBook(checkoutTitle);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already checked out.");
            return;
        }

        LIBRARY.checkoutBook(checkoutTitle);
        System.out.println("Book checked out successfully.");
    }

    private static void returnBook() {
        System.out.println("Enter book title to return: ");
        final String returnTitle = SCANNER.nextLine();

        final Book book = LIBRARY.searchBook(returnTitle);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is already checked out.");
            return;
        }

        LIBRARY.returnBook(returnTitle);
        System.out.println("Book returned successfully.");
    }

    private static void exitProgram() {
        System.out.println("Exiting program... Goodbye!");
        System.exit(0);
    }
}