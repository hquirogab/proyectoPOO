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
public abstract class Movable extends Thread {
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected Image sprite;
    protected String direction;

    public Movable(int xPos, int yPos, int width, int Height, Image sprite) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.sprite = sprite;
        this.width=width;
        this.height=width;
        this.direction="UP";
    }

    

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    
    public void moveRight(){//Esto nunca se cumple para el player
        this.xPos += 15;
    }
    
    public void moveLeft(){//Esto nunca se cumple para el player
            this.xPos -= 15;
    }
    
    public void moveUp(){
        this.yPos-=1;
        /*for(int i=0; i<45; i++){
            this.yPos=this.yPos-i;
        }*/
        /*int cont=45;
       while(cont>0){
       this.yPos=this.yPos-cont;
       cont--;
       }*/
        
        System.out.println("Deberia moverse");
    }
    
    public void moveDown(){
        this.yPos+=1;
        
       /* for(int i=0; i<45; i++  ){
            this.yPos=this.yPos++;
        }*/
       /*int cont=0;
       while(cont<45){
       this.yPos=this.yPos+cont;
       cont++;
       }*/
              
       
    }
    
    
    public void jump(){
        System.out.println(direction.equals("UP"));

        if(yPos > 200 && direction.equals("UP")){
              System.out.println(direction.equals("UP"));
             // while(direction.equals("UP")){
              moveUp();
              
              
              if(yPos == 286)direction = "DOWN"; //331 - mutiplo de 3
              //}
        }
        if(direction.equals("DOWN")){
            //while(direction.equals("DOWN")){
            moveDown();
            if(yPos == 331)direction = "UP"; ////331 + mutiplo de 3
            //}
        }
    }
    
    @Override
    public void start(){
        jump();
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public int getWidth() {
        return width;
    }

    public void setxPosFinal(int xPosFinal) {
        this.width = xPosFinal;
    }

    public int getHeight() {
        return height;
    }

    public void setyPosFinal(int yPosFinal) {
        this.height = yPosFinal;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    
}

