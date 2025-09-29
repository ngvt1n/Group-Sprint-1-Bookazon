import java.util.ArrayList;

/**
 * Application facade for the Bookazon demo.
 */
public class Bookazon {


  private final ArrayList<AbstractBook> books;
  private final ArrayList<User> users;

  // Printing
  private final PrintManager printManager;

  /** 
  * Create an empty Bookazon store and register printers. 
  */
  public Bookazon() {
    this.books = new ArrayList<>();
    this.users = new ArrayList<>();

    // Register printers once
    this.printManager = new PrintManager();
    this.printManager.register(PhysicalBook.class, new PhysicalBookPrinter());
  }

  /** 
  * Add a book to the catalog.
  */
  public void addBook(AbstractBook book) {
    books.add(book);
  }

  /** 
  Add a user to the store. 
  */
  public void addUser(User user) {
    users.add(user);
  }

  /**
   * Print all books using the PrintManager.
   * (Replaces any direct calls like book.printBookDetails().)
   */
  public void viewBooks() {
    for (AbstractBook book : books) {
      printManager.print(book);
    }
  }

  /** 
  Simple user list output (adjust as needed). 
  */
  public void viewUsers() {
    for (User user : users) {
      System.out.println(user.getName() + " - Subscription: " + user.getSubscription());
    }
  }

  /** 
  Remove a book. 
  */
  public void removeBook(AbstractBook book) {
    books.remove(book);
  }

  /** 
  Remove a user. 
  */
  public void removeUser(User user) {
    users.remove(user);
  }


  public static void main(String[] args) {
    Bookazon app = new Bookazon();

    // Create PhysicalBook instances (match your project's constructor signature)
    app.addBook(new PhysicalBook("The Great Gatsby", 9.99, "F. Scott Fitzgerald", 1925, true));
    app.addBook(new PhysicalBook("To Kill a Mockingbird", 7.99, "Harper Lee", 1960, false));
    app.addBook(new PhysicalBook("1984", 8.99, "George Orwell", 1949, true));

    // Show books via PrintManager + PhysicalBookPrinter
    app.viewBooks();
  }
}
