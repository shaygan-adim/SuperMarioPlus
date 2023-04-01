package Model;

public class Level {
    // Fields
    private final Part[] parts;
    private Part activePart;

    // Constructor
    public Level(Part[] parts){
        this.parts = parts;
        this.activePart = parts[0];
    }

    // Setters
    public void setActivePart(Part activePart) {this.activePart = activePart;}

    // Getters
    public Part[] getParts() {return parts;}
    public Part getActivePart() {return activePart;}
}
