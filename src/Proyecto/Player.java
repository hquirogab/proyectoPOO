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
public class Player extends Movable {
    private Image right = new Image("Imagenes/right0.png");
    private Image left = new Image("Imagenes/left0.png");
    private Image front = new Image("Imagenes/down1.png");
    private int headWidth;
    private boolean canGoDown;
    
    public Player(int xPos, int yPosCabeza, int xPosFinal, int yPosFinal,int headWidth, Image sprite) {
        super(xPos, yPosCabeza, xPosFinal, yPosFinal, sprite);
        right = new Image("Imagenes/right0.png");
        left = new Image("Imagenes/left0.png");
        front = new Image("Imagenes/down1.png");    
        this.headWidth=headWidth;
        this.canGoDown=false;
    }

    
    @Override
    public void moveLeft(){
        sprite = left;
    }
    
    @Override
    public void moveRight(){
        sprite = right;
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

    public boolean getCanGoDown() {
        return canGoDown;
    }

    public void setCanGoDown(boolean canGoDown) {
        this.canGoDown = canGoDown;
    }


    
 
    

}
