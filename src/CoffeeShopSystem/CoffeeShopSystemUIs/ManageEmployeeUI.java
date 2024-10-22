package CoffeeShopSystem.CoffeeShopSystemUIs;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;

public class ManageEmployeeUI {

    private JFrame frame;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField userName;
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
        Vector roleItems=new Vector();
        roleItems.add("Manager");
        roleItems.add("Cashier");

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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

        JLabel lblNewLabel = new JLabel("First Name:");
        lblNewLabel.setBounds(106, 34, 82, 16);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Last Name:");
        lblNewLabel_1.setBounds(106, 72, 75, 16);
        frame.getContentPane().add(lblNewLabel_1);

        final DefaultComboBoxModel roleItemsModel = new DefaultComboBoxModel(roleItems);
        JComboBox catItems = new JComboBox(roleItemsModel);
        catItems.setBounds(200, 102, 254, 40);
        frame.getContentPane().add(catItems);

        JLabel lblNewLabel_2 = new JLabel("Role:");
        lblNewLabel_2.setBounds(106, 109, 97, 16);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Username:");
        lblNewLabel_3.setBounds(106, 146, 97, 16);
        frame.getContentPane().add(lblNewLabel_3);

        userName = new JTextField();
        userName.setBounds(200, 137, 254, 33);
        frame.getContentPane().add(userName);
        userName.setColumns(10);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.setOpaque(true);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(247, 255, 254));
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.setBounds(103, 192, 117, 29);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.setBackground(Color.CYAN);
        btnNewButton_1.setOpaque(true);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBounds(232, 192, 117, 29);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Delete");
        btnNewButton_2.setBackground(Color.RED);
        btnNewButton_2.setOpaque(true);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setBounds(361, 192, 117, 29);
        frame.getContentPane().add(btnNewButton_2);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 238, 588, 259);
        frame.getContentPane().add(scrollPane);

        table = new JTable();


        table.setBackground(new Color(255, 240, 245));
        model = new DefaultTableModel();
        String[] column = {"First Name","Last Name","Username", "Role"};
        String[] row = new String[4];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JToggleButton tglbtnNewToggleButton = new JToggleButton("Go back");
        tglbtnNewToggleButton.setOpaque(true);
        tglbtnNewToggleButton.setBorderPainted(false);
        tglbtnNewToggleButton.setBounds(6, 6, 97, 29);
        tglbtnNewToggleButton.setForeground(new Color(87, 131, 219));
        frame.getContentPane().add(tglbtnNewToggleButton);
    }
}
