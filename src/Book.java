public class Book extends CartItem {
    private String author;
    private int yearPublished;
    private boolean isPaperback;  // true if the book is paperback, false if it is hardcover

    public Book(String title, String author, int yearPublished, double price, boolean isPaperback, int quantity) {
        super(title, price, quantity);
        this.author = author;
        this.yearPublished = yearPublished;
        this.isPaperback = isPaperback;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }

    public String printCartItemDetails() {
        System.out.println("Title: " + getName());  // Using getName() from the parent class
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + getPrice());  // Using getPrice() from the parent class
        System.out.println("Paperback: " + (isPaperback ? "Yes" : "No"));
    }

    public void updateBookDetails(String newTitle, String newAuthor, int newYearPublished, double newPrice, boolean isPaperback) {
        setTitle(newTitle);
        setAuthor(newAuthor);
        setYearPublished(newYearPublished);
        setPrice(newPrice);
        setPaperback(isPaperback);
    }

    public boolean isPriceValid() {
        return getPrice() > 0;
    }

    public boolean isTitleValid() {
        return getName() != null && !getName().isEmpty();
    }

    public boolean isAuthorValid() {
        return author != null && !author.isEmpty();
    }

    public boolean isYearPublishedValid() {
        return yearPublished > 0;
    }
}