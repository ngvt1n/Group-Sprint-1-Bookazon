import java.util.ArrayList;

public class Bookazon {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Bookazon() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void viewBooks() {
        for (Book book : books) {
            book.printBookDetails(); // keep simple for now
        }
    }

    public void viewUsers() {
        for (User user : users) {
            // NamedSubscription.toString() returns the code (e.g., "gold")
            System.out.println(user.getName() + " - Role: " + user.getSubscription());
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateBookDetails(Book book, String newTitle, String newAuthor,
                              int newYearPublished, double newPrice, boolean isPaperback) {
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setYearPublished(newYearPublished);
        book.setPrice(newPrice);
        book.setPaperback(isPaperback);
    }

    
    // Bookazon.java (now, typed subscriptions)
    public void updateRole(User user, Subscription sub) {
        user.setSubscription(sub);
    }


    public void updateRole(User user, String role) {
        user.setSubscription(new NamedSubscription(role));
    }

    public static void main(String[] args) {

        Bookazon bookazon = new Bookazon();

        // create books
        bookazon.addBook(new PhysicalBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, true));
        bookazon.addBook(new PhysicalBook("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, false));
        bookazon.addBook(new PhysicalBook("1984", "George Orwell", 1949, 8.99, true));

        PricingPolicy policy = new TablePricingPolicy();
        bookazon.addUser(new User("Alice", new NormalSubscription(), policy));
        bookazon.addUser(new User("Bob",   new GoldSubscription(),   policy));

        // add books to cart
        bookazon.users.get(0).addToCart(bookazon.books.get(0), 1);
        bookazon.users.get(0).addToCart(bookazon.books.get(1), 2);

        // view cart (if your Cart prints; if not, format via a helper)
        bookazon.users.get(0).viewCart();

        // set shipping address and billing address
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");

        // gets the addresses.
        bookazon.users.get(0).setShippingAddress(shipping);
        bookazon.users.get(0).setBillingAddress(billing);

        // checkout
        bookazon.users.get(0).checkout();

        bookazon.users.get(0).checkout();

        // view order details (if your Order prints; if not, format via a helper)
        bookazon.users.get(0).viewOrders();
    }
}
