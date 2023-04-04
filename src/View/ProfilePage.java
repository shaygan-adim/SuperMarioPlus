package View;

import Loading.ImageLoader;
import Model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProfilePage extends MainFrame{
    // Fields
    User user;
    // Constructor
    protected ProfilePage(User user) {
        super(500, 625, ImageLoader.getProfileMenuImage());
        this.user = user;
        initComponents();
    }

    // Methods
    @Override
    void initComponents() {
        // Initializing and configuring the components
        JLabel usernameLabel = new JLabel("Username : "+this.user.getUsername());
        JLabel coinImage = new JLabel(ImageLoader.getCoinBiggerImage());
        JLabel coinLabel = new JLabel(String.valueOf(this.user.getCoin()));
        JLabel highscoreLabel = new JLabel("Highscore : "+this.user.getHighscore());
        JLabel characterLabel = new JLabel("Characters :");
        JLabel marioImage = new JLabel(ImageLoader.getMarioSmallImage());
        JButton backButton = new JButton("Back");
        JButton logoutButton = new JButton("Logout");

        usernameLabel.setFont(new Font("Forte",Font.PLAIN,25));
        coinLabel.setFont(new Font("Forte",Font.PLAIN,35));
        highscoreLabel.setFont(new Font("Forte",Font.PLAIN,25));
        characterLabel.setFont(new Font("Forte",Font.PLAIN,17));
        backButton.setFont(new Font("Forte",Font.PLAIN,17));
        logoutButton.setFont(new Font("Forte",Font.PLAIN,17));

        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        marioImage.setBorder(border);

        backButton.setFocusPainted(false);
        logoutButton.setFocusPainted(false);

        // Setting listeners
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure ?", "", JOptionPane.YES_NO_OPTION);
                if (dialogResult==JOptionPane.YES_OPTION){
                    new FirstPage();
                    ProfilePage.super.dispose();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage(user);
                ProfilePage.super.dispose();
            }
        });

        // Adding the components and setting the locations
        super.mainPanel.add(usernameLabel);
        super.mainPanel.add(coinImage);
        super.mainPanel.add(coinLabel);
        super.mainPanel.add(highscoreLabel);
        super.mainPanel.add(characterLabel);
        super.mainPanel.add(marioImage);
        super.mainPanel.add(backButton);
        super.mainPanel.add(logoutButton);

        usernameLabel.setBounds(140,0,400,100);
        highscoreLabel.setBounds(140,70,300,50);
        coinImage.setBounds(110,90,100,100);
        coinLabel.setBounds(195,120,150,50);
        characterLabel.setBounds(200,170,150,55);
        marioImage.setBounds(30,220,100,155);
        backButton.setBounds(135,400,90,40);
        logoutButton.setBounds(255,400,90,40);

    }
}
