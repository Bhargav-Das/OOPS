public class Book {
    private String title;
    private String author;
    private int publicationYear;

    // Default constructor
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown Author";
        this.publicationYear = 0;
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.publicationYear = 0;
    }

    // Constructor with title, author, and publicationYear
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + (publicationYear != 0 ? publicationYear : "N/A"));
    }

    public static void main(String[] args) {
        // Creating book objects using different constructors
        Book book1 = new Book();
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Displaying details of each book
        book1.displayDetails();
        System.out.println();
        book2.displayDetails();
        System.out.println();
        book3.displayDetails();
    }
}
