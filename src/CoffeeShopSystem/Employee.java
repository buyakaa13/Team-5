package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemEnums.EmployeeRole;

abstract class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private EmployeeRole role;

    public Employee(String employeeId, String firstName, String lastName, String username, String password, EmployeeRole role) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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
    public String getPassword() {
        return password;
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
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(EmployeeRole newRole) {
        this.role = newRole;
    }
}
