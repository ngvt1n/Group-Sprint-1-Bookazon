/**
 * Class Name: AbstractMedia.java
 * 
 * Description: Provides the abstract implementation and functionality
 *              of Media types
 * 
 */

public abstract class AbstractMedia {
    protected String title;
    protected double price;

    protected String getTitle() { return title; } 
    protected double getPrice() { return price; }
    protected void setTitle(String title) { this.title = title; }
    protected void setPrice(double price) { this.price = price; }
}
