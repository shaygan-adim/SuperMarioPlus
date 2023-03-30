package Controller;

import Model.Level;
import Model.PhysicsHandler;
import Model.Pipe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener{
    // Fields
    private boolean[] keyPressed = {false,false};
    private Level level;
    private PhysicsHandler physicsHandler;

    // Constructor
    public Controller(Level level, PhysicsHandler physicsHandler){
        this.level = level;
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
