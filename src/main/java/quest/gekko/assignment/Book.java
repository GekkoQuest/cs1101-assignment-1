package quest.gekko.assignment;

public class Book {
    private final String title;
    private final String author;

    private boolean isAvailable;

    /**
     * Creates a new book with the specified title and author.
     * The book is available for checkout by default.
     *
     * @param title - The title of the book.
     * @param author - The author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Marks the book as unavailable if it's currently available.
     */
    public void checkout() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    /**
     * Marks the book as available if it's currently checked out.
     */
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
        }
    }

    /**
     * Returns a formatted string of the book's details.
     * @return The title, author, and availability status.
     */
    @Override
    public String toString() {
        return "Title: " + title
                + ", Author: " + author
                + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}