package Lab7.Prob3;

import java.util.ArrayList;
import java.util.Random;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Sushi Palace", 5.0, 10.0));
        restaurants.add(new Restaurant("Pizza Corner", 3.5, 5.0));
        restaurants.add(new Restaurant("Burger World", 4.0, 7.5));
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", 60));
        customers.add(new Customer("Jane Smith", 40));
        customers.add(new Customer("Bob Johnson", 80));
        System.out.println("Welcome to the Food Delivery System!");
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < customers.size(); j++) {
                double deliveryCharge = restaurant.calculateDeliveryCharge();
                Customer customer = customers.get(j);
                boolean isLoyalty = customer.isLoyaltyCustomer(customer.getLoyaltyPoints());
                System.out.println("Processing order for Customer: " + customer.getCustomerName() + " at Restaurant: " + restaurant.getRestaurantName());
                System.out.println("Customer Loyalty Status: " + (isLoyalty ? "Loyal Customer" : "New Customer"));
                double orderAmount = randomNumber();
                double discount = restaurant.calculateDiscount(orderAmount);
                double totalAfterDiscount = orderAmount - discount;
                RestaurantInterface.printFormattedData(restaurant.getRestaurantName(), customer.getCustomerName(), orderAmount, deliveryCharge, discount, totalAfterDiscount);
            }
        }
    }

    private static double randomNumber() {
        return new Random().doubles(50, 200).iterator().nextDouble();
    }
}