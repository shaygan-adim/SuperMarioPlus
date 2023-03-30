package Model;

public class Plant extends Enemy{
    // Fields
    private final Pipe pipe;
    private final Stopwatch stopwatch = new Stopwatch(1);
    private boolean visible;
    private final int timePeriod;

    // Constructor
    public Plant(int lives, double[] coordinates, int height, int width, double[] velocity,Pipe pipe,int timePeriod) {
        super(lives, coordinates, height, width, velocity);
        this.pipe = pipe;
        this.timePeriod = timePeriod;
    }

    // Setters
    public void setVisible(boolean visible) {this.visible = visible;}

    // Getters
    public Stopwatch getStopwatch() {return stopwatch;}
    public boolean isVisible() {return visible;}
    public Pipe getPipe() {return pipe;}
    public int getTimePeriod() {return timePeriod;}
}
