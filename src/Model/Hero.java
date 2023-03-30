package Model;

public class Hero extends Character{
    // Fields
    private int score,coin;

    // Constructor
    public Hero(int lives, double[] coordinates, int height, int width, double[] velocity, int score,int coin) {
        super(lives, coordinates, height, width, velocity);
        this.score = score;
        this.coin = coin;
    }
}
