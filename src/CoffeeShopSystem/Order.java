package CoffeeShopSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private OrderStatus status;
    private List<MenuItem> items;

    public Order(String orderId, OrderStatus status) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = status;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Items: " + items;
    }
}
