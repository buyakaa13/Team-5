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
        manager.deleteEmployee(employeeManager, "E002");

        MenuItem itemOne = new MenuItem("M001", "Cappuccino", 3.50, 1, MenuCategory.COFFEE);
        MenuItem itemTwo = new MenuItem("M002", "Blueberry Muffin", 2.50, 2, MenuCategory.SNACK);

        manager.addNewItem(menuManager, itemOne);
        manager.addNewItem(menuManager, itemTwo);

        manager.manageMenuItems(menuManager);

        // Create orders
        Order order1 = new Order("O001", OrderStatus.PENDING);
        order1.addItem(itemOne);
        order1.addItem(itemTwo);
        Order order2 = new Order("O002", OrderStatus.PENDING);
        order2.addItem(itemTwo);

        //cashier take order and make payment
        cashier.takeOrder(order1);
        cashier.makePayment(order1, new Payment(3.50));

        // Manager take orders and make payment
        manager.takeOrder(order2);
        manager.makePayment(order2, new Payment(2.50));

        // Manager removes menu item
//        manager.deleteItem(menuManager, "M002");


    }
}

