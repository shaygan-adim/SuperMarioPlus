package View;

import Controller.Controller;
import Loading.ImageLoader;
import Loading.LevelLoader;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game extends JFrame {
    // Fields
    private AnimationPanel mainPanel;
    private final Level level;
    private final Controller controller;
    private final PhysicsHandler physicsHandler;

    //  Constructor
    public Game(Level level){
        this.level = level;
        physicsHandler = new PhysicsHandler(level);
        this.controller = new Controller(level.getActivePart(),this.physicsHandler);
        this.addKeyListener(this.controller);
        initFrame();
        initAnimation();
    }

    // Methods
    void initFrame(){
        // Initializing the main frame
        this.setTitle("Super Mario +");
        this.setSize(1280,800);
        this.setIconImage(ImageLoader.getIcon().getImage());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Creating and configuring components
        JLabel coinImage = new JLabel(ImageLoader.getCoinBiggerImage());
        JLabel coinLabel = new JLabel("0");
        JLabel heartImage = new JLabel(ImageLoader.getHeartImage());
        JLabel heartLabel = new JLabel(String.valueOf(this.level.getActivePart().getHeroes()[0].getLives()));

        coinLabel.setFont(new Font("Forte",Font.PLAIN,35));
        heartLabel.setFont(new Font("Forte",Font.PLAIN,35));

        // Setting main panel up
        this.mainPanel = new AnimationPanel(this.level, new Image[]{ImageLoader.getL1P1Image(),ImageLoader.getL1P2Image()},this.physicsHandler,coinLabel,heartLabel);
        this.mainPanel.setLayout(null);
        this.setContentPane(this.mainPanel);

        // Adding components to the panel
        this.mainPanel.add(coinImage);
        this.mainPanel.add(coinLabel);
        this.mainPanel.add(heartImage);
        this.mainPanel.add(heartLabel);

        // Setting components' locations
        coinImage.setBounds(0,0,100,100);
        coinLabel.setBounds(85,30,150,50);
        heartImage.setBounds(100,0,100,100);
        heartLabel.setBounds(185,30,150,50);

    }
    void initAnimation(){
        this.mainPanel.startTheAnimation();
        for (Enemy enemy : this.level.getActivePart().getEnemies()){
            if (enemy instanceof Plant){
                ((Plant) enemy).getStopwatch().start();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ImageLoader.load();
        Hero[] heroes = new Hero[]{new Mario(3)};
        Level level1 = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)});
        new Game(level1);
    }

}
