import java.util.ArrayList;

public class User {
    private String name;
    // private String subscription;

    // added in place of String subscription
    
    private Subscription subscription;
    private final PricingPolicy pricingPolicy;

    private Cart cart;
    private ArrayList<Order> orders;
    private Address shippingAddress;
    private Address billingAddress;

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

    public void setShippingAddress(Address address) {
        //Sets shipping address.
        this.shippingAddress = address;
    }

    public void setBillingAddress(Address address) {
        //Sets billing address.
        this.billingAddress = address;
    }

    public Address getBillingAddress() {
        //Returns billing address. 
        return billingAddress;
    }
    public Address getShippingAddress() {
        //Returns Shipping address. 
        return shippingAddress;
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
    Address shipping = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
    Address billing  = new Address("123 Main St", "", "Springfield", "IL", "62701", "USA");
    order.setShippingAddress(shipping);
    order.setBillingAddress(billing);
    order.setOrderStatus("Order Placed");
    order.setDateCreated("2024-01-01");
    order.setUserName(this.name);
    orders.add(order);
}

}