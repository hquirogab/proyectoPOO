/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Gloria
 */
public class Projectile extends Movable {
    private String movingDirection;
    private Rectangle hitbox;

    public Projectile(int xPos, int yPos, String direction) {
        super(xPos, yPos, 0, 0, null);
        this.sprite = new Image("Imagenes/laser2.png");
        this.movingDirection = direction;
        this.hitbox = new Rectangle(xPos, yPos, width, height);
        this.width = (int)sprite.getWidth();
        this.height = (int)sprite.getHeight();
    }

    public String getMovingDirection() {
        return movingDirection;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }
    
    @Override
    public void moveRight(){
        xPos ++;
    }
    
    @Override
    public void moveLeft(){
        xPos --;
    }
    
    @Override
    public void start(){
        if(movingDirection.equals("RIGHT")){
            moveRight();
        }
        if(movingDirection.equals("LEFT")){
            moveLeft();
        }
    }
}
