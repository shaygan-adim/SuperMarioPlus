package Model;

public class Pipe extends PhysicalObject{
    // Fields
    private Plant plantInside;

    // Constructor
    public Pipe(int[] coordinates, int height, int width, Plant plant) {
        super(coordinates, height, width);
        this.plantInside = plant;
    }

    // Setters
    public void setPlant(Plant plant) {this.plantInside = plant;}

    // Getters
    public Plant getPlant() {return plantInside;}
}
