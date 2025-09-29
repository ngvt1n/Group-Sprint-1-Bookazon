import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String subscription;
    private Cart cart;
    private ArrayList<Order> orders;
    private Address shippingAddress;
    private Address billingAddress;

    public User(String name, String subscription) {
        this.name = name;
        this.subscription = subscription;  // normal, gold, platinum, silver membership
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String role) {
        this.subscription = role;
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

    public void addToCart(AbstractMedia media, int quantity) {
        cart.addItem(new CartItem(media.getTitle(), media.getPrice(), quantity));
    }
    
    public Cart getCart(){
        return this.cart;
    }

    public void removeFromCart(AbstractMedia media) {
        for (CartItem item : cart.getItems()) {
            if (item.getName().equals(media.getTitle())) {
                cart.getItems().remove(item);
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

   public void checkout(Order order) {
        // Finalizes checkout by validating addresses, filling order details, and saving it to the user's order history.

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
