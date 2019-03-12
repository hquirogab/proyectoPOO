/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Gloria
 */
public class Projectile extends Movable {
    private String direction;
    private Rectangle hitbox;

    public Projectile(int xPos, int yPos, String direction) {
        super(xPos, yPos, 0, 0, null);
        this.sprite = new Image("Imagenes/laser.png");
        this.direction = direction;
        this.hitbox = new Rectangle(xPos, yPos, width, height);
        this.width = (int)sprite.getWidth();
        this.height = (int)sprite.getHeight();
    }

    public String getDirection() {
        return direction;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
    @Override
    public void start(){
        if(direction.equals("RIGHT")){
            moveRight();
        }
        if(direction.equals("LEFT")){
            moveLeft();
        }
    }
}
