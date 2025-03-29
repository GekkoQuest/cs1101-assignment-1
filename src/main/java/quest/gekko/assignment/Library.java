package quest.gekko.assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    /**
     * Adds a new book to the library with the given title and author.
     * @param title - The title of the book.
     * @param author - The author of the book.
     */
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }


    /**
     * @param title - The book to remove by its title.
     * @return - True if the book was removed, false if it was not found.
     */
    public boolean removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for a book by its title.
     * @param title - The title of the book to look for
     * @return - The matching book if found, otherwise null.
     */
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Checks if a book is available and marks it as checked out if possible.
     * @param title - The title of the book to check out.
     */
    public void checkoutBook(String title) {
        final Book book = searchBook(title);
        book.checkout();
    }

    /**
     * Marks a previously checked-out book as available.
     * @param title - The title of the book to return.
     */
    public void returnBook(String title) {
        final Book book = searchBook(title);
        book.returnBook();
    }

    /**
     * Displays all available books in the library.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
