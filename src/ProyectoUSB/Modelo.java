/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Laura M
 */
public class Modelo {
    private int vidas;
    private int salud;
    
    
    public Modelo() {
        this.vidas = 3;
        this.salud = 5;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }
    
}
