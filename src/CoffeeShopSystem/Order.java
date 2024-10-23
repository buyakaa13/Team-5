package CoffeeShopSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order implements Serializable {
    private String orderId;
    private LocalDate orderDate;
    private List<MenuItem> items;
    private Employee employee;
    private OrderStatus status;
    private double totalAmount;
    private List<Payment> paymentList;

    public String getOrderId() {
        return orderId;
    }

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.orderDate = LocalDate.now();
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

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
