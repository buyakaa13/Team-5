package CoffeeShopSystem;

// MenuItem Class
public class MenuItem {
    private String itemId;
    private String itemName;
    private double price;
    private int quantity;
    private MenuCategory category;  // Category Enum

    public MenuItem(String itemId, String itemName, double price, int quantity, MenuCategory category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MenuCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Menu Item ID: " + itemId + ", Name: " + itemName + ", Price: $" + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}
