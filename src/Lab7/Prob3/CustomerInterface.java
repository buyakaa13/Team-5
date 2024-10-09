package Lab7.Prob3;

public interface CustomerInterface {
    default boolean isLoyaltyCustomer(int loyaltypoints) {
        return loyaltypoints > 50 ? true : false;
    }

    public String getCustomerName();

    public int getLoyaltyPoints();
}
