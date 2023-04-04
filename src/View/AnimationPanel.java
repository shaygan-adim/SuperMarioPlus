package View;

import Loading.ImageLoader;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    // Fields
    private final GameLoop gameLoop;
    private final PhysicsHandler physicsHandler;
    private final Level level;
    private final Game game;
    private final Image[] standingHero;
    private final Image[] toRightHero;
    private final Image[] toLeftHero;
    private final Image[] levelImage;
    private final JLabel coinLabel,heartLabel,scoreLabel;

    // Constructor
    public AnimationPanel(Level level, Image[] levelImage, PhysicsHandler physicsHandler,JLabel coinLabel,JLabel heartLabel,JLabel scoreLabel,Game game){
        this.level = level;
        this.physicsHandler = physicsHandler;
        this.coinLabel = coinLabel;
        this.heartLabel = heartLabel;
        this.scoreLabel = scoreLabel;
        this.game = game;

        // Loading heroes' images
        Image[] standingHero = new Image[level.getActivePart().getHeroes().length];
        Image[] toRightHero = new Image[level.getActivePart().getHeroes().length];
        Image[] toLeftHero = new Image[level.getActivePart().getHeroes().length];
        int i = 0;
        for (Hero hero : level.getActivePart().getHeroes()){
            if (hero instanceof Mario){
                standingHero[i]=ImageLoader.getMarioInGameImage();
                toRightHero[i]=ImageLoader.getMarioToRightImage();
                toLeftHero[i]=ImageLoader.getMarioToLeftImage();
            }
            i++;
        }
        this.standingHero = standingHero;
        this.toRightHero = toRightHero;
        this.toLeftHero = toLeftHero;
        this.levelImage = levelImage;
        gameLoop = new GameLoop(this);
        setSize(new Dimension(1280,800));
    }

    // Methods
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        // Updating the labels
        this.coinLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getCoin()));
        this.heartLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getLives()));
        this.scoreLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getScore()));

        // Drawing the background
        if (level.getActivePart().getHeroes()[0].getX()<4002){
            g.drawImage(this.levelImage[level.getActivePart().getId()],-(int) level.getActivePart().getHeroes()[0].getX()+150,0,5120,800,this);
        }
        else{
            g.drawImage(this.levelImage[level.getActivePart().getId()],-4002+150,0,5120,800,this);
        }

        // Drawing game info


        // Drawing the enemies
        for (Enemy enemy : level.getActivePart().getEnemies()){
            if (enemy instanceof Plant){
                if (((Plant) enemy).isVisible()){
                    g.drawImage(ImageLoader.getPlantImage(),((Plant) enemy).getPipe().getCoordinates()[0]+((Plant) enemy).getPipe().getWidth()/2-enemy.getWidth()/2-(int) level.getActivePart().getHeroes()[0].getX()+150,((Plant) enemy).getPipe().getCoordinates()[1]-enemy.getHeight(),enemy.getWidth(),enemy.getHeight(),this);
                }
            }
        }

        // Drawing the coins
        for (Coin coin : level.getActivePart().getCoins()){
            if (coin.isVisible()){
                if (level.getActivePart().getHeroes()[0].getX()<4002){
                    g.drawImage(ImageLoader.getCoinInGameImage(),-(int) level.getActivePart().getHeroes()[0].getX()+150+(int)coin.getCoordinates()[0],(int)coin.getCoordinates()[1],coin.getWidth(),coin.getHeight(),this);
                }
                else{
                    g.drawImage(ImageLoader.getCoinInGameImage(),-4002+150+(int)coin.getCoordinates()[0],(int)coin.getCoordinates()[1],coin.getWidth(),coin.getHeight(),this);
                }
            }
        }

        // Drawing the heroes
        int i = 0;
        for (Hero hero : level.getActivePart().getHeroes()){
            if (hero.getVx()==0){
                if (level.getActivePart().getHeroes()[0].getX()<4002){
                    g.drawImage(standingHero[i],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
                else{
                    g.drawImage(standingHero[i],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
            }
            else if (hero.getVx()>0){
                if (level.getActivePart().getHeroes()[0].getX()<4002){
                    g.drawImage(toRightHero[i],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
                else{
                    g.drawImage(toRightHero[i],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
            }
            else{
                if (level.getActivePart().getHeroes()[0].getX()<4002){
                    g.drawImage(toLeftHero[i],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
                else{
                    g.drawImage(toLeftHero[i],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                }
            }
            i++;
        }
        if (this.level.isDone()){
            game.finishGame();
        }
    }
    void startTheAnimation() {gameLoop.start();}
    void stopTheAnimation() {gameLoop.stop();}
    void update(){
        physicsHandler.updatePhysics();
        this.repaint();
    }
}
