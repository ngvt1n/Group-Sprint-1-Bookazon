public class CartItemPrinter implements Printer<CartItem> {

  @Override
  public void printFormat(CartItem item){
   
    System.out.println(item.getName() + " - Quantity: " + item.getQuantity());
  
  }
  
}
