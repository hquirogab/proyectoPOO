/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;
import javafx.scene.image.Image;
/**
 *
 * @author Laura M
 */
public class StaticObject extends Movable{
    
    public StaticObject (int xPos, int yPos, int xPosFinal, int yPosFinal, Image sprite) {
        super(xPos, yPos, xPosFinal, yPosFinal, sprite);
    }

    public StaticObject(int xPosIn, int xPosFin) {
        super(xPosIn, xPosFin);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
 
    
}