package Controller;

import Model.Part;
import Model.PhysicsHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener{
    // Fields
    private boolean[] keyPressed = {false,false};
    private Part part;
    private PhysicsHandler physicsHandler;

    // Constructor
    public Controller(Part part, PhysicsHandler physicsHandler){
        this.part = part;
        this.physicsHandler = physicsHandler;
    }

    // Methods
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            physicsHandler.jump();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || keyPressed[0]){
            keyPressed[0] = true;
            this.physicsHandler.right();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || keyPressed[1]){
            keyPressed[1] = true;
            this.physicsHandler.left();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            keyPressed[0] = false;
            this.physicsHandler.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            keyPressed[1] = false;
            this.physicsHandler.stop();
        }
    }
}
