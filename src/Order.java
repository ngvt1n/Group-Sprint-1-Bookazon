/**
 * Class Name: Order.java
 *
 * Description: This class handles order details such as creation date, 
 *              shipment date, user information, items in the cart, 
 *              and calculates the final order price based on subscription discounts.
 * 
 */

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
 
     // Constants for discount percentages (no more magic numbers!)
     private static final double GOLD_DISCOUNT = 0.15;
     private static final double PLATINUM_DISCOUNT = 0.10;
     private static final double SILVER_DISCOUNT = 0.05;
 
     public Order(Cart cart, String subscription) {
         this.items = cart.getItems();
         this.orderPrice = calculatePrice(subscription);
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
 
     public double calculatePrice(String subscription) {
         double totalPrice = 0.0;
 
         for (CartItem item : items) {
             totalPrice += item.getTotalPrice();
         }
 
         // Use equalsIgnoreCase instead of '==' for string comparison
         if ("gold".equalsIgnoreCase(subscription)) {
             totalPrice *= (1 - GOLD_DISCOUNT); 
         } else if ("platinum".equalsIgnoreCase(subscription)) {
             totalPrice *= (1 - PLATINUM_DISCOUNT); 
         } else if ("silver".equalsIgnoreCase(subscription)) {
             totalPrice *= (1 - SILVER_DISCOUNT); 
         } 
 
         return totalPrice;
     }
 }
 