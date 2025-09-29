/**
 * Class Name: Cart.java
 *
 * Description: Represents a user's shopping cart. Manages cart items, 
 *              including adding, removing, updating quantities, and 
 *              delegating printing through a PrintManager.
 *
 */

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
        //Adds an item to the cart. 
        items.add(item);
    }

    public void removeItem(CartItem item) {
        //Removes an item from the cart. 
        items.remove(item);
    }
    
    public void updateQuantity(CartItem item, int quantity) {
        //Sets the quantity of the cart.
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
