import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

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
        this.shippingAddress = address;
    }

    public void setBillingAddress(Address address) {
        this.billingAddress = address;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void addToCart(AbstractMedia media, int quantity) {
        cart.addItem(new CartItem(media.getTitle(), media.getPrice(), quantity));
    }

    public Cart getCart() {
        return this.cart;
    }

    public void removeFromCart(AbstractMedia media) {
        // Use iterator to avoid ConcurrentModificationException
        Iterator<CartItem> it = cart.getItems().iterator();
        while (it.hasNext()) {
            CartItem item = it.next();
            if (item.getName().equals(media.getTitle())) {
                it.remove();
                break;
            }
        }
    }

    public void viewOrders(PrintManager pm) {
        for (Order order : orders) {
            pm.print(order);
        }
    }

    public void printCartWith(PrintManager pm) {
        pm.print(cart);
    }

    public void printOrdersWith(PrintManager pm) {
        for (Order order : orders) {
            pm.print(order);
        }
    }

    // Unified checkout: requires addresses to be set; creates Order using policy/tier.
    public void checkout() {
        if (shippingAddress == null || billingAddress == null) {
            System.out.println("Error: Shipping and billing addresses must be set before checkout.");
            return;
        }
        Order order = new Order(cart, this.subscription, this.pricingPolicy);
        order.setShippingAddress(shippingAddress);
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("Order Placed");
        order.setDateCreated(LocalDate.now().toString());
        order.setUserName(this.name);
        orders.add(order);
    }
}