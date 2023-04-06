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
    private final Image[] levelImage;
    private final JLabel coinLabel,heartLabel,scoreLabel,timeLabel,levelLabel,coinImage,heartImage,scoreImage,timeImage,summaryLabel;
    private final JButton nextLevelButton,playAgainButton,homeButton;
    private int iterator=0;

    // Constructor
    public AnimationPanel(Level level, Image[] levelImage, PhysicsHandler physicsHandler,Game game){
        this.level = level;
        this.physicsHandler = physicsHandler;
        this.coinLabel = game.getCoinLabel();
        this.heartLabel = game.getHeartLabel();
        this.scoreLabel = game.getScoreLabel();
        this.timeLabel = game.getTimeLabel();
        this.levelLabel = game.getLevelLabel();
        this.coinImage = game.getCoinImage();
        this.heartImage = game.getHeartImage();
        this.scoreImage = game.getScoreImage();
        this.timeImage = game.getTimeImage();
        this.summaryLabel = game.getSummaryLabel();
        this.homeButton = game.getHomeButton();
        this.nextLevelButton = game.getNextLevelButton();
        this.playAgainButton = game.getPlayAgainButton();
        this.game = game;

        // Loading heroes' images
        Image[] standingHero = new Image[level.getActivePart().getHeroes().length];
        Image[] toRightHero = new Image[level.getActivePart().getHeroes().length];
        Image[] toLeftHero = new Image[level.getActivePart().getHeroes().length];
        int i = 0;
        for (Hero hero : level.getActivePart().getHeroes()){
            if (hero instanceof Mario){
                standingHero[i]=ImageLoader.getMarioInGameImage();
            }
            if (hero instanceof Luigi){
                standingHero[i]=ImageLoader.getLuigiInGameImage();
            }
            i++;
        }
        this.standingHero = standingHero;
        this.levelImage = levelImage;
        gameLoop = new GameLoop(this);
        setSize(new Dimension(1280,800));
    }

    // Methods
    @Override
    protected void paintComponent(Graphics g){
        iterator++;
        super.paintComponent(g);

        if (this.level.getDone()==0){
            // Updating the labels
            this.coinLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getCoin()));
            this.heartLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getLives()));
            this.scoreLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getScore()));
            this.timeLabel.setText(String.valueOf(this.level.getActivePart().getTime()-this.level.getActivePart().getStopwatch().passedTime()));
            this.levelLabel.setText("World "+(this.level.getId()+1)+"-"+(this.level.getActivePart().getId()+1));
            if (this.level.getActivePart().getTime()-this.level.getActivePart().getStopwatch().passedTime()<20){
                this.timeLabel.setForeground(Color.red);
            }
            else{
                this.timeLabel.setForeground(Color.BLACK);
            }

            // Drawing the background
            if (level.getActivePart().getHeroes()[0].getX()<4002){
                g.drawImage(this.levelImage[level.getActivePart().getId()],-(int) level.getActivePart().getHeroes()[0].getX()+150,0,5120,800,this);
            }
            else{
                g.drawImage(this.levelImage[level.getActivePart().getId()],-4002+150,0,5120,800,this);
            }
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
                if (hero.getVy()==0){
                    if (hero.getVx()==0){
                        if (hero.isStandingOnSomething()){
                            if (level.getActivePart().getHeroes()[0].getX()<4002){
                                if (hero instanceof Mario){
                                    g.drawImage(ImageLoader.getMarioInGameImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                                if (hero instanceof Luigi){
                                    g.drawImage(ImageLoader.getLuigiInGameImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            else{
                                if (hero instanceof Mario){
                                    g.drawImage(ImageLoader.getMarioInGameImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                                if (hero instanceof Luigi){
                                    g.drawImage(ImageLoader.getLuigiInGameImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                        else{
                            if (level.getActivePart().getHeroes()[0].getX()<4002){
                                if (hero instanceof Mario){
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                                if (hero instanceof Luigi){
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            else{
                                if (hero instanceof Mario){
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                                if (hero instanceof Luigi){
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                    }
                    else if (hero.getVx()>0){
                        if (level.getActivePart().getHeroes()[0].getX()<4002){
                            if (hero instanceof Mario){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getMarioRightImages()[((Mario) hero).getFrameNumber()],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Mario.getFrameDelay()==0){
                                        ((Mario) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            if (hero instanceof Luigi){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getLuigiRightImages()[((Luigi) hero).getFrameNumber()],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Luigi.getFrameDelay()==0){
                                        ((Luigi) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                        else{
                            if (hero instanceof Mario){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getMarioRightImages()[((Mario) hero).getFrameNumber()],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Mario.getFrameDelay()==0){
                                        ((Mario) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            if (hero instanceof Luigi){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getLuigiRightImages()[((Luigi) hero).getFrameNumber()],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Luigi.getFrameDelay()==0){
                                        ((Luigi) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                    }
                    else{
                        if (level.getActivePart().getHeroes()[0].getX()<4002){
                            if (hero instanceof Mario){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getMarioLeftImages()[((Mario) hero).getFrameNumber()],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Mario.getFrameDelay()==0){
                                        ((Mario) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            if (hero instanceof Luigi){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getLuigiLeftImages()[((Luigi) hero).getFrameNumber()],150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Luigi.getFrameDelay()==0){
                                        ((Luigi) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                        else{
                            if (hero instanceof Mario){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getMarioLeftImages()[((Mario) hero).getFrameNumber()],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Mario.getFrameDelay()==0){
                                        ((Mario) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getMarioJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                            if (hero instanceof Luigi){
                                if (hero.isStandingOnSomething()){
                                    g.drawImage(ImageLoader.getLuigiLeftImages()[((Luigi) hero).getFrameNumber()],150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                    if (iterator%Luigi.getFrameDelay()==0){
                                        ((Luigi) hero).addFrame();
                                    }
                                }
                                else{
                                    g.drawImage(ImageLoader.getLuigiJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                                }
                            }
                        }
                    }
                }
                else{
                    if (level.getActivePart().getHeroes()[0].getX()<4002){
                        if (hero instanceof Mario){
                            g.drawImage(ImageLoader.getMarioJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                        }
                        if (hero instanceof Luigi){
                            g.drawImage(ImageLoader.getLuigiJumpImage(),150,(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                        }
                    }
                    else{
                        if (hero instanceof Mario){
                            g.drawImage(ImageLoader.getMarioJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                        }
                        if (hero instanceof Luigi){
                            g.drawImage(ImageLoader.getLuigiJumpImage(),150-4002+(int) level.getActivePart().getHeroes()[0].getX(),(int)hero.getY(),standingHero[i].getWidth(this),standingHero[i].getHeight(this),this);
                        }
                    }
                }
                i++;
            }
        }
        else if (this.level.getDone()==1){
            stopTheAnimation();

            this.homeButton.setVisible(true);
            this.playAgainButton.setVisible(true);
            this.nextLevelButton.setVisible(true);

            this.coinLabel.setText(String.valueOf(this.level.getTotalCoins()));
            this.heartLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getLives()));
            this.scoreLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getScore()));
            this.timeLabel.setText(String.valueOf(this.level.getTotalTime()));
            this.levelLabel.setText("Level "+(this.level.getId()+1));

            this.timeLabel.setForeground(Color.BLACK);
            this.summaryLabel.setVisible(true);


            heartImage.setBounds(150,390,100,100);
            heartLabel.setBounds(235,420,100,50);
            coinImage.setBounds(150,450,100,100);
            coinLabel.setBounds(235,480,150,50);
            scoreImage.setBounds(150,510,100,100);
            scoreLabel.setBounds(235,540,150,50);
            timeImage.setBounds(150,570,100,100);
            timeLabel.setBounds(235,600,150,50);
            levelLabel.setBounds(177,360,200,50);
            summaryLabel.setBounds(50,270,300,50);
            homeButton.setBounds(1020,450,80,30);
            playAgainButton.setBounds(1008,550,110,30);
            nextLevelButton.setBounds(1008,500,110,30);

            g.drawImage(ImageLoader.getPassedImage(),0,0,this);
        }
        else{
            stopTheAnimation();

            this.heartImage.setVisible(false);
            this.heartLabel.setVisible(false);

            this.homeButton.setVisible(true);
            this.playAgainButton.setVisible(true);

            this.coinLabel.setText(String.valueOf(this.level.getTotalCoins()));
            this.scoreLabel.setText(String.valueOf(this.level.getActivePart().getHeroes()[0].getScore()));
            this.timeLabel.setText(String.valueOf(this.level.getTotalTime()));
            this.levelLabel.setText("Level "+(this.level.getId()+1));

            this.timeLabel.setForeground(Color.BLACK);
            this.summaryLabel.setVisible(true);

            coinImage.setBounds(150,390,100,100);
            coinLabel.setBounds(235,420,150,50);
            scoreImage.setBounds(150,450,100,100);
            scoreLabel.setBounds(235,480,150,50);
            timeImage.setBounds(150,510,100,100);
            timeLabel.setBounds(235,540,150,50);
            levelLabel.setBounds(177,360,200,50);
            summaryLabel.setBounds(50,270,300,50);
            homeButton.setBounds(1020,500,80,30);
            playAgainButton.setBounds(1008,550,110,30);

            g.drawImage(ImageLoader.getGameOverImage(),0,0,this);
        }
    }
    void startTheAnimation() {gameLoop.start();}
    void stopTheAnimation() {gameLoop.stop();}
    void update(){
        physicsHandler.updatePhysics();
        this.repaint();
    }
}
