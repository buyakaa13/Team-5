package CoffeeShopSystem;

import java.util.UUID;

public class Payment {
    private String id;
    private double amount;
    private PaymentType type;

    public Payment(PaymentType type) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment Amount: $" + amount;
    }
}
