package View;

import Controller.Controller;
import Loading.ImageLoader;
import Model.*;

import javax.swing.*;
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
        this.controller = new Controller(this.level,this.physicsHandler);
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

        // Loading and showing the background image
        this.mainPanel = new AnimationPanel(this.level,ImageLoader.getL1P1Image(),this.physicsHandler);
        this.mainPanel.setLayout(null);
        this.setContentPane(this.mainPanel);
    }
    void initAnimation(){
        this.mainPanel.startTheAnimation();
        for (Enemy enemy : this.level.getEnemies()){
            if (enemy instanceof Plant){
                ((Plant) enemy).getStopwatch().start();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ImageLoader.load();
        double[] coordinates = {150,555};
        double[] velocity = {0,0};
        Hero[] heroes = new Hero[1];
        Mario mario = new Mario(3,coordinates,125,80,velocity,0,0);
        heroes[0] = mario;
        int[] coordinates2 = {0,676};
        int[] coordinates3 = {2078,676};
        int[] coordinates4 = {4629,676};
        Floor floor1 = new Floor(coordinates2,100,1879);
        Floor floor2 = new Floor(coordinates3,100,2351);
        Floor floor3 = new Floor(coordinates4,100,491);
        Floor[] floors = {floor1,floor2,floor3};


        int[] coordinates5 = {352,495};
        int[] coordinates6 = {432,495};
        int[] coordinates7 = {627,399};
        int[] coordinates8 = {627,164-47};
        int[] coordinates9 = {891,399};
        int[] coordinates10 = {968,399};
        int[] coordinates11 = {1050,399};
        int[] coordinates12 = {971,164};
        int[] coordinates13 = {1697,337};
        int[] coordinates14 = {1777,337};
        int[] coordinates15 = {1736,91};
        int[] coordinates16 = {2064,496};
        int[] coordinates17 = {2194,416};
        int[] coordinates18 = {2274,416};
        int[] coordinates19 = {2355,245};
        int[] coordinates20 = {2354,0};
        int[] coordinates21 = {2434,0};
        int[] coordinates22 = {2768,496};

        int[] coordinates24 = {2767,245};
        int[] coordinates25 = {2847,245};
        int[] coordinates26 = {3374+55,355};
        int[] coordinates27 = {3454+55,355};
        int[] coordinates28 = {3534+55,355};
        int[] coordinates29 = {3611+55,275};
        int[] coordinates30 = {3612,42};
        int[] coordinates31 = {4016,438};
        int[] coordinates32 = {4096,438};
        int[] coordinates33 = {4096,205};
        int[] coordinates34 = {4799,437};
        int[] coordinates35 = {4879,437};
        int[] coordinates36 = {4959,437};
        int[] coordinates37 = {5039,437};
        int[] coordinates38 = {4799,204};
        int[] coordinates39 = {4879,204};
        int[] coordinates395 = {4720,517};

        Block block1 = new Block(coordinates5,80,80,null);
        Block block2 = new Block(coordinates6,80,80,null);
        Block block3 = new Block(coordinates7,80,80,null);
        Block block4 = new Block(coordinates8,80,80,null);
        Block block5 = new Block(coordinates9,80,80,null);
        Block block6 = new Block(coordinates10,80,80,null);
        Block block7 = new Block(coordinates11,80,80,null);
        Block block8 = new Block(coordinates12,80,80,null);
        Block block9 = new Block(coordinates13,80,80,null);
        Block block10 = new Block(coordinates14,80,80,null);
        Block block11 = new Block(coordinates15,80,80,null);
        Block block12 = new Block(coordinates16,80,80,null);
        Block block13 = new Block(coordinates17,80,80,null);
        Block block14 = new Block(coordinates18,80,80,null);
        Block block15 = new Block(coordinates19,80,80,null);
        Block block16 = new Block(coordinates20,80,80,null);
        Block block17 = new Block(coordinates21,80,80,null);
        Block block18 = new Block(coordinates22,80,80,null);
        Block block20 = new Block(coordinates24,80,80,null);
        Block block21 = new Block(coordinates25,80,80,null);
        Block block22 = new Block(coordinates26,80,80,null);
        Block block23 = new Block(coordinates27,80,80,null);
        Block block24 = new Block(coordinates28,80,80,null);
        Block block25 = new Block(coordinates29,80,80,null);
        Block block26 = new Block(coordinates30,80,80,null);
        Block block27 = new Block(coordinates31,80,80,null);
        Block block28 = new Block(coordinates32,80,80,null);
        Block block29 = new Block(coordinates33,80,80,null);
        Block block30 = new Block(coordinates34,80,80,null);
        Block block31 = new Block(coordinates35,80,80,null);
        Block block32 = new Block(coordinates36,80,80,null);
        Block block33 = new Block(coordinates37,80,80,null);
        Block block34 = new Block(coordinates38,80,80,null);
        Block block35 = new Block(coordinates39,80,80,null);
        Block block36 = new Block(coordinates395,80,80,null);
        Block[] blocks = {block1,block2,block3,block4,block5,block6,block7,block8,block9,block10,block11,block12,block13,block14,block15,block16,block17,block18,block20,block21,block22,block23,block24,block25,block26,block27,block28,block29,block30,block31,block32,block33,block34,block35,block36};

        int[] coordinates40 = {1491,531};
        int[] coordinates41 = {3146,531};
        Pipe pipe1 = new Pipe(coordinates40,150,150,null);
        Pipe pipe2 = new Pipe(coordinates41,150,150,null);
        Pipe[] pipes = {pipe1,pipe2};

        Plant plant = new Plant(1,null,123,172,null,pipe2,3);
        Enemy[] enemies = {plant};
        Level level1 = new Level(blocks,floors,pipes,enemies,heroes,12);
        new Game(level1);
    }

}
