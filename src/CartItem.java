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

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CartItem)) return false;
    CartItem other = (CartItem) o;
    return itemName != null ? itemName.equals(other.itemName) : other.itemName == null;
}

/*
 * Collections (e.g., ArrayList.remove) call equals(Object),
 * so we must override it and also provide a matching hashCode.
 */
@Override
public int hashCode() {
    return itemName != null ? itemName.hashCode() : 0;
}

public double getTotalPrice() {
    return price * quantity;
}
}
