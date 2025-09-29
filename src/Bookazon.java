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
            book.printBookDetails();
        }
    }

    public void viewUsers() {
        for (User user : users) {
            System.out.println(user.getName() + " - Role: " + user.getSubscription());
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void updateBookDetails(Book book, String newTitle, String newAuthor, int newYearPublished, double newPrice, boolean isPaperback) {
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setYearPublished(newYearPublished);
        book.setPrice(newPrice);
        book.setPaperback(isPaperback);
    }

    public void updateRole(User user, String role) {
        user.setSubscription(role);
    }

    
    public static void main(String[] args) {
        
        Bookazon bookazon = new Bookazon();
        
        // create books
        bookazon.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 9.99, true));
        bookazon.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 7.99, false));
        bookazon.addBook(new Book("1984", "George Orwell", 1949, 8.99, true));

        // create users
        User alice = new User("Alice", "normal", new Cart());
        User bob = new User("Bob", "gold", new Cart());
        bookazon.addUser(alice);
        bookazon.addUser(bob);

        // add books to cart
        alice.addToCart(bookazon.books.get(0), 1);
        alice.addToCart(bookazon.books.get(1), 2);

        // view cart
        bookazon.users.get(0).viewCart();

        // set shipping address and billing address
        Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
        Address billing  = new Address("456 Elm St", "", "Springfield", "IL", "62702", "USA");
        alice.setShippingAddress(shipping);
        alice.setBillingAddress(billing);

        // checkout
        alice.checkout(new Order(alice.getCart(), alice.getSubscription()));

        // view order details
        alice.viewOrders();     
    }
}
