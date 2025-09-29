import java.util.ArrayList;

/**
 * Application facade for the Bookazon demo.
 */
public class Bookazon {

import java.util.ArrayList;

public class Bookazon {
    private ArrayList<AbstractMedia> catalog;
    private ArrayList<User> users;
    private PrintManager printManager;

    public Bookazon() {
        catalog = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void setPrintManager(PrintManager pm){
        this.printManager = pm;
    }

    public void addMedia(AbstractMedia media) {
        catalog.add(media);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewCatalog() {
        for (AbstractMedia media: catalog) {
            printManager.print(media);
        }
    }

    public void viewUsers() {
        for (User user : users) {
            printManager.print(user);
        }
    }

    public void removeMedia(AbstractMedia media) {
        catalog.remove(media);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    // Keep scope aligned with your refactor (no String mapping here)
    public void updateRole(User user, Subscription sub) {
        user.setSubscription(sub);
    }

    public static void main(String[] args) {
        // register printers
        PrintManager pM = new PrintManager();
        pM.register(CartItem.class, new CartItemPrinter());
        pM.register(Cart.class, new CartPrinter(pM));
        pM.register(CD.class, new CDPrinter());
        pM.register(Order.class, new OrderPrinter());
        pM.register(PhysicalBook.class, new PhysicalBookPrinter());
        pM.register(User.class, new UserPrinter());

        Bookazon bookazon = new Bookazon();
        bookazon.setPrintManager(pM);

        // catalog
        bookazon.addMedia(new PhysicalBook("The Great Gatsby", 9.99, "F. Scott Fitzgerald", 1925, true));
        bookazon.addMedia(new PhysicalBook("To Kill a Mockingbird", 7.99, "Harper Lee", 1960, false));
        bookazon.addMedia(new PhysicalBook("1984", 8.99, "George Orwell", 1949, true));
        bookazon.addMedia(new CD("Kind of Blue", 14.99, "Miles Davis", 1959));

        // pricing setup
        PricingPolicy policy = new TablePricingPolicy();

        // users (choose your concrete Subscription types)
        bookazon.addUser(new User("Alice", new NormalSubscription(), policy));
        bookazon.addUser(new User("Bob",   new GoldSubscription(),   policy));

        // add to cart (assumes User.addToCart(AbstractMedia,int) exists)
        bookazon.users.get(0).addToCart(bookazon.catalog.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.catalog.get(1), 2);

        // view
        bookazon.viewCatalog();
        bookazon.viewUsers();

        // Alice’s cart
        System.out.println("== Alice's Cart ==");
        bookazon.users.get(0).printCartWith(pM);
        System.out.println();

        // addresses
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");
        bookazon.users.get(0).setShippingAddress(shipping);
        bookazon.users.get(0).setBillingAddress(billing);

        // checkout + orders
        bookazon.users.get(0).checkout();
        bookazon.users.get(0).printOrdersWith(pM);
    }
}

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
