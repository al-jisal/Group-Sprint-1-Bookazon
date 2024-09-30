public class Ebook extends CartItem {
    private String author;
    private int releaseYear;
    private double fileSize;
    private String format;   // PDF, EPUB, etc.

    public Ebook(String title, String author, int releaseYear, double fileSize, String format, double price, int quantity) {
        super(title, price, quantity);
        this.author = author;
        this.releaseYear = releaseYear;
        this.fileSize = fileSize;
        this.format = format;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    // Method to display Ebook details
    public void printCartItemDetails() {
        System.out.println("Title: " + getName());  // Using getName() from the parent class
        System.out.println("Author: " + author);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Format: " + format);
        System.out.println("Price: $" + getPrice());  // Using getPrice() from the parent class
    }

    // Validation methods
    public boolean isAuthorValid() {
        return author != null && !author.isEmpty();
    }

    public boolean isReleaseYearValid() {
        return releaseYear > 0;
    }

    public boolean isFileSizeValid() {
        return fileSize > 0;
    }

    public boolean isFormatValid() {
        return format != null && !format.isEmpty();
    }

}