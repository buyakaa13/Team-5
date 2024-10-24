package CoffeeShopSystem;

import CoffeeShopSystem.DataAccess.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private DataAccess dataAccess = new DataAccessFacade();
    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        usernamePanel.add(usernameField);
        inputPanel.add(usernamePanel);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);
        inputPanel.add(passwordPanel);

        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        statusLabel = new JLabel("");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(statusLabel);
        add(mainPanel);
        loginButton.addActionListener(new LoginButtonListener());
        setVisible(true);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateCredentials(username, password)) {
                statusLabel.setText("Login successful!");
                MainWindow window = new MainWindow();
                window.mframe.setVisible(true);
                dispose();
//                JOptionPane.showMessageDialog(null, "Welcome " + username + "!");
            } else {
                statusLabel.setText("Invalid username or password.");
                JOptionPane.showMessageDialog(null, "Login failed. Try again.");
            }
        }
    }

    private boolean validateCredentials(String username, String password) {
        HashMap<String, User> users = dataAccess.readUserMap();
        if(users == null || users.size() == 0)
            return false;
        boolean isSuccess = users.containsKey(username) && users.get(username).getPassword().equals(password);
        if(isSuccess)
            Util.userRole = users.get(username).getAuthorization();
        return isSuccess;
    }

    public static void main(String[] args) {
        TestData testData = new TestData();
        testData.userData();
        SwingUtilities.invokeLater(() -> {
            new LoginForm();
        });
    }

}
