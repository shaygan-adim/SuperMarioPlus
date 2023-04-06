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
    private static Image rankingPageImage;
    private static Image gameOverImage;
    private static Image passedImage;
    private static Image marioInGameImage,luigiInGameImage;
    private static Image marioJumpImage;
    private static Image luigiJumpImage;
    private static Image marioRight1Image,marioRight2Image,marioRight3Image,marioRight4Image;
    private static Image marioLeft1Image,marioLeft2Image,marioLeft3Image,marioLeft4Image;
    private static Image luigiRight1Image,luigiRight2Image,luigiRight3Image,luigiRight4Image;
    private static Image luigiLeft1Image,luigiLeft2Image,luigiLeft3Image,luigiLeft4Image;
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
    private static ImageIcon goldImage,silverImage,bronzeImage,rankImage;
    private static ImageIcon marioImage,luigiImage;
    private static ImageIcon marioSmallImage,luigiSmallImage;

    // Methods
    public static void load() throws IOException {
        // Loading backgrounds
        ImageLoader.mainMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/MainMenu.jpg"));
        ImageLoader.userMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/UserMenu.jpg"));
        ImageLoader.profileMenuImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/ProfileMenu.jpg"));
        ImageLoader.rankingPageImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/RankingPage.jpg"));
        ImageLoader.gameOverImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/GameOver.jpg"));
        ImageLoader.passedImage = ImageIO.read(new File("src/Loading/Graphics/Backgrounds/Passed.jpg"));

        // Loading in game characters
        ImageLoader.marioInGameImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioInGame.png"));
        ImageLoader.luigiInGameImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiInGame.png"));

        ImageLoader.marioRight1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight1.png"));
        ImageLoader.marioRight2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight2.png"));
        ImageLoader.marioRight3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight3.png"));
        ImageLoader.marioRight4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioRight4.png"));

        ImageLoader.marioLeft1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft1.png"));
        ImageLoader.marioLeft2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft2.png"));
        ImageLoader.marioLeft3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft3.png"));
        ImageLoader.marioLeft4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioLeft4.png"));

        ImageLoader.luigiRight1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiRight1.png"));
        ImageLoader.luigiRight2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiRight2.png"));
        ImageLoader.luigiRight3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiRight3.png"));
        ImageLoader.luigiRight4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiRight4.png"));

        ImageLoader.luigiLeft1Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiLeft1.png"));
        ImageLoader.luigiLeft2Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiLeft2.png"));
        ImageLoader.luigiLeft3Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiLeft3.png"));
        ImageLoader.luigiLeft4Image = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiLeft4.png"));

        ImageLoader.marioJumpImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Mario/MarioJump.png"));
        ImageLoader.luigiJumpImage = ImageIO.read(new File("src/Loading/Graphics/Characters/Luigi/LuigiJump.png"));

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
        ImageLoader.goldImage = new ImageIcon("src/Loading/Graphics/Other/Gold.png");
        ImageLoader.silverImage = new ImageIcon("src/Loading/Graphics/Other/Silver.png");
        ImageLoader.bronzeImage = new ImageIcon("src/Loading/Graphics/Other/Bronze.png");
        ImageLoader.rankImage = new ImageIcon("src/Loading/Graphics/Other/Rank.png");
        ImageLoader.marioImage = new ImageIcon("src/Loading/Graphics/Characters/Mario/Mario.png");
        ImageLoader.marioSmallImage = new ImageIcon("src/Loading/Graphics/Characters/Mario/MarioSmall.png");
        ImageLoader.luigiImage = new ImageIcon("src/Loading/Graphics/Characters/Luigi/Luigi.png");
        ImageLoader.luigiSmallImage = new ImageIcon("src/Loading/Graphics/Characters/Luigi/LuigiSmall.png");
        ImageLoader.icon = new ImageIcon("src/Loading/Graphics/Other/icon.png");
    }

    // Getters
    public static Image getMainMenuImage() {return mainMenuImage;}
    public static Image getUserMenuImage() {return userMenuImage;}
    public static Image getProfileMenuImage() {return profileMenuImage;}
    public static Image getRankingPageImage() {return rankingPageImage;}
    public static Image getGameOverImage() {return gameOverImage;}
    public static Image getPassedImage() {return passedImage;}
    public static Image getMarioInGameImage() {return marioInGameImage;}
    public static Image getLuigiInGameImage() {return luigiInGameImage;}
    public static Image[] getMarioRightImages(){
        return new Image[]{marioRight1Image,marioRight2Image,marioRight3Image,marioRight4Image};
    }
    public static Image[] getMarioLeftImages(){
        return new Image[]{marioLeft1Image,marioLeft2Image,marioLeft3Image,marioLeft4Image};
    }
    public static Image[] getLuigiRightImages(){
        return new Image[]{luigiRight1Image,luigiRight2Image,luigiRight3Image,luigiRight4Image};
    }
    public static Image[] getLuigiLeftImages(){
        return new Image[]{luigiLeft1Image,luigiLeft2Image,luigiLeft3Image,luigiLeft4Image};
    }
    public static Image getMarioJumpImage() {
        return marioJumpImage;
    }
    public static Image getLuigiJumpImage() {
        return luigiJumpImage;
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
    public static ImageIcon getGoldImage() {return goldImage;}
    public static ImageIcon getSilverImage() {return silverImage;}
    public static ImageIcon getBronzeImage() {return bronzeImage;}
    public static ImageIcon getRankImage() {return rankImage;}
    public static ImageIcon getMarioImage() {return marioImage;}
    public static ImageIcon getMarioSmallImage() {return marioSmallImage;}
    public static ImageIcon getLuigiImage() {return luigiImage;}
    public static ImageIcon getLuigiSmallImage() {return luigiSmallImage;}
    public static ImageIcon getIcon() {return icon;}
}
