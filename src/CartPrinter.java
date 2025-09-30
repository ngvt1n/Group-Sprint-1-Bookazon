/*
 * Class Name: CartPrinter
 * 
 * Class Description: This class implements the Printer interface. This class will be used to format the details of items in the cart which can be used by the users to view the items inside the cart. 
 */
public final class CartPrinter implements Printer<Cart>{

  private final PrintManager printManager;

  // constructor setting the value for printer manager to be used for printing cartitems. 
  public CartPrinter(PrintManager pm) { 
    this.printManager = pm; 
  }

  // loops through the items in the cart and prints out individual details of the items in the cart using the formatter for cartItem. 
  public void printFormat(Cart curCart){
    System.out.println("Cart Details:");
    for(CartItem item: curCart.getItems()){
      printManager.print(item);

    }
    System.out.println();
  }
  
  
  
}
