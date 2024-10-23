package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.CoffeeShopSystemEnums.PaymentType;

public class TestClass {
    public static void main(String[] args) {
        // Create menu and employee managers
        MenuManager menuManager = new MenuManager();
        ManageEmployee employeeManager = new ManageEmployee();

        // Add manager
        Manager manager = new Manager("E001", "John", "Doe", "managerOne", "1234");
        // Add cashier
        Cashier cashier = new Cashier("E002", "Jane", "Smith", "cashierOne", "1234");

        employeeManager.addEmployee(manager);
        employeeManager.addEmployee(cashier);

        // Manager managing employees and menu items
        manager.manageEmployee(employeeManager);
        manager.deleteEmployee(employeeManager, "E002");

        MenuItem itemOne = new MenuItem("Cappuccino", 3.50, 1, MenuCategory.COFFEE, "");
        MenuItem itemTwo = new MenuItem("Blueberry Muffin", 2.50, 2, MenuCategory.SNACK, "");

        manager.addNewItem(menuManager, itemOne);
        manager.addNewItem(menuManager, itemTwo);

        manager.manageMenuItems(menuManager);

        // Create orders

        Order order1 = new Order();
        order1.addItem(new MenuItem("Cappuccino", 3.50, 1, MenuCategory.COFFEE, ""));
        Order order2 = new Order();
        order2.addItem(new MenuItem("Blueberry Muffin", 2.50, 2, MenuCategory.SNACK, "=-0987654q "));


        //cashier take order and make payment
        cashier.takeOrder(order1);
        cashier.makePayment(order1, new Payment(PaymentType.CARD));

        // Manager take orders and make payment
        manager.takeOrder(order2);
        manager.makePayment(order2, new Payment(PaymentType.CASH));

        manager.deleteItem(menuManager, 2);

    }
}

