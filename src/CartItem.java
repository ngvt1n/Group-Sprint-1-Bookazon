public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

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
        return itemName != null && itemName.equals(other.itemName);
    }

    /*
     * Fix for: 
     * Java collections (like ArrayList.remove) call equals(Object), 
     * so Cart.removeItem(item) may fail to match.
     */

    @Override
    public int hashCode() {
        return itemName == null ? 0 : itemName.hashCode();
    }

    public double getTotalPrice() { 
        return price * quantity; 
    }
}
