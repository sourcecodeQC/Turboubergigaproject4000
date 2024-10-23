import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Fetch books from CSV file and populate the library
        fetchBooks(library);

        // Example: List all available books
        library.listAvailableBooks();
    }

    public static void fetchBooks(Library library) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/Library_Books_Sample.csv"));
            for (String line : lines) {
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                String isbn = parts[2];

                try {
                    int publicationYear = Integer.parseInt(parts[4]);
                    boolean isAvailable = Boolean.parseBoolean(parts[3]);
                    String genre = parts[5];
                    Book book = new Book(title, author, isbn, isAvailable, publicationYear, genre);
                    library.addBook(book);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid publication year for book: " + title);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}