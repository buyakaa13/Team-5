package CoffeeShopSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private static final String CREDENTIALS_FILE = "user_credentials.txt";

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

//                JOptionPane.showMessageDialog(null, "Welcome " + username + "!");
            } else {
                statusLabel.setText("Invalid username or password.");
                JOptionPane.showMessageDialog(null, "Login failed. Try again.");
            }
        }
    }

    private boolean validateCredentials(String username, String password) {
        HashMap<String, String> credentials = loadCredentialsFromFile();
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    private HashMap<String, String> loadCredentialsFromFile() {
        HashMap<String, String> credentials = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];
                    credentials.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    private void saveCredentialToFile(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENTIALS_FILE, true))) {
            bw.write(username + ":" + password);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createDefaultCredentials();
        SwingUtilities.invokeLater(() -> {
            new LoginForm();
        });
    }

    // Create default credentials if the file doesn't exist
    private static void createDefaultCredentials() {
        if (!Files.exists(Paths.get(CREDENTIALS_FILE))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CREDENTIALS_FILE))) {
                bw.write("admin:admin123");  // Default admin credentials
                bw.newLine();
                bw.write("cashier:cashier123");   // Default user credentials
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
