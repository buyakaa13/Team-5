package Lab7.Prob3;

public class Restaurant implements RestaurantInterface {
    private String restaurantName;
    private double baseDeliveryCharge;
    public double locationDistance;

    Restaurant(String restaurantName, double baseDeliveryCharge, double locationDistance) {
        this.restaurantName = restaurantName;
        this.baseDeliveryCharge = baseDeliveryCharge;
        this.locationDistance = locationDistance;
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }

    public double getLocationDistance() {
        return this.locationDistance;
    }

    @Override
    public double calculateDeliveryCharge() {
        return baseDeliveryCharge + (locationDistance * 0.5);
    }
}