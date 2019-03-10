/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;


/**
 *
 * @author Juan
 */
public class ControladorNivel1 {
    private Nivel1 n1;
    
    public ControladorNivel1(){
    this.n1 = new Nivel1();
            
}
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.n1.mostrar(singleton.getStage());
    }
}
