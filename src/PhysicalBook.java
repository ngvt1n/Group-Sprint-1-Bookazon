public class PhysicalBook extends Book {
    public PhysicalBook(String title, String author, int yearPublished, double price, boolean isPaperback) {
        super(title, author, yearPublished, price, isPaperback);
    }

    @Override
    public void displayInfo() {
        System.out.println("📖 Physical Book: " + title + " by " + author +
                           " (" + yearPublished + "), $" + price +
                           (isPaperback ? " [Paperback]" : " [Hardcover]"));
    }
}
