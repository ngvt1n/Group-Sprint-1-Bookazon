public class PhysicalBook extends AbstractBook {
    protected boolean isPaperback;

    public PhysicalBook(String title, double price, String author, int yearPublished, boolean isPaperback) {
        super(title, price, author, yearPublished);
        this.isPaperback = isPaperback;
    }

    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }
}
