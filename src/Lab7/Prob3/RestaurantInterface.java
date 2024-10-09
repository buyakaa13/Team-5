package Lab7.Prob3;

import java.text.DecimalFormat;

public interface RestaurantInterface {
    String getRestaurantName();

    double calculateDeliveryCharge();

    static void printFormattedData(String restaurantName, String customerName, double orderAmount, double deliveryCharge, double discount, double totalAfterDiscount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Restaurant: " + restaurantName + "\n" + "Customer: " + customerName + "\n" + "Order Amount: $" + df.format(orderAmount) + "\n" + "Delivery Charge: $" + df.format(deliveryCharge) + "\n" + "Discount Applied: $" + df.format(discount) + "\n" + "Total after Discount: $" + df.format(totalAfterDiscount) + "\n" + "-------------------------------------------------------");
    }

    default double calculateDiscount(double totalOrderAmount) {
        return (totalOrderAmount > 100) ? totalOrderAmount / 100 * 5 : 0;
    }
}