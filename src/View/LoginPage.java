package View;

import Loading.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginPage extends MainFrame {
    // Constructor
    public LoginPage(){
        super(500,625,ImageLoader.getMainMenuImage());
        initComponents();
    }

    // Methods
    @Override
    void initComponents() {
        // Initializing and configuring the components
        JLabel usernameLabel = new JLabel("Username :");
        JLabel passwordLabel = new JLabel("Password :");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");
        JLabel wrongLabel = new JLabel();

        usernameLabel.setFont(new Font("Forte",Font.PLAIN,18));
        passwordLabel.setFont(new Font("Forte",Font.PLAIN,18));
        loginButton.setFont(new Font("Forte",Font.PLAIN,18));
        backButton.setFont(new Font("Forte",Font.PLAIN,18));

        loginButton.setFocusPainted(false);
        backButton.setFocusPainted(false);

        // Adding the components and setting the locations
        super.mainPanel.add(usernameLabel);
        super.mainPanel.add(passwordLabel);
        super.mainPanel.add(usernameField);
        super.mainPanel.add(passwordField);
        super.mainPanel.add(loginButton);
        super.mainPanel.add(backButton);
        super.mainPanel.add(wrongLabel);

        usernameLabel.setBounds(172,225,150,50);
        usernameField.setBounds(170,265,150,25);
        passwordLabel.setBounds(172,295,150,50);
        passwordField.setBounds(170,335,150,25);
        loginButton.setBounds(255,400,80,30);
        backButton.setBounds(155,400,80,30);
    }
    public static void main(String[] args) throws IOException {
        ImageLoader.load();
        new LoginPage();
    }

}
