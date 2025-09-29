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
    this.items = new java.util.ArrayList<>(cart.getItems()); // defensive copy
    double subtotal = 0.0;
    for (CartItem it : items) subtotal += it.getTotalPrice();
    this.orderPrice = subscription.price(subtotal, pricingPolicy); // double-dispatch call
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

    public String getOrderStatus(){
        return this.orderStatus;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public String getDateCreated(){
        return this.dateCreated;
    }

    public void setDateShipped(String date) {
        this.dateShipped = date;
    }

    public String getDateShipped(){
        return this.dateShipped;
    }

    public void setUserName(String name) {
        this.userName = name;
    }
    
    public String getUserName(){
        return this.userName;
    }

    public double getOrderPrice(){
        return this.orderPrice;
    }

    public void printOrderDetails(PrintManager pm) {
        pm.print(this);
    }

}

    // calculatePrice() deleted
