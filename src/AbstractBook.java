/**
 * Class Name: Address.java
 * 
 * Description: This class stores common address fields such as line1, line2, 
 *              city, state, zip code, and country. It provides getters and 
 *              setters for each field and includes a utility method to 
 *              format the address for label printing.
 */

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
        //checks if price is valid. 

        return price > 0;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
