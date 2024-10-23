package CoffeeShopSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String username;
    private EmployeeRole role;

    public Employee(String employeeId, String firstName, String lastName, String username, EmployeeRole role) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.role = role;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public EmployeeRole getRole() {
        return role;
    }
    // Abstract methods
    public abstract void takeOrder(Order order);
    public abstract void makePayment(Order order, Payment payment);

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", First Name: " + firstName + ", Last Name: " + lastName + ", Username: " + username + ", Role: " + role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(EmployeeRole newRole) {
        this.role = newRole;
    }
}
