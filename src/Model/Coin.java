package Model;

public class Coin extends Item{
    // Fields
    private double[] coordinates;
    private final int width,height;
    boolean visible = true;

    // Constructor
    public Coin(double[] coordinates, double vy, int width, int height){
        this.coordinates = coordinates;
        this.width = width;
        this.height = height;
    }

    // Setters
    public void setCoordinates(double[] coordinates) {this.coordinates = coordinates;}
    public void setVisible(boolean visible) {this.visible = visible;}

    // Getters
    public double[] getCoordinates() {return coordinates;}
    public boolean isVisible() {return visible;}
    public int getWidth() {return width;}
    public int getHeight() {return height;}
}
