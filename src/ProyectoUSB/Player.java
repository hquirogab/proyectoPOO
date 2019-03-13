/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

/**
 *
 * @author Gloria
 */
public class Player extends Movable {
    private Image right = new Image("Imagenes/right0.png");
    private Image left = new Image("Imagenes/left0.png");
    private Image front = new Image("Imagenes/down1.png");
    private int headWidth;
    private String facingDirection = null;

    
    public Player(int xPos, int yPosCabeza, int width, int height,int headWidth, Image sprite) {
        super(xPos, yPosCabeza, width, height, sprite);
        right = new Image("Imagenes/right0.png");
        left = new Image("Imagenes/left0.png");
        front = new Image("Imagenes/down1.png");    
        this.headWidth=headWidth;
        
    }

    
    @Override
    public void moveLeft(){
        sprite = left;
        facingDirection = "LEFT";
    }
    
    @Override
    public void moveRight(){
        sprite = right;
        facingDirection = "RIGHT";
    }
    
    public void reset(){
        sprite = front;
    }

    public Image getRight() {
        return right;
    }

    public void setRight(Image right) {
        this.right = right;
    }

    public Image getLeft() {
        return left;
    }

    public void setLeft(Image left) {
        this.left = left;
    }

    public Image getFront() {
        return front;
    }

    public void setFront(Image front) {
        this.front = front;
    }

    public int getHeadHeight() {
        return headWidth;
    }

    public void setHeadWidth(int yPosCuerpo) {
        this.headWidth = yPosCuerpo;
    }

    public String getFacingDirection() {
        return facingDirection;
    }
    
    public Projectile shoot(){
        Projectile projectile = new Projectile(xPos, yPos, facingDirection);
        return projectile;
    }
    
    


    
 
    

}
