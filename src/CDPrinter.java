public class CDPrinter implements Printer<CD> {
  
  @Override
  public void printFormat(CD cd){
    System.out.println("Title: " + cd.getTitle());
    System.out.println("Artist: " + cd.getArtist());
    System.out.println("Year: " + cd.getYear());
    System.out.println("Price: $" + cd.getPrice());
    System.out.println();
  }
}
