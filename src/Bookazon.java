/**
 * Class Name: Bookazon.java
 *
 * Description: Controller of the Bookazon system. Manages the media catalog
 *              and users, delegates printing to a PrintManager, and supports
 *              adding, removing, viewing, and updating records.
 */

import java.util.ArrayList;

/**
 * Application facade for the Bookazon demo.
 */
public class Bookazon {
    private ArrayList<AbstractMedia> catalog;
    private ArrayList<User> users;
    private PrintManager printManager;

    public Bookazon() {
        this.catalog = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void setPrintManager(PrintManager pm) {
        this.printManager = pm;
    }

    public void addMedia(AbstractMedia media) {
        // adds media to the catalog.
        catalog.add(media);
    }

    public void addUser(User user) {
        // adds users to the user list.
        users.add(user);
    }

    public void viewCatalog() {
        for (AbstractMedia media : catalog) {
            printManager.print(media);
        }
    }

    public void viewUsers() {
        // prints the users of the user list.
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

    // Keep scope aligned with the refactor (no String mapping here)
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

        // users (explicit variables, not list indexing)
        User alice = new User("Alice", new NormalSubscription(), policy);
        User bob   = new User("Bob",   new GoldSubscription(),   policy);
        bookazon.addUser(alice);
        bookazon.addUser(bob);

        // add to Alice's cart (assumes addToCart(AbstractMedia,int) exists)
        alice.addToCart(bookazon.catalog.get(0), 1);
        alice.addToCart(bookazon.catalog.get(1), 2);

        // view
        bookazon.viewCatalog();
        bookazon.viewUsers();

        // Alice’s cart
        System.out.println("== Alice's Cart ==");
        alice.printCartWith(pM);
        System.out.println();

        // addresses for Alice
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");
        alice.setShippingAddress(shipping);
        alice.setBillingAddress(billing);

        // checkout + orders (no-arg checkout that uses Subscription + PricingPolicy)
        alice.checkout();
        alice.printOrdersWith(pM);
    }
}
