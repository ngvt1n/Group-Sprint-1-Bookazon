public class PhysicalBook extends Book {
    protected boolean isPaperback;

    public PhysicalBook(String title, String author, int yearPublished, double price, boolean isPaperback) {
        super(title, author, yearPublished, price);
        this.isPaperback = isPaperback;
    }

    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }

    @Override
    public void displayInfo() {
        System.out.println("📖 Physical Book: " + title + " by " + author +
                           " (" + yearPublished + "), $" + price +
                           (isPaperback ? " [Paperback]" : " [Hardcover]"));
    }
}
