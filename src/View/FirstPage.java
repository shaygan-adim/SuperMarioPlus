package View;

import Loading.ImageLoader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FirstPage extends MainFrame {
    // Constructor
    public FirstPage(){
        super(500,625,ImageLoader.getMainMenuImage());
        initComponents();
    }

    // Methods
    @Override
    void initComponents(){
        // Initializing the buttons and configuring them
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        loginButton.setFocusPainted(false);
        registerButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        loginButton.setFont(new Font("Forte",Font.BOLD,25));
        registerButton.setFont(new Font("Forte",Font.BOLD,25));
        exitButton.setFont(new Font("Forte",Font.BOLD,20));

        // Setting listeners
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstPage.super.dispose();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPage();
                FirstPage.super.dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                FirstPage.super.dispose();
            }
        });



        // Adding the buttons and setting the locations
        super.mainPanel.add(loginButton);
        super.mainPanel.add(registerButton);
        super.mainPanel.add(exitButton);

        loginButton.setBounds(175,270,130,50);
        registerButton.setBounds(175,330,130,50);
        exitButton.setBounds(200,400,80,40);
    }

    public static void main(String[] args) throws IOException {
        ImageLoader.load();
        new FirstPage();
    }
}
