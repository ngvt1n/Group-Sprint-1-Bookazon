public abstract class Book {
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;
    protected boolean isPaperback;

    public Book(String title, String author, int yearPublished, double price, boolean isPaperback) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
        this.isPaperback = isPaperback;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPaperback() {
        return isPaperback;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }

    // Abstract method: subclasses must define how details are displayed
    public abstract void displayInfo();
}
