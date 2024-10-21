package CoffeeShopSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<MenuItem> items;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Items: " + items;
    }
}
