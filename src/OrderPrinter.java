public class OrderPrinter implements Formatter<Order> {
  

  public void printFormat(Order order){
    System.out.println("Order Details:");
    System.out.println("Date Created: " + order.getDateCreated());
    System.out.println("Date Shipped: " + order.getDateShipped());
    System.out.println("User Name: " + order.getUserName());
    System.out.println("Order Status: " + order.getOrderStatus());
    System.out.println("Shipping Address: " + order.getShippingAddress().get(0) + ", " + order.getShippingAddress().get(1) + ", " + order.getShippingAddress().get(2) + ", " + order.getShippingAddress().get(3) + ", " + order.getShippingAddress().get(4) + ", " + order.getShippingAddress().get(5));
    System.out.println("Billing Address: " + order.getBillingAddress().get(0) + ", " + order.getBillingAddress().get(1) + ", " + order.getBillingAddress().get(2) + ", " + order.getBillingAddress().get(3) + ", " + order.getBillingAddress().get(4) + ", " + order.getBillingAddress().get(5));
    // System.out.println("Order Price: $" + order.rrderPrice);
  }
}
