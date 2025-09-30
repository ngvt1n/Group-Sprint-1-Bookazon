/**
 * Class Name: OrderPrinter.java
 *
 * Description: This class implements the Printer interface for Order objects. 
 *              It provides a formatted console output of all key order details, 
 *              including dates, user info, addresses, status, and total price.
 *
 */

 public class OrderPrinter implements Printer<Order> {
  
  /**
   * Prints formatted details of an Order object to the console.
   *
   * @param order the Order to print
   */
  @Override
  public void printFormat(Order order) {
      System.out.println("Order Details:");
      System.out.println("Date Created: " + order.getDateCreated());
      System.out.println("Date Shipped: " + order.getDateShipped());
      System.out.println("User Name: " + order.getUserName());
      System.out.println("Order Status: " + order.getOrderStatus());
      System.out.println("Shipping Address: " + order.getShippingAddress());
      System.out.println("Billing Address: " + order.getBillingAddress());
      System.out.println("Order Price: $" + order.getOrderPrice());
      System.out.println();
  }
}
