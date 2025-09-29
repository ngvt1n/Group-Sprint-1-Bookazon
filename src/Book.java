public abstract class Book {
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;

    public Book(String title, String author, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
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

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPriceValid() {
        return price > 0;
  
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Abstract method: subclasses must define how details are displayed
    public abstract void displayInfo();
}
