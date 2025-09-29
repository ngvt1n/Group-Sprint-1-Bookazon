import java.util.ArrayList;

public class Bookazon {

    private ArrayList<Book> books;
    private ArrayList<User> users;
    private PrintManager printManager;

    public Bookazon() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void setPrintManager(PrintManager pm){
        this.printManager = pm;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewBooks() {
        for (Book book : books) {
            printManager.print(book);
        }
    }

    public void viewUsers() {
        for (User user : users) {
            printManager.print(user);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateRole(User user, String role) {
        user.setSubscription(role);
    }

    
    public static void main(String[] args) {

        // registering the different formatters for printing
        PrintManager pM = new PrintManager(Book.class, new BookPrinter());
        pM.register(CartItem.class, new CartItemPrinter());
        pM.register(Cart.class, new CartPrinter(pM));
        pM.register(Order.class, new OrderPrinter());
        pM.register(User.class, new UserPrinter());
        
        Bookazon bookazon = new Bookazon();
        bookazon.setPrintManager(pM);
        
        // create books
        bookazon.addBook(new PhysicalBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, true));
        bookazon.addBook(new PhysicalBook("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, false));
        bookazon.addBook(new PhysicalBook("1984", "George Orwell", 1949, 8.99, true));

        // create users
        bookazon.addUser(new User("Alice", "normal"));
        bookazon.addUser(new User("Bob", "gold"));

        // add books to cart
        bookazon.users.get(0).addToCart(bookazon.books.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.books.get(1), 2);


        // viewing the books in bookazon
        bookazon.viewBooks();

        // viewing the users in bookazon
        bookazon.viewUsers();


        // view Alice's cart
        System.out.println("== Alice's Cart ==");
        bookazon.users.get(0).printCartWith(pM);
        System.out.println();

        // set shipping address and billing address
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");

        // gets the addresses.
        bookazon.users.get(0).setShippingAddress(shipping);
        bookazon.users.get(0).setBillingAddress(billing);
        // checkout
        bookazon.users.get(0).checkout();

        // view order details
        // bookazon.users.get(0).viewOrders();
        bookazon.users.get(0).printOrdersWith(pM);
        
    }
}
