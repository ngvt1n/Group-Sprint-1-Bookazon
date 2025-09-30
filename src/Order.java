import java.util.ArrayList;
import java.util.List;

/**
 * Handles order details (dates, user, addresses, items) and delegates pricing
 * to Subscription + PricingPolicy. No string tier checks, no magic numbers.
 */
public class Order {
    private String dateCreated;
    private String dateShipped;
    private String userName;
    private String orderStatus;
    private Address shippingAddress;
    private Address billingAddress;
    private ArrayList<CartItem> items;
    private double orderPrice;

    public Order(Cart cart, Subscription subscription, PricingPolicy pricingPolicy) {
        // Defensive copy of cart items
        this.items = new ArrayList<>(cart.getItems());

        // Compute subtotal (pure aggregation)
        double subtotal = 0.0;
        for (CartItem it : items) {
            subtotal += it.getTotalPrice();
        }

        // Delegate pricing (branch-free, policy-driven)
        this.orderPrice = subscription.price(subtotal, pricingPolicy);
    }

    // --- Addresses ---
    public void setShippingAddress(Address address) { this.shippingAddress = address; }
    public void setBillingAddress(Address address)  { this.billingAddress  = address; }
    public Address getShippingAddress()             { return shippingAddress; }
    public Address getBillingAddress()              { return billingAddress; }

    // --- Status / Dates / User ---
    public void setOrderStatus(String status) { this.orderStatus = status; }
    public String getOrderStatus()            { return this.orderStatus; }

    public void setDateCreated(String date)   { this.dateCreated = date; }
    public String getDateCreated()            { return this.dateCreated; }

    public void setDateShipped(String date)   { this.dateShipped = date; }
    public String getDateShipped()            { return this.dateShipped; }

    public void setUserName(String name)      { this.userName = name; }
    public String getUserName()               { return this.userName; }

    // --- Items / Price ---
    public double getOrderPrice()             { return this.orderPrice; }

    /** Optional: expose a copy so printers can render line items without mutation risk. */
    public List<CartItem> getItems()          { return new ArrayList<>(items); }

    // --- Printing ---
    public void printOrderDetails(PrintManager pm) {
        pm.print(this);
    }
}