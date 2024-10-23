package CoffeeShopSystem;

import CoffeeShopSystem.TakeOrder.View.TakeOrderWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    JFrame mframe;

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
                //bframe is a variable property given in design view
                bWindow.bframe.setVisible(true);
                mframe.dispose();
            }
        });
        takeOrderBtn.setBounds(136, 101, 117, 100);


        JButton addMenuBtn = new JButton("Manage Menu");
        addMenuBtn.setBounds(300, 101, 117, 100);
        JButton addEmployeeBtn = new JButton("Manage Employee");
        addEmployeeBtn.setBounds(136, 220, 117, 100);
        JButton viewOrderBtn = new JButton("View All Orders");
        viewOrderBtn.setBounds(300, 220, 117, 100);
        JButton logOutBtn = new JButton("Log Out");
        logOutBtn.setBounds(136, 350, 117, 100);
        panel.add(takeOrderBtn);
        panel.add(addMenuBtn);
        panel.add(addEmployeeBtn);
        panel.add(viewOrderBtn);
        panel.add(logOutBtn);
    }
}
