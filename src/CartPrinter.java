
public final class CartPrinter implements Formatter<Cart>{

  private final PrintManager printManager;

  public CartPrinter(PrintManager pm) { 
    this.printManager = pm; 
  }

  public void printFormat(Cart curCart){
    System.out.println("Cart Details:");
    for(CartItem item: curCart.getItems()){
      printManager.print(item);

    }
    System.out.println();
  }
  
  
  
}
