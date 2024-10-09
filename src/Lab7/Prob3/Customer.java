package Lab7.Prob3;

public class Customer implements CustomerInterface {
    private String customerName;
    private int loyaltyPoints;

    Customer(String customerName, int loyaltyPoints) {
        this.customerName = customerName;
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}