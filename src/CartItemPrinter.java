/*
 * Class Name: CartItemPrinter
 * 
 * Class Description: This class implements the Printer interface. It will be used to format the details for the CartItem that can later be used by the user to view the details. It contains one method: printFormat. 
 */
public class CartItemPrinter implements Printer<CartItem> {

  @Override
  public void printFormat(CartItem item){
    // Prints out the <Item Name>: <Quantity>
    System.out.println(item.getName() + " - Quantity: " + item.getQuantity());
  
  }
  
}
