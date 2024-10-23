package CoffeeShopSystem;

import java.io.Serializable;
import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;

// MenuItem Class
public class MenuItem implements Serializable {
    private long itemId;
    private String itemName;
    private double price;
    private int quantity;
    private MenuCategory category;  // Category Enum
    
    private String imagePath;

    private int selectedQty;

    public MenuItem(long itemId, String itemName, double price, int quantity, MenuCategory category, String imagePath) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.imagePath = imagePath;
    }

    // Getters and Setters

    public long getItemId() {
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

    public void setSelectedQty(int selectedQty) {
        this.selectedQty = selectedQty;
    }

    public int getSelectedQty() {
        return selectedQty;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Menu Item ID: " + itemId + ", Name: " + itemName + ", Price: $" + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}
