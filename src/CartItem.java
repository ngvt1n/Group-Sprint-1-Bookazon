/*
 * Class Name: CartItem
 * 
 * Class Description: This class implements the CartItem and defines the getter and setter methods for cart items. This class contains the following methods: CartItem(), getName(), getPrice(), getQuantity(), setQuantity(), equals() and getTotalPrice().
 * 
 * 
 */
public class CartItem {
    // defin fields for itemName, price and quantity 
    private String itemName;
    private double price;
    private int quantity;

    // CartItem constructor that sets itemName, price, and quantity
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    
    public String getName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // checks to see if the given item is the item being checked for
    public boolean equals(CartItem item) {
        return this.itemName.equals(item.getName());
    }

    // calculating total price for this item 
    public double getTotalPrice() {
        return price * quantity;
    }
}
