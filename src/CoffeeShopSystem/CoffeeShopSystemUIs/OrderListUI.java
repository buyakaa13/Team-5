package CoffeeShopSystem.CoffeeShopSystemUIs;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.MenuItem;
import CoffeeShopSystem.Order;
import CoffeeShopSystem.CoffeeShopSystemEnums.OrderStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class OrderListUI extends JFrame {

    public OrderListUI(List<Order> orders) {
        // Set up the frame
        setTitle("Order List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Panel for holding the table and the back button
        JPanel panel = new JPanel(new BorderLayout());

        // Create table for the orders
        String[] columnNames = {"Order ID", "Item(s)", "Total Amount", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Loop through orders and populate the table
        for (Order order : orders) {
            boolean firstRow = true; // Track whether it's the first row for this order
            for (CoffeeShopSystem.MenuItem item : order.getItems()) {
                if (firstRow) {
                    // Add a row for the first item in the order with all columns populated
                    tableModel.addRow(new Object[]{
                            order.getOrderId(),
                            item.getItemName() + " - " + item.getQuantity() + " pcs, $" + item.getPrice() + " each",
                            "$" + order.getTotalAmount(),
                            order.getStatus()
                    });
                    firstRow = false; // Subsequent rows for this order won't include Order ID, Total, and Status
                } else {
                    // Add a row for the next item with only the item data
                    tableModel.addRow(new Object[]{
                            "", // Leave order ID empty for subsequent rows
                            item.getItemName() + " - " + item.getQuantity() + " pcs, $" + item.getPrice() + " each",
                            "", // Leave total amount empty for subsequent rows
                            ""  // Leave status empty for subsequent rows
                    });
                }
            }
        }

        // Create JTable and disable cell editing
        JTable table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make the cells non-editable
            }
        };

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scroll pane to the panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> dispose()); // Close the current window

        // Panel for the back button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);

        // Add button panel to the bottom of the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panel to the frame
        add(panel);

        // Set visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Sample order data (this would typically come from an API or database)
        Order order1 = new Order("ORD001", OrderStatus.PAID);
        order1.addItem(new CoffeeShopSystem.MenuItem("1", "Espresso", 2.5, 2, MenuCategory.COFFEE));
        order1.addItem(new CoffeeShopSystem.MenuItem("2", "Croissant", 1.5, 1, MenuCategory.DESSERT));
        order1.addItem(new CoffeeShopSystem.MenuItem("3", "Orange Juice", 3.0, 1, MenuCategory.BEVERAGE));

        Order order2 = new Order("ORD002", OrderStatus.PENDING);
        order2.addItem(new CoffeeShopSystem.MenuItem("4", "Latte", 3.0, 1, MenuCategory.COFFEE));
        order2.addItem(new MenuItem("5", "Muffin", 2.0, 2, MenuCategory.DESSERT));

        // List of orders
        List<Order> orders = List.of(order1, order2);

        // Run the UI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new OrderListUI(orders));
    }
}
