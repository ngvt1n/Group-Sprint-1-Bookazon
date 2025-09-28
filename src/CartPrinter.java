public final class CartPrinter implements Formatter<Cart>{

  private final PrintManager printManag;

  public CartPrinter(PrintManager pm) { 
    this.printManag = pm; 
  }

  public void printFormat(Cart curCart){
    System.out.println("Cart Details:");
    for(CartItem item: curCart.getItems()){
      printManag.print(item);

    }
    System.out.println();
  }
  
}
