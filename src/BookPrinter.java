public class BookPrinter implements Formatter<Book>{

  @Override
  public void printFormat(Book book) {
    System.out.println("Title: " + book.getTitle());
    System.out.println("Author: " + book.getAuthor());
    System.out.println("Year Published: " + book.getYearPublished());
    System.out.println("Price: $" + book.getPrice());
    System.out.println();
  }
  
}
