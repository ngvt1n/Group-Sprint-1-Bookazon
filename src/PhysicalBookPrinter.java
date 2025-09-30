/*
 * Class name: PhysicalBookPrinter
 * 
 * Class description: This class implements the Printer interface to format the details for printing. 
 */

public class PhysicalBookPrinter implements Printer<PhysicalBook> {
  
  @Override
  public void printFormat(PhysicalBook book){ 
    System.out.println("Title: " + book.getTitle());
    System.out.println("Author: " + book.getAuthor());
    System.out.println("Year Published: " + book.getYearPublished());
    System.out.println("Cover: " + (book.isPaperback() ? "Paperback" : "Hardcover"));
    System.out.println("Price: $" + book.getPrice());
    System.out.println();
  }
}
