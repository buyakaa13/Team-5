package CoffeeShopSystem;

public class TestClass {
    public static void main(String[] args) {
        // Create menu and employee managers
        MenuManager menuManager = new MenuManager();
        ManageEmployee employeeManager = new ManageEmployee();

        // Add manager
        Manager manager = new Manager("E001", "John", "Doe", "managerOne");
        // Add cashier
        Cashier cashier = new Cashier("E002", "Jane", "Smith", "cashierOne");

        employeeManager.addEmployee(manager);
        employeeManager.addEmployee(cashier);

        // Manager managing employees and menu items
        manager.manageEmployee(employeeManager);
        manager.manageMenuItems(menuManager);
        manager.deleteEmployee(employeeManager, "E002");

        // Create orders
        Order order1 = new Order("O001");
        order1.addItem(new MenuItem("M001", "Cappuccino", 3.50, 1, MenuCategory.COFFEE));
        Order order2 = new Order("O002");
        order2.addItem(new MenuItem("M002", "Blueberry Muffin", 2.50, 2, MenuCategory.SNACK));

        //cashier take order and make payment
        cashier.takeOrder(order1);
        cashier.makePayment(order1, new Payment(3.50));

        // Manager take orders and make payment
        manager.takeOrder(order2);
        manager.makePayment(order2, new Payment(2.50));

        // Manager removes menu item
        manager.deleteItem(menuManager, "M002");


    }
}

