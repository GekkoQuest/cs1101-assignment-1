package quest.gekko.assignment;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final Library LIBRARY = new Library();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Checkout a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. List All Books");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String addTitle = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String addAuthor = scanner.nextLine();
                    LIBRARY.addBook(addTitle, addAuthor);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    if (LIBRARY.removeBook(removeTitle)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = LIBRARY.searchBook(searchTitle);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to checkout: ");
                    String checkoutTitle = scanner.nextLine();
                    LIBRARY.checkoutBook(checkoutTitle);
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    LIBRARY.returnBook(returnTitle);
                    break;
                case 6:
                    LIBRARY.listBooks();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}