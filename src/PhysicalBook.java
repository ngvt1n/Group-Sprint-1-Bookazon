/*
 * Class name: PhysicalBook 
 * 
 * Class Description: This extends the AbstractBook class and implements the methods for a Physical book. It has the methods PhysicalBook(), isPaperBack() and setPaperBack(). 
 */

public class PhysicalBook extends AbstractBook {
    protected boolean isPaperback;

    public PhysicalBook(String title, double price, String author, int yearPublished, boolean isPaperback) {
        super(title, price, author, yearPublished);
        this.isPaperback = isPaperback;
    }
    // is this a phycial book, is it a paperback
    public boolean isPaperback() {
        return isPaperback;
    }

    public void setPaperback(boolean isPaperback) {
        this.isPaperback = isPaperback;
    }
}
