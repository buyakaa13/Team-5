package CoffeeShopSystem;

import java.io.Serializable;
import java.time.LocalDate;
import CoffeeShopSystem.CoffeeShopSystemEnums.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements Serializable {
    private String orderId;
    private LocalDate orderDate;
    private OrderStatus status;
    private List<MenuItem> items;
    private Employee employee;
    private double totalAmount;
    private List<Payment> paymentList;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.orderDate = LocalDate.now();
        this.status = OrderStatus.PENDING;
        this.items = new ArrayList<>();
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

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
