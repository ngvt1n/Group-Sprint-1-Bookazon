import java.util.ArrayList;

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
    this.items = new ArrayList<>(cart.getItems()); // Defensive copy
    double subtotal = 0.0;
    for (CartItem item : items) {
        subtotal += item.getTotalPrice();
    }
    this.orderPrice = pricingPolicy.apply(subtotal, subscription);
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

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public void setDateShipped(String date) {
        this.dateShipped = date;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Date Created: " + dateCreated);
        System.out.println("Date Shipped: " + dateShipped);
        System.out.println("User Name: " + userName);
        System.out.println("Order Status: " + orderStatus);
        //THIS NEEDS TO IMPLEMENTED BY WHOEVER IS FIXING PRINTING.
        //System.out.println("Shipping Address: " + (shippingAddress != null ? shippingAddress.formatForLabel() : "N/A"));
        //System.out.println("Billing Address: " + (billingAddress != null ? billingAddress.formatForLabel() : "N/A"));
        System.out.println("Order Price: $" + orderPrice);
    }

}

    // calculatePrice() deleted
