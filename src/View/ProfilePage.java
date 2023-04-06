package View;

import Loading.ImageLoader;
import Model.HeroName;
import Model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ProfilePage extends MainFrame{
    // Fields
    private User user;
    private JLabel hero1Image,hero2Image = null;
    Border border1 = BorderFactory.createLineBorder(Color.BLACK, 5);
    Border border2 = BorderFactory.createLineBorder(Color.GRAY, 5);
    // Constructor
    protected ProfilePage(User user) {
        super(500, 625, ImageLoader.getProfileMenuImage());
        this.user = user;
        initComponents();

        // Create and execute the SwingWorker to run the mouseLoop method in a separate thread
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                mouseLoop();
                return null;
            }
        };
        worker.execute();
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
        hero1Image = new JLabel(ImageLoader.getMarioSmallImage());
        if (Arrays.asList(this.user.getOwnedHeroes()).contains(HeroName.LUIGI)) {
            hero2Image = new JLabel(ImageLoader.getLuigiSmallImage());
        }
        JButton backButton = new JButton("Back");
        JButton logoutButton = new JButton("Logout");

        usernameLabel.setFont(new Font("Forte",Font.PLAIN,25));
        coinLabel.setFont(new Font("Forte",Font.PLAIN,35));
        highscoreLabel.setFont(new Font("Forte",Font.PLAIN,25));
        characterLabel.setFont(new Font("Forte",Font.PLAIN,17));
        backButton.setFont(new Font("Forte",Font.PLAIN,17));
        logoutButton.setFont(new Font("Forte",Font.PLAIN,17));

        hero1Image.setBorder(border1);

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
        super.mainPanel.add(hero1Image);
        if (hero2Image!=null){
            super.mainPanel.add(hero2Image);
        }
        super.mainPanel.add(backButton);
        super.mainPanel.add(logoutButton);

        usernameLabel.setBounds(140,0,400,100);
        highscoreLabel.setBounds(140,70,300,50);
        coinImage.setBounds(110,90,100,100);
        coinLabel.setBounds(195,120,150,50);
        characterLabel.setBounds(200,170,150,55);
        hero1Image.setBounds(30,220,100,155);
        if (hero2Image!=null){
            hero2Image.setBounds(140,220,100,155);
        }
        backButton.setBounds(135,400,90,40);
        logoutButton.setBounds(255,400,90,40);
    }
    void mouseLoop(){
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY() - 30;
                if(x>30 && x<130 && y>220 && y<375){
                    hero1Image.setBorder(null);
                    hero2Image.setBorder(border1);
                    user.setActiveHero(HeroName.MARIO);
                }
                if (hero2Image!=null){
                    if(x>140 && x<240 && y>220 && y<375){
                        hero1Image.setBorder(null);
                        hero2Image.setBorder(border1);
                        user.setActiveHero(HeroName.LUIGI);
                    }
                }
            }
        });
        int frameX = super.getLocationOnScreen().x;
        int frameY = super.getLocationOnScreen().y;

        while (true) {
            // get the current position of the mouse pointer on the screen
            int mouseX = MouseInfo.getPointerInfo().getLocation().x;
            int mouseY = MouseInfo.getPointerInfo().getLocation().y;

            // calculate the position of the mouse pointer relative to the JFrame
            int relativeX = mouseX - frameX;
            int relativeY = mouseY - frameY - 30;
            int n = 0;
            if(relativeX>30 && relativeX<130 && relativeY>220 && relativeY<375){
                hero2Image.setBorder(null);
                hero1Image.setBorder(border2);
                n++;
            }
            if (hero2Image!=null){
                if(relativeX>140 && relativeX<240 && relativeY>220 && relativeY<375){
                    hero1Image.setBorder(null);
                    hero2Image.setBorder(border2);
                    n++;
                }
            }
            if (n==0){
                if (user.getOwnedHeroes()[0]==user.getActiveHero()){
                    hero2Image.setBorder(null);
                    hero1Image.setBorder(border1);
                }
                if (user.getOwnedHeroes()[1]==user.getActiveHero()){
                    hero1Image.setBorder(null);
                    hero2Image.setBorder(border1);
                }
            }
        }
    }
}
