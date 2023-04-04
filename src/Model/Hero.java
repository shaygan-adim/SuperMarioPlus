package Model;

abstract public class Hero extends Character{
    // Fields
    private int score = 0;
    private int coin = 0;

    // Constructor
    public Hero(int lives, int height, int width) {
        super(lives, new double[]{150,200}, height, width, new double[]{0,0});
    }

    // Methods
    public void addCoin(){this.coin++;}
    public void addCoin(int n){this.coin+=n;}
    public void removeCoin(){this.coin--;}
    public void removeCoin(int n){this.coin-=n;}
    public void emptyCoin(){this.coin = 0;}
    public void addScore(int n){this.score+=n;}

    // Setters
    public void setScore(int score) {this.score = score;}

    // Getters
    public int getScore() {return score;}
    public int getCoin() {return coin;}
}
