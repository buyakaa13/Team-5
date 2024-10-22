package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemEnums.EmployeeRole;

public class Cashier extends Employee {
    public Cashier(String employeeId, String firstName, String lastName, String username, String password) {
        super(employeeId, firstName, lastName, username, password, EmployeeRole.CASHIER);
    }

    @Override
    public void takeOrder(Order order) {
        System.out.println("Cashier " + getFirstName() + " is taking order: " + order);
    }

    @Override
    public void makePayment(Order order, Payment payment) {
        System.out.println("Cashier " + getFirstName() + " is processing payment for order: " + order);
    }
}

