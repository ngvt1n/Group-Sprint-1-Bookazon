public class PhysicalBook implements Book {
    private String title;
    private String author;
    private int yearPublished;
    private double price;
    private boolean isPaperback;

    public PhysicalBook(String title, String author, int yearPublished, double price, boolean isPaperback) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
        this.isPaperback = isPaperback;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }

    // ⛔ Printing and validation could later be moved into separate utility/service classes
    public void printBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Price: $" + price);
    }

    public boolean isPriceValid() {
        return price > 0;
    }

    public boolean isTitleValid() {
        return title != null && !title.isEmpty();
    }

    public boolean isAuthorValid() {
        return author != null && !author.isEmpty();
    }

    public boolean isYearPublishedValid() {
        return yearPublished > 0;
    }
}
