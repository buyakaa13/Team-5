package CoffeeShopSystem.CoffeeShopSystemUIs;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.MainWindow;
import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class OrderListUI extends JFrame {

    public OrderListUI(HashMap<String, Order> orders) {

        setTitle("Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Check if orders are null or empty
        if (orders == null || orders.isEmpty()) {
            JLabel noOrdersLabel = new JLabel("No report available.", SwingConstants.CENTER);
            panel.add(noOrdersLabel, BorderLayout.CENTER);
        } else {
            String[] columnNames = {"Order ID", "Item(s)", "Total Amount", "Status"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            // Loop through orders and populate the table
            for (String key : orders.keySet()) {
                boolean firstRow = true;
                Order order = orders.get(key);
                for (MenuItem item : order.getItems()) {
                    if (firstRow) {
                        tableModel.addRow(new Object[]{
                                order.getOrderDate(),
                                order.getOrderId(),
                                item.getItemName() + " - " + item.getQuantity() + " pcs, $" + item.getPrice() + " each",
                                "$" + order.getTotalAmount(),
                                order.getStatus()
                        });
                        firstRow = false;
                    } else {
                        tableModel.addRow(new Object[]{
                                "",
                                item.getItemName() + " - " + item.getQuantity() + " pcs, $" + item.getPrice() + " each",
                                "",
                                ""
                        });
                    }
                }
            }

            JTable table = new JTable(tableModel) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make the cells non-editable
                }
            };

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        }

        JButton backButton = new JButton("Back");
        MainWindow mWindow = new MainWindow();
        mWindow.mframe.setVisible(true);
        backButton.addActionListener(e -> dispose()); // Close the current window

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        Order order1 = new Order();
        order1.addItem(new MenuItem(1, "Espresso", 2.5, 2, MenuCategory.COFFEE, ""));
        order1.addItem(new MenuItem(2, "Croissant", 1.5, 1, MenuCategory.DESSERT, ""));
        order1.addItem(new MenuItem(3, "Orange Juice", 3.0, 1, MenuCategory.BEVERAGE, ""));

        Order order2 = new Order();
        order2.addItem(new MenuItem(4, "Latte", 3.0, 1, MenuCategory.COFFEE, ""));
        order2.addItem(new MenuItem(5, "Muffin", 2.0, 2, MenuCategory.DESSERT, ""));

        HashMap<String, Order> orders = new HashMap<>();
        orders.put("ORD001", order1);
        orders.put("ORD002", order2);

//        SwingUtilities.invokeLater(() -> new OrderListUI(orders));
    }
}
