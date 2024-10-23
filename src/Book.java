public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private int publicationYear;
    private String genre;
    private int timesCheckedOut;

    public Book(String title, String author, String isbn, boolean isAvailable, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.timesCheckedOut = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public int getTimesCheckedOut() {
        return timesCheckedOut;
    }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            timesCheckedOut++;
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    public void returnBook() {
        if (!isAvailable) { //
            isAvailable = true;
        } else {
            System.out.println("Book was not checked out.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}