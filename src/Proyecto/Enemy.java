/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.scene.image.Image;

/**
 *
 * @author Gloria
 */
public class Enemy extends Movable implements Runnable {
    
    
    public Enemy(int xPos, int yPos, int xPosFinal, int yPosFinal, Image sprite) {
        super(xPos, yPos, xPosFinal, yPosFinal, sprite);
        this.direction = "UP";
    }
    
    @Override
    public void moveUp(){
        this.yPos-=3;
    }
    
    @Override
    public void moveDown(){
        this.yPos+= 3;
    }
    
    @Override
    public void start(){
        if(yPos > 200 && direction.equals("UP")){
            moveUp();
            if(yPos == 201)direction = "DOWN";
        }
        if(direction.equals("DOWN")){
            moveDown();
            if(yPos == 330)direction = "UP";
        }
    }
    
}
