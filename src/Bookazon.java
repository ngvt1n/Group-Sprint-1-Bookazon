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

    public void updateRole(User user, String role) {
        user.setSubscription(role);
    }

    
    public static void main(String[] args) {
        
        // registering the different formatters for printing
        PrintManager pM = new PrintManager();
        pM.register(CartItem.class, new CartItemPrinter());
        pM.register(Cart.class, new CartPrinter(pM));
        pM.register(CD.class, new CDPrinter());
        pM.register(Order.class, new OrderPrinter());
        pM.register(PhysicalBook.class, new PhysicalBookPrinter());
        pM.register(User.class, new UserPrinter());
        
        Bookazon bookazon = new Bookazon();
        bookazon.setPrintManager(pM);
        
        // create catalog of products
        bookazon.addMedia(new PhysicalBook("The Great Gatsby", 9.99, "F. Scott Fitzgerald", 1925, true));
        bookazon.addMedia(new PhysicalBook("To Kill a Mockingbird", 7.99, "Harper Lee", 1960, false));
        bookazon.addMedia(new PhysicalBook("1984", 8.99, "George Orwell", 1949, true));
        bookazon.addMedia(new CD("Kind of Blue", 14.99, "Miles Davis", 1959));

        // create users
        User alice = new User("Alice", "normal");
        User bob = new User("Bob", "gold");
        bookazon.addUser(alice);
        bookazon.addUser(bob);

        // add books to cart
        alice.addToCart(bookazon.catalog.get(0), 1);
        alice.addToCart(bookazon.catalog.get(1), 2);

        // viewing the catalog in bookazon
        bookazon.viewCatalog();

        // viewing the users in bookazon
        bookazon.viewUsers();

        // view Alice's cart
        System.out.println("== Alice's Cart ==");
        bookazon.users.get(0).printCartWith(pM);
        System.out.println();

        // set shipping address and billing address
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");
        AddressValidator.validate(shipping);
        AddressValidator.validate(billing);
        alice.setShippingAddress(shipping);
        alice.setBillingAddress(billing);

        //Checkout.
        alice.checkout(new Order(alice.getCart(), alice.getSubscription()));

        // view order details
        alice.printOrdersWith(pM);
    }
}
