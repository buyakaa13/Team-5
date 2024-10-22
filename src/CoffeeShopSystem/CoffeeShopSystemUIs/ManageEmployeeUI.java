package CoffeeShopSystem.CoffeeShopSystemUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ManageEmployeeUI {

    private JFrame frame;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField userName;
    private JTextField password;
    DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageEmployeeUI  window = new ManageEmployeeUI ();
                    window.frame.setVisible(true);
                    window.frame.setTitle("Manage Employee");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ManageEmployeeUI () {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        String[] column = {"First Name","Last Name","Username", "Role"};
        String[] row = new String[4];

//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(233, 150, 122));
//		panel.setBounds(0, 6, 594, 466);
//		panel.setLayout(null);
//
        firstName = new JTextField();
        firstName.setBounds(200, 26, 254, 33);
        frame.getContentPane().add(firstName);
        firstName.setColumns(10);

        lastName = new JTextField();
        lastName.setBounds(200, 64, 254, 33);
        frame.getContentPane().add(lastName);
        lastName.setColumns(10);

        userName = new JTextField();
        userName.setBounds(200, 137, 254, 33);
        frame.getContentPane().add(userName);
        userName.setColumns(10);

        password = new JTextField();
        password.setBounds(200, 175, 254, 33);
        frame.getContentPane().add(password);
        password.setColumns(10);

        JLabel lblNewLabel = new JLabel("First Name:");
        lblNewLabel.setBounds(106, 34, 82, 16);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Last Name:");
        lblNewLabel_1.setBounds(106, 72, 75, 16);
        frame.getContentPane().add(lblNewLabel_1);

        String[] items = {"Please select role","Manager", "Cashier" };
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(200, 102, 254, 40);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_2 = new JLabel("Role:");
        lblNewLabel_2.setBounds(106, 109, 97, 16);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Username:");
        lblNewLabel_3.setBounds(106, 146, 97, 16);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Password:");
        lblNewLabel_4.setBounds(106, 184, 97, 16);
        frame.getContentPane().add(lblNewLabel_4);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(247, 255, 254));
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(firstName.getText().equals("")||lastName.getText().equals("")|| userName.getText().equals("") || password.getText().equals("") || comboBox.getSelectedItem().equals("Please select a category")) {
                    JOptionPane.showMessageDialog(null, "Please enter all input fields");
                }
                else {
                    // add the entered inputs to the table
                    row[0] = firstName.getText();
                    row[1] = lastName.getText();
                    row[2] = comboBox.getSelectedItem().toString();
                    row[3] = userName.getText();
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Employee added successfully");
                    // clear all the text fields
                    firstName.setText("");
                    lastName.setText("");
                    userName.setText("");
                    password.setText("");
                    comboBox.setSelectedIndex(0);
                }

            }
        });
        btnNewButton.setBounds(103, 230, 117, 29);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.setOpaque(true);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    model.setValueAt(firstName.getText(), r, 0);
                    model.setValueAt(lastName.getText(), r, 1);
                    model.setValueAt(comboBox.getSelectedItem().toString(), r, 2);
                    model.setValueAt(userName.getText(), r, 3);
                    JOptionPane.showMessageDialog(null, "Employee updated Successfully");
                    firstName.setText("");
                    lastName.setText("");
                    userName.setText("");
                    comboBox.setSelectedIndex(0);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select an employee");
                }
            }
        });
        btnNewButton_1.setBounds(232, 230, 117, 29);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Delete");
        btnNewButton_2.setBackground(Color.RED);
        btnNewButton_2.setOpaque(true);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int r = table.getSelectedRow();
                if(r>=0) {
                    model.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Employee deleted Successfully");
                    firstName.setText("");
                    lastName.setText("");
                    userName.setText("");
                    comboBox.setSelectedIndex(0);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select an employee on the table to delete");
                }
            }
        });
        btnNewButton_2.setBounds(361, 230, 117, 29);
        frame.getContentPane().add(btnNewButton_2);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 278, 588, 259);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                firstName.setText(model.getValueAt(r, 0).toString());
                lastName.setText(model.getValueAt(r, 1).toString());
                comboBox.setSelectedItem(model.getValueAt(r, 2).toString());
                userName.setText(model.getValueAt(r, 3).toString());

            }
        });

        table.setBackground(new Color(255, 240, 245));
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JToggleButton tglbtnNewToggleButton = new JToggleButton("Go back");
        tglbtnNewToggleButton.setOpaque(true);
        tglbtnNewToggleButton.setBorderPainted(false);
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
//                MainWindow mWindow = new MainWindow();
//
//                mWindow.mframe.setVisible(true);
            }
        });
        tglbtnNewToggleButton.setBounds(6, 6, 97, 29);
        tglbtnNewToggleButton.setForeground(new Color(87, 131, 219));
        frame.getContentPane().add(tglbtnNewToggleButton);
    }
}
