
import java.util.ArrayList;

public class User {
    private String name;
    // private String subscription;

    // added in place of String subscription
    
    private Subscription subscription;
    private final PricingPolicy pricingPolicy;

    private Cart cart;
    private ArrayList<Order> orders;
    private String shippingAddressLine1;
    private String shippingAddressLine2;
    private String shippingAddressCity;
    private String shippingAddressState;
    private String shippingAddressZip;
    private String shippingAddressCountry;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressZip;
    private String billingAddressCountry;

    // replace your old constructor with:
    public User(String name, Subscription subscription, PricingPolicy pricingPolicy) {
        this.name = name;
        this.subscription = subscription;
        this.pricingPolicy = pricingPolicy;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    

    public Subscription getSubscription() { 
        return subscription; 
    }


    public void setSubscription(Subscription sub) { 
        this.subscription = sub; 
    }


    public void viewCart() {
        cart.viewCartDetails();
    }

    public void setShippingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.shippingAddressLine1 = line1;
        this.shippingAddressLine2 = line2;
        this.shippingAddressCity = city;
        this.shippingAddressState = state;
        this.shippingAddressZip = zip;
        this.shippingAddressCountry = country;
    }

    public void setBillingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.billingAddressLine1 = line1;
        this.billingAddressLine2 = line2;
        this.billingAddressCity = city;
        this.billingAddressState = state;
        this.billingAddressZip = zip;
        this.billingAddressCountry = country;
    }

    public void addToCart(Book book, int quantity) {
        cart.addItem(new CartItem(book.getTitle(), book.getPrice(), quantity));
    }

    public void removeFromCart(Book book) {
        for (CartItem item : cart.getItems()) {
            if (item.getName().equals(book.getTitle())) {
                cart.getItems().remove(item);
                break;
            }
        }
    }

    public void viewOrders() {
        for (Order order : orders) {
            order.printOrderDetails();
        }
    }

    public void checkout() {
        Order order = new Order(cart, this.subscription, this.pricingPolicy);
        order.setShippingAddress("123 Main St", "", "Springfield", "IL", "62701", "USA");
        order.setBillingAddress("123 Main St", "", "Springfield", "IL", "62701", "USA");
        order.setOrderStatus("Order Placed");
        order.setDateCreated("2024-01-01");
        order.setUserName(this.name);
        orders.add(order);
    }
}


