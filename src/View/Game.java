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
    private final User user;
    private final Controller controller;
    private final PhysicsHandler physicsHandler;

    //  Constructor
    public Game(Level level, User user){
        this.level = level;
        this.user = user;
        physicsHandler = new PhysicsHandler(level,user);
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
        JLabel scoreImage = new JLabel(ImageLoader.getScoreImage());
        JLabel scoreLabel = new JLabel("0");

        coinLabel.setFont(new Font("Forte",Font.PLAIN,35));
        heartLabel.setFont(new Font("Forte",Font.PLAIN,35));
        scoreLabel.setFont(new Font("Forte",Font.PLAIN,35));

        // Setting main panel up
        this.mainPanel = new AnimationPanel(this.level, new Image[]{ImageLoader.getL1P1Image(),ImageLoader.getL1P2Image()},this.physicsHandler,coinLabel,heartLabel,scoreLabel,this);
        this.mainPanel.setLayout(null);
        this.setContentPane(this.mainPanel);

        // Adding components to the panel
        this.mainPanel.add(coinImage);
        this.mainPanel.add(coinLabel);
        this.mainPanel.add(heartImage);
        this.mainPanel.add(heartLabel);
        this.mainPanel.add(scoreLabel);
        this.mainPanel.add(scoreImage);

        // Setting components' locations
        coinImage.setBounds(0,0,100,100);
        coinLabel.setBounds(85,30,150,50);
        heartImage.setBounds(105,0,100,100);
        heartLabel.setBounds(190,30,150,50);
        scoreImage.setBounds(200,0,100,100);
        scoreLabel.setBounds(285,30,150,50);

    }
    void initAnimation(){
        this.mainPanel.startTheAnimation();
        for (Enemy enemy : this.level.getActivePart().getEnemies()){
            if (enemy instanceof Plant){
                ((Plant) enemy).getStopwatch().start();
            }
        }
    }
    void finishGame(){
        new MainPage(this.user);
        Game.super.dispose();
    }

    public static void main(String[] args) throws IOException {
        Hero[] heroes = new Hero[]{new Mario(3)};
        Level level1 = new Level(new Part[]{LevelLoader.newL1P1(heroes),LevelLoader.newL1P2(heroes)});
//        Gson gson = new Gson();
//        // Convert the JSON string to a list of objects
//        String jsonString = gson.toJson(level1);
//        try (FileWriter fileWriter = new FileWriter("src/Test.json")) {
//            fileWriter.write(jsonString);
//        }
//        try (FileReader fileReader = new FileReader("src/Test.json")) {
//            // Convert the JSON string to a list of objects
//            Level level2 = gson.fromJson(fileReader, Level.class);
//        }
        System.out.println("SAG");
        User user1 = new User("SABZ","SARD");
        System.out.println(user1.getCoin()+" "+ user1.getHighscore());
        new Game(level1,user1);
        System.out.println(user1.getCoin()+" "+ user1.getHighscore());
    }

}
