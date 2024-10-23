package CoffeeShopSystem;

public class Manager extends Employee {
    public Manager(String employeeId, String firstName, String lastName, String username) {
        super(employeeId, firstName, lastName, username, EmployeeRole.MANAGER);
    }

    @Override
    public void takeOrder(Order order) {
        System.out.println("Manager " + getFirstName() + " is taking order: " + order);
    }

    @Override
    public void makePayment(Order order, Payment payment) {
        System.out.println("Manager " + getFirstName() + " is processing payment for order: " + order);
    }

    // view all employees added
    public void manageEmployee(ManageEmployee employeeManager) {
        System.out.println("Manager " + getFirstName() + " is managing employees.");
        employeeManager.listEmployees();
    }

    // View all menu items added
    public void manageMenuItems(MenuManager menuManager) {
        System.out.println("Manager " + getFirstName() + " is managing menu items.");
        menuManager.listMenuItems();
    }

    public void deleteEmployee(ManageEmployee employee, String employeeId) {
        employee.removeEmployee(employeeId);
    }

    public void deleteItem (MenuManager menuManager, long itemId) {
        menuManager.removeMenuItem(itemId);
    }
}
