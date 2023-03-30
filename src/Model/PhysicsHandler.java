package Model;

public class PhysicsHandler {
    // Fields
    private Level level;
    private static int g = -5;
    private static final double dt = 0.1D;

    // Constructor
    public PhysicsHandler(Level level){
        this.level = level;
    }

    // Methods
    public void updatePhysics(){
        for (Hero hero : level.getHeroes()){
            hero.setVy(hero.getVy()+g*dt);
            int n = 0;
            // Handling the physics of blocks
            for (Block block : level.getBlocks()){
                if (hero.getY()-hero.getVy()*dt>=block.getCoordinates()[1]-hero.getHeight() && hero.getY()+ hero.getHeight()<block.getCoordinates()[1]+block.getHeight() && hero.getX()>block.getCoordinates()[0]-hero.getWidth() && hero.getX()<block.getCoordinates()[0]+ block.getWidth()) {
                    hero.setVy(0);
                    g=0;
                }
                else{
                    n++;
                }
                if (hero.getY()- hero.getVy()*dt<block.getCoordinates()[1]+block.getHeight() && hero.getY()>=block.getCoordinates()[1]-hero.getHeight() && hero.getX()>block.getCoordinates()[0]-hero.getWidth() && hero.getX()<block.getCoordinates()[0]+ block.getWidth()){
                    hero.setVy(0);
                }
                if (hero.getY()+hero.getHeight()>block.getCoordinates()[1] && hero.getY()<block.getCoordinates()[1]+block.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>block.getCoordinates()[0] && hero.getX()<block.getCoordinates()[0]){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>block.getCoordinates()[1] && hero.getY()<block.getCoordinates()[1]+block.getHeight() && hero.getX()+hero.getVx()*dt<block.getCoordinates()[0]+ block.getWidth() && hero.getX()+ hero.getWidth()>block.getCoordinates()[0]+block.getWidth()){
                    hero.setVx(0);
                }
            }

            // Handling the physics of pipes
            for (Pipe pipe : level.getPipes()){
                if (hero.getY()-hero.getVy()*dt>=pipe.getCoordinates()[1]-hero.getHeight() && hero.getY()+ hero.getHeight()<pipe.getCoordinates()[1]+pipe.getHeight() && hero.getX()>pipe.getCoordinates()[0]-hero.getWidth() && hero.getX()<pipe.getCoordinates()[0]+ pipe.getWidth()) {
                    hero.setVy(0);
                    g=0;
                }
                else{
                    n++;
                }
                if (hero.getY()- hero.getVy()*dt<pipe.getCoordinates()[1]+pipe.getHeight() && hero.getY()>=pipe.getCoordinates()[1]-hero.getHeight() && hero.getX()>pipe.getCoordinates()[0]-hero.getWidth() && hero.getX()<pipe.getCoordinates()[0]+ pipe.getWidth()){
                    hero.setVy(0);
                }
                if (hero.getY()+hero.getHeight()>pipe.getCoordinates()[1] && hero.getY()<pipe.getCoordinates()[1]+pipe.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>pipe.getCoordinates()[0] && hero.getX()<pipe.getCoordinates()[0]){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>pipe.getCoordinates()[1] && hero.getY()<pipe.getCoordinates()[1]+pipe.getHeight() && hero.getX()+hero.getVx()*dt<pipe.getCoordinates()[0]+ pipe.getWidth() && hero.getX()+ hero.getWidth()>pipe.getCoordinates()[0]+pipe.getWidth()){
                    hero.setVx(0);
                }
            }

            // Handling the physics of floors
            for (Floor floor : level.getFloors()){
                if (hero.getY()-hero.getVy()*dt>=floor.getCoordinates()[1]-hero.getHeight() && hero.getX()>floor.getCoordinates()[0]-hero.getWidth() && hero.getX()<floor.getCoordinates()[0]+ floor.getWidth()) {
                    hero.setVy(0);
                    g=0;
                }
                else{
                    n++;
                }
                if (hero.getY()+hero.getHeight()>floor.getCoordinates()[1] && hero.getY()<floor.getCoordinates()[1]+floor.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>floor.getCoordinates()[0] && hero.getX()<floor.getCoordinates()[0]){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>floor.getCoordinates()[1] && hero.getY()<floor.getCoordinates()[1]+floor.getHeight() && hero.getX()+hero.getVx()*dt<floor.getCoordinates()[0]+ floor.getWidth() && hero.getX()+ hero.getWidth()>floor.getCoordinates()[0]+floor.getWidth()){
                    hero.setVx(0);
                }
            }
            hero.addY(-hero.getVy()*dt);
            if (n==level.getFloors().length+level.getBlocks().length+level.getPipes().length){
                g = -5;
            }
            if (hero.getX()+ hero.getVx()*dt>150) hero.addX(hero.getVx()*dt);
            else hero.setVx(0);
        }
        updateCoins();
        updatePlants();
    }
    public void jump(){
        if (level.getHeroes()[0].getVy()==0){
            level.getHeroes()[0].setVy(45);
        }
    }
    public void right(){
        level.getHeroes()[0].setVx(40);
    }
    public void stop(){
        level.getHeroes()[0].setVx(0);
    }
    public void left(){
        level.getHeroes()[0].setVx(-40);
    }

    public void updateCoins(){
        for (int i=0 ; i<level.getCoins().length ; i++){
            if (level.getCoins()[i].getCoordinates()[0]+level.getCoins()[i].getWidth()>level.getHeroes()[0].getCoordinates()[0] && level.getCoins()[i].getCoordinates()[0]<level.getHeroes()[0].getCoordinates()[0]+level.getHeroes()[0].getWidth() && level.getCoins()[i].getCoordinates()[1]+level.getCoins()[i].getHeight()>level.getHeroes()[0].getCoordinates()[1] && level.getCoins()[i].getCoordinates()[1]<level.getHeroes()[0].getCoordinates()[1]+level.getHeroes()[0].getHeight()){
                level.getCoins()[i].setVisible(false);
            }
        }
    }

    public void updatePlants(){
        for (Enemy enemy : level.getEnemies()){
            if (enemy instanceof Plant){
                if (((Plant) enemy).getStopwatch().passedTime()> ((Plant) enemy).getTimePeriod()){
                    ((Plant) enemy).getStopwatch().start();
                    if (((Plant) enemy).isVisible()){
                        ((Plant) enemy).setVisible(false);
                    }
                    else{
                        ((Plant) enemy).setVisible(true);
                    }
                }
            }
        }
    }
}
