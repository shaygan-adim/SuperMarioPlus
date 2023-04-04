package Model;

public class Level {
    // Fields
    private final Part[] parts;
    private Part activePart;
    private boolean done = false;

    // Constructor
    public Level(Part[] parts){
        this.parts = parts;
        this.activePart = parts[0];
    }

    // Setters
    public void setActivePart(Part activePart) {this.activePart = activePart;}
    public void setDone(boolean done) {this.done = done;}

    // Getters
    public Part[] getParts() {return parts;}
    public Part getActivePart() {return activePart;}
    public boolean isDone() {return done;}
}
