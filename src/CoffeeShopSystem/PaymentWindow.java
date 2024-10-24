package CoffeeShopSystem;

import CoffeeShopSystem.CoffeeShopSystemEnums.PaymentType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentWindow {
    private static TakeOrderWindow takeOrderWindow;
    public JFrame pframe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PaymentWindow window = new PaymentWindow(takeOrderWindow);
                    window.pframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PaymentWindow(TakeOrderWindow takeOrder) {
        takeOrderWindow = takeOrder;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        pframe = new JFrame();
        pframe.setTitle("Payment method");
        pframe.setBounds(100, 100, 450, 300);
        pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pframe.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 500, 300);
        pframe.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Please choose your payment type");
        lblNewLabel.setBounds(93, 41, 209, 16);
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblNewLabel);

        JButton cashBtn = new JButton("Cash");
        String imageIcon = "src/CoffeeShopSystem/Images/cash.png";
        ImageIcon icon = new ImageIcon(imageIcon);
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        cashBtn.setIcon(new ImageIcon(scaledImage));
        cashBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakePaymentWindow cash = new MakePaymentWindow(takeOrderWindow, PaymentType.CASH);
                cash.frame.setVisible(true);
                pframe.dispose();
            }
        });
        cashBtn.setBounds(93, 86, 100, 100);
        panel.add(cashBtn);

        JButton cardBtn = new JButton("Card");
        String imageIconCard = "src/CoffeeShopSystem/Images/card.png";
        ImageIcon iconCard = new ImageIcon(imageIconCard);
        Image scaledImageCard = iconCard.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        cardBtn.setIcon(new ImageIcon(scaledImageCard));
        cardBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MakePaymentWindow cash = new MakePaymentWindow(takeOrderWindow, PaymentType.CARD);
                cash.frame.setVisible(true);
                pframe.dispose();
            }
        });
        cardBtn.setBounds(222, 86, 100, 100);
        panel.add(cardBtn);

        JButton returnBtn = new JButton("return");
        returnBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pframe.dispose();
            }
        });
        returnBtn.setBounds(26, 226, 117, 29);
        panel.add(returnBtn);
    }
}
