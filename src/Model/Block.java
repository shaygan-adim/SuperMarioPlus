package Model;

public class Block extends PhysicalObject{
    // Fields
    private Item itemInside;

    // Constructor
    public Block(int[] coordinates, int height, int width, Item itemInside) {
        super(coordinates, height, width);
        this.itemInside = itemInside;
    }
    // Setters
    public void setItemInside(Item itemInside) {this.itemInside = itemInside;}

    // Getters
    public Item getItemInside() {return itemInside;}
}
