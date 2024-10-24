package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemUIs.ManageEmployeeUI;
import CoffeeShopSystem.CoffeeShopSystemUIs.ManageMenuItemUI;
import CoffeeShopSystem.CoffeeShopSystemUIs.OrderListUI;
import CoffeeShopSystem.DataAccess.Auth;
import CoffeeShopSystem.DataAccess.DataAccess;
import CoffeeShopSystem.DataAccess.DataAccessFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public JFrame mframe;
    private DataAccess da;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.mframe.setVisible(true);
                    window.mframe.setTitle("Main Window");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
        da = new DataAccessFacade();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mframe = new JFrame();
        mframe.setBounds(100, 100, 600, 550);
        mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mframe.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(0, 0, 900, 600);
        mframe.getContentPane().add(panel);
        panel.setLayout(null);

        JButton takeOrderBtn = new JButton("Take Order");
        takeOrderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TakeOrderWindow bWindow = new TakeOrderWindow();
                bWindow.bframe.setVisible(true);
                mframe.dispose();
            }
        });
        takeOrderBtn.setBounds(130, 100, 150, 100);

        JButton viewOrderBtn = new JButton("Generate Report");
        viewOrderBtn.setBounds(300, 100, 150, 100);
        viewOrderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OrderListUI menuWindow = new OrderListUI(da.readOrderMap());
                menuWindow.setVisible(true);
                mframe.dispose();
            }
        });

        JButton addMenuBtn = new JButton("Manage Menu");
        addMenuBtn.setBounds(130, 220, 150, 100);
        addMenuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageMenuItemUI menuWindow = new ManageMenuItemUI();
                menuWindow.frame.setVisible(true);
                mframe.dispose();
            }
        });

        JButton addEmployeeBtn = new JButton("Manage Employee");
        addEmployeeBtn.setBounds(300, 220, 150, 100);
        addEmployeeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManageEmployeeUI menuWindow = new ManageEmployeeUI();
                menuWindow.frame.setVisible(true);
                mframe.dispose();
            }
        });

        JButton logOutBtn = new JButton("Log Out");
        logOutBtn.setBounds(130, 350, 150, 100);
        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm login = new LoginForm();
                login.setVisible(true);
                mframe.dispose();
            }
        });

        panel.add(takeOrderBtn);
        panel.add(viewOrderBtn);
        if(Util.userRole == Auth.MANAGER){
            panel.add(addMenuBtn);
            panel.add(addEmployeeBtn);
        }
        panel.add(logOutBtn);
    }
}
