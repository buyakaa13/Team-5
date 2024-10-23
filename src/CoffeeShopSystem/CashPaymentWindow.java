package CoffeeShopSystem;

import CoffeeShopSystem.TakeOrder.View.TakeOrderWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPaymentWindow {
    private static TakeOrderWindow takeOrderWindow;
    public JFrame frame;
    private JTextField totalText, payText;
    private Payment payment;
    private String title;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CashPaymentWindow window = new CashPaymentWindow(takeOrderWindow, PaymentType.CASH);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CashPaymentWindow(TakeOrderWindow takeOrder, PaymentType type) {
        takeOrderWindow = takeOrder;
        this.title = type == PaymentType.CASH ? "Cash" : "Card";
        initialize();
        payment = new Payment(type);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setBounds(100, 100, 450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel totalLabel = new JLabel("Total amount:");
        totalLabel.setBounds(60, 52, 103, 16);
        frame.getContentPane().add(totalLabel);

        JLabel payLabel = new JLabel("Pay amount:");
        payLabel.setBounds(60, 81, 103, 16);
        frame.getContentPane().add(payLabel);

        totalText = new JTextField();
        totalText.setEditable(false);
        totalText.setText(String.valueOf(takeOrderWindow.getTotalAmount()));
        totalText.setBounds(197, 47, 130, 26);
        frame.getContentPane().add(totalText);
        totalText.setColumns(10);

        payText = new JTextField();
        payText.setBounds(197, 76, 130, 26);
        frame.getContentPane().add(payText);
        payText.setColumns(10);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        cancelButton.setBackground(new Color(64, 154, 255));
        cancelButton.setBounds(81, 120, 117, 29);
        frame.getContentPane().add(cancelButton);

        JButton payBtn = new JButton("Pay");
        payBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(valid()) {
                    JOptionPane.showMessageDialog(null, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
            }
        });
        payBtn.setBounds(210, 120, 117, 29);
        frame.getContentPane().add(payBtn);
    }

    private boolean valid(){
        double paidAmount = payText.getText().equals("") ? 0 : Double.valueOf(payText.getText());
        if(paidAmount < takeOrderWindow.getTotalAmount()){
            JOptionPane.showMessageDialog(null, "Payment incomplete!", "Warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            payment.setAmount(paidAmount);
            takeOrderWindow.paymentList.add(payment);
            takeOrderWindow.updatePaymentStatus(true);
            return true;
        }
    }
}
