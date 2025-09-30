import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Customer aggregate: holds cart, subscription, addresses.
 * Checkout accepts a prebuilt Order (DIP: creation is outside User).
 */
public class User {
    private String name;
    private Subscription subscription;
    private final PricingPolicy pricingPolicy;

    private final Cart cart;
    private final ArrayList<Order> orders;
    private Address shippingAddress;
    private Address billingAddress;

    public User(String name, Subscription subscription, PricingPolicy pricingPolicy) {
        this.name = name;
        this.subscription = subscription;
        this.pricingPolicy = pricingPolicy;
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public String getName() { return name; }
    public Subscription getSubscription() { return subscription; }
    public void setSubscription(Subscription sub) { this.subscription = sub; }
    /** Expose policy so callers can build an Order without a factory. */
    public PricingPolicy getPricingPolicy() { return pricingPolicy; }
    public Cart getCart() { return this.cart; }

    public void viewCart() { cart.viewCartDetails(); }
    public void setShippingAddress(Address address) { this.shippingAddress = address; }
    public void setBillingAddress(Address address) { this.billingAddress = address; }
    public Address getShippingAddress() { return shippingAddress; }
    public Address getBillingAddress() { return billingAddress; }

    public void addToCart(AbstractMedia media, int quantity) {
        cart.addItem(new CartItem(media.getTitle(), media.getPrice(), quantity));
    }

    public void removeFromCart(AbstractMedia media) {
        Iterator<CartItem> it = cart.getItems().iterator();
        while (it.hasNext()) {
            CartItem item = it.next();
            if (item.getName().equals(media.getTitle())) {
                it.remove();
                break;
            }
        }
    }

    public void printCartWith(PrintManager pm) { pm.print(cart); }
    public void printOrdersWith(PrintManager pm) { for (Order o : orders) pm.print(o); }

    /**
     * Checkout by enriching a prebuilt Order and recording it.
     * Validates that addresses exist and order is non-null.
     */
    public void checkout(Order order) {
        if (order == null) {
            System.out.println("Error: order cannot be null.");
            return;
        }
        if (shippingAddress == null || billingAddress == null) {
            System.out.println("Error: Shipping and billing addresses must be set before checkout.");
            return;
        }
        order.setShippingAddress(shippingAddress);
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("Order Placed");
        order.setDateCreated(LocalDate.now().toString());
        order.setUserName(this.name);
        orders.add(order);
    }
}
