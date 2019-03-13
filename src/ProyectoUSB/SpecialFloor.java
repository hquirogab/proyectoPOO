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
public class SpecialFloor extends StaticObject {

    public SpecialFloor(int xPos, int width) {
        super(xPos, width);
        this.ID=2;
        this.yPos=371;
        this.height=200;
        this.sprite=new Image("Imagenes/water.jpg");
    }
    
}