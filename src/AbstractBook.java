public abstract class AbstractBook extends AbstractMedia {
    protected String author;
    protected int yearPublished;

    public AbstractBook(String title, double price, String author, int yearPublished) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean isPriceValid() {
        return price > 0;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
