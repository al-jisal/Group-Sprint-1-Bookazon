public class AudioBook extends CartItem {
    private String author;
    private String reader;
    private int audioDuration;
    private int releaseYear;

    public AudioBook(String title, String author, String reader, int audioDuration, int releaseYear, double price, int quantity) {
        super(title, price, quantity);
        this.author = author;
        this.reader = reader;
        this.audioDuration = audioDuration;
        this.releaseYear = releaseYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public int getAudioDuration() {
        return audioDuration;
    }

    public void setAudioDuration(int length) {
        this.audioDuration = audioDuration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void printCartItemDetails() {
        System.out.println("Title: " + getName());  // Using getName() from the parent class
        System.out.println("Author: " + author);
        System.out.println("Narrator: " + narrator);
        System.out.println("Duration of audio: " + audioDuration + " minutes");
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Price: $" + getPrice());  // Using getPrice() from the parent class
    }

    // Validation methods
    public boolean isAuthorValid() {
        return author != null && !author.isEmpty();
    }

    public boolean isNarratorValid() {
        return narrator != null && !narrator.isEmpty();
    }

    public boolean isLengthValid() {
        return length > 0;
    }

    public boolean isReleaseYearValid() {
        return releaseYear > 0;
    }

}