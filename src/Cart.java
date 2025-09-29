import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;
    private PrintManager printManager;
    
    public Cart() {
        items = new ArrayList<>();

    }

    public void setPrintManager(PrintManager pM){
        this.printManager = pM;
    }
    
    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }
    
    public void updateQuantity(CartItem item, int quantity) {
        for (CartItem cartItem : items) {
            if (cartItem.equals(item)) {
                cartItem.setQuantity(quantity);
                break;
            }
        }
    }
    
    public void viewCartDetails() {
        printManager.print(this);
    }
    
    public ArrayList<CartItem> getItems() {
        return items;
    }
}
