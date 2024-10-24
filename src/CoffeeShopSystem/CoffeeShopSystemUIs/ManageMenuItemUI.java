package CoffeeShopSystem.CoffeeShopSystemUIs;

import CoffeeShopSystem.CoffeeShopSystemEnums.MenuCategory;
import CoffeeShopSystem.MainWindow;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import CoffeeShopSystem.DataAccess.DataAccess;
import CoffeeShopSystem.DataAccess.DataAccessFacade;
import CoffeeShopSystem.MenuItem;

public class ManageMenuItemUI {

    public JFrame frame;
    private JTextField itemName;
    private JTextField itemPrice;
    private JTextField itemQuantity;
    private JTextField itemImage;
    DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private DataAccess dataAccess;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageMenuItemUI window = new ManageMenuItemUI();
                    window.frame.setVisible(true);
                    window.frame.setTitle("Manage Menu Items");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ManageMenuItemUI() {
        dataAccess = new DataAccessFacade();
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        String[] row = new String[5];
        String[] column = {"", "Item Name","Item Price","Item Category", "Item Quantity", "Item Image"};
        String selectedItemId;

//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(233, 150, 122));
//		panel.setBounds(0, 6, 594, 466);
//		panel.setLayout(null);
//
        itemName = new JTextField();
        itemName.setBounds(216, 27, 254, 33);
        frame.getContentPane().add(itemName);
        itemName.setColumns(10);

        itemPrice = new JTextField();
        itemPrice.setBounds(216, 65, 254, 33);
        frame.getContentPane().add(itemPrice);
        itemPrice.setColumns(10);

        JLabel lblNewLabel = new JLabel("Item Name:");
        lblNewLabel.setBounds(122, 35, 82, 16);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Item Price:");
        lblNewLabel_1.setBounds(122, 73, 75, 16);
        frame.getContentPane().add(lblNewLabel_1);

        String[] items = {"Please select a category","COFFEE", "SNACK", "BEVERAGE", "DESSERT" };
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(216, 103, 254, 40);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_2 = new JLabel("Item Category:");
        lblNewLabel_2.setBounds(122, 110, 97, 16);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Item Quantity:");
        lblNewLabel_3.setBounds(122, 147, 97, 16);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Item Image:");
        lblNewLabel_4.setBounds(122, 178, 97, 16);
        frame.getContentPane().add(lblNewLabel_4);

        itemQuantity = new JTextField();
        itemQuantity.setBounds(216, 138, 254, 33);
        frame.getContentPane().add(itemQuantity);
        itemQuantity.setColumns(10);


        itemImage = new JTextField();
        itemImage.setBounds(216, 176, 254, 33);
        frame.getContentPane().add(itemImage);
        itemImage.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(247, 255, 254));
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(itemName.getText().equals("")||itemPrice.getText().equals("")||itemQuantity.getText().equals("") || comboBox.getSelectedItem().equals("Please select a category")) {
                    JOptionPane.showMessageDialog(null, "Please enter all input fields");
                }
                else {

                    // add the entered inputs to the table
//                    row[0] = itemName.getText();
//                    row[1] = itemPrice.getText();
//                    row[2] = comboBox.getSelectedItem().toString();
//                    row[3] = itemQuantity.getText();
//                    row[4] = itemImage.getText();
//                    model.addRow(row);
                    MenuItem addToDb = new MenuItem(itemName.getText(), Double.parseDouble(itemPrice.getText()), Integer.parseInt(itemQuantity.getText()), MenuCategory.valueOf(comboBox.getSelectedItem().toString()), itemImage.getText());
                    dataAccess.loadItemMap(addToDb);
                    displayUserData();
                    JOptionPane.showMessageDialog(null, "Item added successfully");
                    // clear all the text fields
                    itemName.setText("");
                    itemPrice.setText("");
                    itemQuantity.setText("");
                    comboBox.setSelectedIndex(0);
                    itemImage.setText("");
                }

            }
        });
        btnNewButton.setBounds(119, 220, 117, 29);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.setOpaque(true);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
//                    model.setValueAt(itemName.getText(), r, 0);
//                    model.setValueAt(itemPrice.getText(), r, 1);
//                    model.setValueAt(comboBox.getSelectedItem().toString(), r, 2);
//                    model.setValueAt(itemQuantity.getText(), r, 3);
//                    model.setValueAt(itemImage.getText(), r, 4);
                    String selectedItemId = model.getValueAt(r, 0).toString();
                    MenuItem addToDb = new MenuItem(itemName.getText(), Double.parseDouble(itemPrice.getText()), Integer.parseInt(itemQuantity.getText()), MenuCategory.valueOf(comboBox.getSelectedItem().toString()), itemImage.getText());
                    dataAccess.updateItemInMap(selectedItemId, addToDb);
                    displayUserData();
                    JOptionPane.showMessageDialog(null, "Item updated Successfully");
                    itemName.setText("");
                    itemPrice.setText("");
                    itemQuantity.setText("");
                    comboBox.setSelectedIndex(0);
                    itemImage.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select an item");
                }
            }
        });
        btnNewButton_1.setBounds(248, 220, 117, 29);
        frame.getContentPane().add(btnNewButton_1);

//        JButton btnNewButton_2 = new JButton("Delete");
//        btnNewButton_2.setBackground(Color.RED);
//        btnNewButton_2.setOpaque(true);
//        btnNewButton_2.setBorderPainted(false);
//        btnNewButton_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int r = table.getSelectedRow();
//                if(r>=0) {
//                    model.removeRow(r);
//                    JOptionPane.showMessageDialog(null, "Item deleted Successfully");
//                    itemName.setText("");
//                    itemPrice.setText("");
//                    itemQuantity.setText("");
//                    comboBox.setSelectedIndex(0);
//                    itemImage.setText("");
//
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Please select an item on the table to delete");
//                }
//            }
//        });
//        btnNewButton_2.setBounds(377, 220, 117, 29);
//        frame.getContentPane().add(btnNewButton_2);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 258, 588, 259);
        frame.getContentPane().add(scrollPane);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table = new JTable(model);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        scrollPane.setViewportView(table);
        table.setBackground(new Color(255, 240, 245));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                itemName.setText(model.getValueAt(r, 1).toString());
                itemPrice.setText(model.getValueAt(r, 2).toString());
                comboBox.setSelectedItem(model.getValueAt(r, 3).toString());
                itemQuantity.setText(model.getValueAt(r, 4).toString());
                itemImage.setText(model.getValueAt(r, 5).toString());

            }
        });
        displayUserData();

        JToggleButton tglbtnNewToggleButton = new JToggleButton("Go back");
        tglbtnNewToggleButton.setOpaque(true);
        tglbtnNewToggleButton.setBorderPainted(false);
        tglbtnNewToggleButton.setBounds(6, 6, 97, 29);
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                MainWindow mWindow = new MainWindow();
                mWindow.mframe.setVisible(true);
                frame.dispose();
            }
        });
        tglbtnNewToggleButton.setForeground(new Color(87, 131, 219));
        frame.getContentPane().add(tglbtnNewToggleButton);
    }

    public void displayUserData() {
        HashMap<String, MenuItem> userMap = dataAccess.readItemsMap();

        model.setRowCount(0);

        for (String key : userMap.keySet()) {
            MenuItem currentItem = userMap.get(key);
            Object[] rowData = {
                    currentItem.getItemId(),
                    currentItem.getItemName(),
                    currentItem.getPrice(),
                    currentItem.getCategory(),
                    currentItem.getQuantity(),
                    currentItem.getImagePath() == null ? "No image added" : currentItem.getImagePath().equals("") ? "No image added" : currentItem.getImagePath()
            };
            model.addRow(rowData);
        }
    }
}
