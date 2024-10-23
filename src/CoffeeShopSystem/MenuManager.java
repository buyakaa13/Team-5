package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItems;

    public MenuManager() {
        this.menuItems = new ArrayList<>();
    }

    // Add a new menu item
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        System.out.println("Menu item added: " + item);
    }

    // Update an existing menu item
    public void updateMenuItem(long itemId, String newItemName, double newPrice, MenuCategory newCategory) {
        for (MenuItem item : menuItems) {
            if (item.getItemId().equals(itemId)) {
                item.setItemName(newItemName);
                item.setPrice(newPrice);
                System.out.println("Menu item updated: " + item);
                return;
            }
        }
        System.out.println("Menu item with ID found: " + itemId);
    }

    // delete a menu item
    public void removeMenuItem(long itemId) {
        menuItems.removeIf(item -> item.getItemId().equals(itemId));
        System.out.println("Menu item with ID removed: " + itemId);
    }

    // get all menu items
    public void listMenuItems() {
        System.out.println("Listing all menu items:");
        for (MenuItem item : menuItems) {
            System.out.println(item);
        }
    }
}

