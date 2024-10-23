package CoffeeShopSystem.TakeOrder.View;

import CoffeeShopSystem.*;
import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.CoffeeShopSystemEnums.OrderStatus;
import CoffeeShopSystem.DataAccess.DataAccess;
import CoffeeShopSystem.DataAccess.DataAccessFacade;
import CoffeeShopSystem.DataAccess.TestData;
import CoffeeShopSystem.MenuItem;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class TakeOrderWindow {
    public JFrame bframe;
    private JTable orderTable;
    private JScrollPane topScroll, bottomScroll;
    private JPanel mainPanel, topPanel, bottomPanel, manageOrderPanel;
    private JTextField totalText, paidText, remainText;
    DefaultTableModel model;
    Order order;
    public ArrayList<Payment> paymentList;
    private double totalAmount;

    public double getTotalAmount() {
        return totalAmount;
    }
    private DataAccess dataAccess;

    // Launch the application.
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TakeOrderWindow window = new TakeOrderWindow();
                    window.bframe.setVisible(true);
                    window.bframe.setTitle("Take Order");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Constructor to initialize
    public TakeOrderWindow() {
        order = new Order();
        paymentList = new ArrayList<>();
        dataAccess = new DataAccessFacade();
        initialize();
    }

    // Initialize the contents of the frame.
    public void initialize() {
        bframe = new JFrame();
        bframe.setTitle("Take order");
        bframe.getContentPane().setForeground(new Color(255, 255, 255));
        bframe.setBounds(100, 100, 600, 800);
        bframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bframe.getContentPane().setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 600, 800);
        mainPanel.setLayout(null);
        bframe.getContentPane().add(mainPanel);

        // Initialize topPanel before adding to JScrollPane
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 600, 400);
        topPanel.setLayout(new GridLayout(0, 3, 10, 10));

        // Create JScrollPane and attach topPanel
        topScroll = new JScrollPane(topPanel);
        topScroll.setBounds(0, 0, 600, 350);
        mainPanel.add(topScroll);

        bottomScroll = new JScrollPane();
        bottomScroll.setBounds(0, 350, 600, 200);
        mainPanel.add(bottomScroll);

        manageOrderPanel = new JPanel();
        manageOrderPanel.setBounds(0, 550, 600, 50);
        mainPanel.add(manageOrderPanel);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 2, 10, 10));  // 3 rows, 2 columns, with 10px gaps
        bottomPanel.setBounds(0, 600, 600, 100);
        mainPanel.add(bottomPanel);

        // Fetch item data
        TestData td = new TestData();
        td.itemData();
        DataAccess da = new DataAccessFacade();
        HashMap<Long, MenuItem> items = da.readItemsMap();

        for (Long key : items.keySet()) {
            MenuItem currentItem = items.get(key);
            currentItem.setSelectedQty(1);

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setPreferredSize(new Dimension(100, 200));

            JLabel imageLabel = new JLabel();
            String imageIcon = "src/CoffeeShopSystem/Images/noImage.png";
            if(!currentItem.getImagePath().equals(""))
                imageIcon = currentItem.getImagePath();
            ImageIcon icon = new ImageIcon(imageIcon);
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            itemPanel.add(imageLabel);

            JLabel nameLabel = new JLabel("Name: " + currentItem.getItemName());
            itemPanel.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: $" + currentItem.getPrice());
            itemPanel.add(priceLabel);

            JPanel rowPanel = new JPanel(new FlowLayout());
            JLabel label = new JLabel("Qty:");
            rowPanel.add(label);

            SpinnerNumberModel spinnerNum = new SpinnerNumberModel(1, 1, currentItem.getQuantity() == 0 ? 1 : currentItem.getQuantity(), 1);
            JSpinner spinner = new JSpinner(spinnerNum);
            spinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    currentItem.setSelectedQty(Integer.valueOf(spinner.getValue().toString()));
                }
            });
            rowPanel.add(spinner);
            itemPanel.add(rowPanel);

            JButton addBtn = new JButton("Add item");
            itemPanel.add(addBtn);

            if(currentItem.getQuantity() == 0) {
                spinner.setEnabled(false);
                addBtn.setEnabled(false);
            }

            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] rowData = new String[6];
                    rowData[0] = String.valueOf(key);
                    rowData[1] = currentItem.getItemName();
                    rowData[2] = currentItem.getCategory().toString();
                    rowData[3] = String.valueOf(currentItem.getPrice());
                    rowData[4] = String.valueOf(currentItem.getSelectedQty());
                    double total = currentItem.getPrice() * currentItem.getSelectedQty();
                    rowData[5] = String.valueOf(total);

                    model.addRow(rowData);
                    calculateTotal();
                }
            });
            topPanel.add(itemPanel);
        }

        orderTable = new JTable();
        orderTable.setBounds(0, 300, 900, 300);

        newTable();
        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = orderTable.getSelectedRow();
                // Handle row selection
            }
        });

        orderTable.setBackground(new Color(255, 240, 245));
        bottomScroll.setViewportView(orderTable);

        JButton deleteOrderButton = new JButton("Delete selected order");
        deleteOrderButton.addActionListener(e ->deleteSelectedRow());
        manageOrderPanel.add(deleteOrderButton, BorderLayout.SOUTH);

        JPanel totalRowPanel = new JPanel(new FlowLayout());
        JLabel totalLabel = new JLabel();
        totalLabel.setText("Total amount: ");
        totalRowPanel.add(totalLabel);

        totalText = new JTextField("0");
        totalText.setEditable(false);
        totalText.setPreferredSize(new Dimension(150, 20));
        totalRowPanel.add(totalText);
        bottomPanel.add(totalRowPanel);

        JPanel paidRowPanel = new JPanel(new FlowLayout());
        JLabel paidLabel = new JLabel();
        paidLabel.setText("Paid amount: ");
        paidRowPanel.add(paidLabel);

        paidText = new JTextField("0");
        paidText.setEditable(false);
        paidText.setPreferredSize(new Dimension(150, 20));
        paidRowPanel.add(paidText);
        bottomPanel.add(paidRowPanel);

        JPanel remainRowPanel = new JPanel(new FlowLayout());
        JLabel remainLabel = new JLabel();
        remainLabel.setText("Remain amount: ");
        remainRowPanel.add(remainLabel);

        remainText = new JTextField("0");
        remainText.setEditable(false);
        remainText.setPreferredSize(new Dimension(150, 20));
        remainRowPanel.add(remainText);
        bottomPanel.add(remainRowPanel);

        JPanel buttonPanel = new JPanel();
        JButton returnBtn = new JButton();
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow mainWindow = new MainWindow();
                mainWindow.mframe.setVisible(true);
                bframe.dispose();
            }
        });
        returnBtn.setText("Go back");
        returnBtn.setOpaque(true);
        returnBtn.setBorderPainted(false);
        buttonPanel.add(returnBtn);

        JButton paymentBtn = new JButton();
        paymentBtn.setText("Payment");
        paymentBtn.addActionListener(e -> openPaymentMethodWindow());

        buttonPanel.add(paymentBtn);
        buttonPanel.setBounds(0, 700, 600, 100);
        mainPanel.add(buttonPanel);
        bframe.setVisible(true);
    }

    private void openPaymentMethodWindow() {
        if(totalAmount == 0)
            JOptionPane.showMessageDialog(null, "Please choose some item!", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
            saveOrder();
            PaymentWindow pWindow=new PaymentWindow(this);
            pWindow.pframe.setVisible(true);
        }
    }

    public void updatePaymentStatus(boolean isPaymentSuccessful) {
        if (isPaymentSuccessful){
            order.setStatus(OrderStatus.PAID);
            dataAccess.updateOrderInMap(order.getOrderId(), order);
            clear();
        }
        else
            JOptionPane.showMessageDialog(null, "Payment failed!", "Warning", JOptionPane.ERROR_MESSAGE);
    }

    private void calculateTotal(){
        totalAmount = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double amount = Double.parseDouble(model.getValueAt(i, 5).toString());
            totalAmount += amount;
        }
        totalText.setText(String.valueOf(totalAmount));
    }

    private void saveOrder() {
        for (int i = 0; i < model.getRowCount(); i++) {
            Long itemId = Long.parseLong(model.getValueAt(i, 0).toString());
            String itemName = model.getValueAt(i, 1).toString();
            String category = model.getValueAt(i, 2).toString();
            double itemPrice = Double.parseDouble(model.getValueAt(i, 3).toString());
            int itemQty = Integer.parseInt(model.getValueAt(i, 4).toString());
            MenuItem MenuItem = new MenuItem(itemId, itemName, itemPrice, itemQty, MenuCategory.valueOf(category), "");
            order.addItem(MenuItem);
        }
        order.setTotalAmount(totalAmount);
        dataAccess.saveNewOrder(order);
    }

    private void clear(){
        totalAmount = 0;
        totalText.setText("0");
        newTable();
    }

    private void newTable(){
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] column = {"ID", "ItemName", "Category", "Price", "Qty", "Total"};
        model.setColumnIdentifiers(column);
        orderTable.setModel(model);
    }

    private void deleteSelectedRow() {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow >= 0){
            model.removeRow(selectedRow);
            calculateTotal();
        }
        else
            JOptionPane.showMessageDialog(null, "No row selected");
    }
}

