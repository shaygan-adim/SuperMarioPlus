package Loading;

import Model.Mario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

abstract public class ImageLoader {
    // Fields
    private static Image mainMenuImage;
    private static Image userMenuImage;
    private static Image profileMenuImage;
    private static Image gameOverImage;
    private static Image passedImage;
    private static Image marioInGameImage;
    private static Image marioJumpImage;
    private static Image marioRight1Image,marioRight2Image,marioRight3Image,marioRight4Image;
    private static Image marioLeft1Image,marioLeft2Image,marioLeft3Image,marioLeft4Image;
    private static Image plantImage;
    private static Image L1P1Image;
    private static Image L1P2Image;
    private static ImageIcon icon;
    private static ImageIcon yImage;
    private static ImageIcon nImage;
    private static ImageIcon coinImage;
    private static ImageIcon coinBiggerImage;
    private static Image coinInGameImage;
    private static ImageIcon heartImage;
    private static ImageIcon scoreImage;
    private static ImageIcon timeImage;
    private static ImageIcon marioImage;
    private static ImageIcon marioSmallImage;

    // Methods
    public static void load() throws IOException {
        // Loading backgrounds
        ImageLoader.mainMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/MainMenu.jpg"));
        ImageLoader.userMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/UserMenu.jpg"));
        ImageLoader.profileMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/ProfileMenu.jpg"));
        ImageLoader.gameOverImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/GameOver.jpg"));
        ImageLoader.passedImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/Passed.jpg"));

        // Loading in game characters
        ImageLoader.marioInGameImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioInGame.png"));

        ImageLoader.marioRight1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight1.png"));
        ImageLoader.marioRight2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight2.png"));
        ImageLoader.marioRight3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight3.png"));
        ImageLoader.marioRight4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight4.png"));

        ImageLoader.marioLeft1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft1.png"));
        ImageLoader.marioLeft2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft2.png"));
        ImageLoader.marioLeft3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft3.png"));
        ImageLoader.marioLeft4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft4.png"));

        ImageLoader.marioJumpImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioJump.png"));

        ImageLoader.plantImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Plant/Plant.png"));

        // Loading levels
        ImageLoader.L1P1Image = ImageIO.read(new File("src/Loading/Graphics/Levels/L1P1.jpg"));
        ImageLoader.L1P2Image = ImageIO.read(new File("src/Loading/Graphics/Levels/L1P2.jpg"));

        // Loading other stuff
        ImageLoader.yImage = new ImageIcon("src/Loading/Graphics/Other/Y.png");
        ImageLoader.nImage = new ImageIcon("src/Loading/Graphics/Other/N.png");
        ImageLoader.coinImage = new ImageIcon("src/Loading/Graphics/Other/Coin.png");
        ImageLoader.coinBiggerImage = new ImageIcon("src/Loading/Graphics/Other/CoinBigger.png");
        ImageLoader.coinInGameImage = ImageIO.read(new File("src/Loading/Graphics/Other/CoinInGAme.png"));
        ImageLoader.heartImage = new ImageIcon("src/Loading/Graphics/Other/Heart.png");
        ImageLoader.scoreImage = new ImageIcon("src/Loading/Graphics/Other/Score.png");
        ImageLoader.timeImage = new ImageIcon("src/Loading/Graphics/Other/Time.png");
        ImageLoader.marioImage = new ImageIcon("src/Loading/Graphics/Characters/Mario/Mario.png");
        ImageLoader.marioSmallImage = new ImageIcon("src/Loading/Graphics/Characters/Mario/MarioSmall.png");
        ImageLoader.icon = new ImageIcon("src/Loading/Graphics/Other/icon.png");
    }

    // Getters
    public static Image getMainMenuImage() {return mainMenuImage;}
    public static Image getUserMenuImage() {return userMenuImage;}
    public static Image getProfileMenuImage() {return profileMenuImage;}
    public static Image getGameOverImage() {return gameOverImage;}
    public static Image getPassedImage() {return passedImage;}
    public static Image getMarioInGameImage() {return marioInGameImage;}
    public static Image[] getMarioRightImages(){
        return new Image[]{marioRight1Image,marioRight2Image,marioRight3Image,marioRight4Image};
    }
    public static Image[] getMarioLeftImages(){
        return new Image[]{marioLeft1Image,marioLeft2Image,marioLeft3Image,marioLeft4Image};
    }
    public static Image getMarioJumpImage() {
        return marioJumpImage;
    }

    public static Image getPlantImage() {return plantImage;}
    public static Image getL1P1Image() {return L1P1Image;}
    public static Image getL1P2Image() {return L1P2Image;}
    public static ImageIcon getyImage() {return yImage;}
    public static ImageIcon getnImage() {return nImage;}
    public static ImageIcon getCoinImage() {return coinImage;}
    public static ImageIcon getCoinBiggerImage() {return coinBiggerImage;}
    public static Image getCoinInGameImage() {return coinInGameImage;}
    public static ImageIcon getHeartImage() {return heartImage;}
    public static ImageIcon getScoreImage() {return scoreImage;}
    public static ImageIcon getTimeImage() {return timeImage;}
    public static ImageIcon getMarioImage() {return marioImage;}
    public static ImageIcon getMarioSmallImage() {return marioSmallImage;}
    public static ImageIcon getIcon() {return icon;}
}
