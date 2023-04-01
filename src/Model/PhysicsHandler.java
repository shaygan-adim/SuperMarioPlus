package Model;

public class PhysicsHandler {
    // Fields
    private final Level level;
    private static int g = -5;
    private static final double dt = 0.1D;

    // Constructor
    public PhysicsHandler(Level level){
        this.level = level;
    }

    // Methods
    public void updatePhysics(){
        for (Hero hero : level.getActivePart().getHeroes()){
            hero.setVy(hero.getVy()+g*dt);
            int n = 0;
            // Handling the physics of blocks
            for (Block block : level.getActivePart().getBlocks()){
                if (hero.getY()-hero.getVy()*dt>=block.getY()-hero.getHeight() && hero.getY()+ hero.getHeight()<block.getY()+block.getHeight() && hero.getX()>block.getX()-hero.getWidth() && hero.getX()<block.getX()+ block.getWidth()) {
                    hero.setVy(0);
                    g=0;
                }
                else{
                    n++;
                }
                if (hero.getY()- hero.getVy()*dt<block.getY()+block.getHeight() && hero.getY()>=block.getY()-hero.getHeight() && hero.getX()>block.getX()-hero.getWidth() && hero.getX()<block.getX()+ block.getWidth()){
                    hero.setVy(0);
                    if (block.getItemInside() instanceof Coin){
                        hero.addCoin();
                    }
                }
                if (hero.getY()+hero.getHeight()>block.getY() && hero.getY()<block.getY()+block.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>block.getX() && hero.getX()<block.getX()){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>block.getY() && hero.getY()<block.getY()+block.getHeight() && hero.getX()+hero.getVx()*dt<block.getX()+ block.getWidth() && hero.getX()+ hero.getWidth()>block.getX()+block.getWidth()){
                    hero.setVx(0);
                }
            }

            // Handling the physics of pipes
            for (Pipe pipe : level.getActivePart().getPipes()){
                if (hero.getY()-hero.getVy()*dt>=pipe.getY()-hero.getHeight() && hero.getY()+ hero.getHeight()<pipe.getY()+pipe.getHeight() && hero.getX()>pipe.getX()-hero.getWidth() && hero.getX()<pipe.getX()+ pipe.getWidth()) {
                    hero.setVy(0);
                    g=0;
                    if (pipe.getPlant()!=null){
                        if (pipe.getPlant().isVisible()){
                            if (hero.getLives()>=2){
                                hero.setLives(hero.getLives()-1);
                                hero.setCoordinates(new double[]{150,200});
                            }
                            else{
                                // TODO
                            }
                        }
                    }
                }
                else{
                    n++;
                }
                if (hero.getY()- hero.getVy()*dt<pipe.getY()+pipe.getHeight() && hero.getY()>=pipe.getY()-hero.getHeight() && hero.getX()>pipe.getX()-hero.getWidth() && hero.getX()<pipe.getX()+ pipe.getWidth()){
                    hero.setVy(0);
                }
                if (hero.getY()+hero.getHeight()>pipe.getY() && hero.getY()<pipe.getY()+pipe.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>pipe.getX() && hero.getX()<pipe.getX()){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>pipe.getY() && hero.getY()<pipe.getY()+pipe.getHeight() && hero.getX()+hero.getVx()*dt<pipe.getX()+ pipe.getWidth() && hero.getX()+ hero.getWidth()>pipe.getX()+pipe.getWidth()){
                    hero.setVx(0);
                }
            }

            // Handling the physics of floors
            int N = 0;
            for (Floor floor : level.getActivePart().getFloors()){
                if (hero.getY()-hero.getVy()*dt>=floor.getY()-hero.getHeight() && hero.getX()>floor.getX()-hero.getWidth() && hero.getX()<floor.getX()+ floor.getWidth()) {
                    hero.setVy(0);
                    g=0;
                }
                else{
                    n++;
                    N++;
                }
                if (hero.getY()+hero.getHeight()>floor.getY() && hero.getY()<floor.getY()+floor.getHeight() && hero.getX()+ hero.getWidth()+hero.getVx()*dt>floor.getX() && hero.getX()<floor.getX()){
                    hero.setVx(0);
                }
                if (hero.getY()+hero.getHeight()>floor.getY() && hero.getY()<floor.getY()+floor.getHeight() && hero.getX()+hero.getVx()*dt<floor.getX()+ floor.getWidth() && hero.getX()+ hero.getWidth()>floor.getX()+floor.getWidth()){
                    hero.setVx(0);
                }
            }
            if (N==this.level.getActivePart().getFloors().length && hero.getY()+hero.getHeight()/2>this.level.getActivePart().getFloors()[0].getY()){
                if (hero.getLives()>=2){
                    hero.setLives(hero.getLives()-1);
                    hero.setCoordinates(new double[]{150,200});
                }
                else{
                    // TODO
                }
            }
            hero.addY(-hero.getVy()*dt);
            if (n== level.getActivePart().getFloors().length+ level.getActivePart().getBlocks().length+ level.getActivePart().getPipes().length){
                g = -5;
            }
            if (hero.getX()+ hero.getVx()*dt>150) hero.addX(hero.getVx()*dt);
            else hero.setVx(0);
        }
        updateCoins();
        updatePlants();
        updateActivePart();
    }
    public void jump(){
        if (level.getActivePart().getHeroes()[0].getVy()==0){
            level.getActivePart().getHeroes()[0].setVy(45);
        }
    }
    public void right(){
        level.getActivePart().getHeroes()[0].setVx(40);
    }
    public void stop(){
        level.getActivePart().getHeroes()[0].setVx(0);
    }
    public void left(){
        level.getActivePart().getHeroes()[0].setVx(-40);
    }

    public void updateCoins(){
        for (Hero hero : this.level.getActivePart().getHeroes()){
            for (int i = 0; i< level.getActivePart().getCoins().length ; i++){
                if (level.getActivePart().getCoins()[i].isVisible() && level.getActivePart().getCoins()[i].getX()+ level.getActivePart().getCoins()[i].getWidth()> hero.getX() && level.getActivePart().getCoins()[i].getX()< hero.getX()+ hero.getWidth() && level.getActivePart().getCoins()[i].getY()+ level.getActivePart().getCoins()[i].getHeight()> level.getActivePart().getHeroes()[0].getY() && level.getActivePart().getCoins()[i].getY()< level.getActivePart().getHeroes()[0].getY()+ level.getActivePart().getHeroes()[0].getHeight()){
                    level.getActivePart().getCoins()[i].setVisible(false);
                    hero.addCoin();
                }
            }
        }
    }

    public void updatePlants(){
        for (Enemy enemy : level.getActivePart().getEnemies()){
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
    public void updateActivePart(){
       if (this.level.getActivePart().getHeroes()[0].getX()>5019 && this.level.getActivePart().getHeroes()[0].getY()>this.level.getActivePart().getEndY()[0] && this.level.getActivePart().getHeroes()[0].getY()+this.level.getActivePart().getHeroes()[0].getHeight()/2<this.level.getActivePart().getEndY()[1]){
           if (this.level.getActivePart().getId()==this.level.getParts().length-1){
               // TODO
           }
           else{
               this.level.setActivePart(this.level.getParts()[this.level.getActivePart().getId()+1]);
               this.level.getActivePart().getHeroes()[0].setCoordinates(new double[]{150,200});
           }
       }
    }
}
