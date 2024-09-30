public class DVD extends CartItem {
    private String producer;
    private int releaseYear;
    private int showDuration;

    public DVD(String showTitle, String producer, int releaseYear, double price, int showDuration, int quantity) {
        super(showTitle, price, quantity);
        this.producer = producer;
        this.releaseYear = releaseYear;
        this.showDuration = showDuration;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void releaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getShowDuration() {
        return showDuration;
    }

    public void setShowDuration(int showDuration) {
        this.showDuration = showDuration;
    }

    public void printCartItemDetails() {
        System.out.println("Title: " + getName());  // Using getName() from the parent class
        System.out.println("Producer: " + producer);
        System.out.println("Year Released: " + releaseYear);
        System.out.println("Price: $" + getPrice());  // Using getPrice() from the parent class
        System.out.println("Duration of show: " + showDuration);
    }

    public boolean isPriceValid() {
        return getPrice() > 0;
    }

    public boolean isTitleValid() {
        return getName() != null && !getName().isEmpty();
    }

    public boolean isProducerValid() {
        return producer != null && !producer.isEmpty();
    }

    public boolean isReleaseYearValid() {
        return releaseYear > 0;
    }
}