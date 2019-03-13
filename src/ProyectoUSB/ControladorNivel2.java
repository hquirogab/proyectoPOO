/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

/**
 *
 * @author Juan
 */
public class ControladorNivel2 {
     private Nivel2 n2;
    
    public ControladorNivel2(){
    this.n2 = new Nivel2();
}
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.n2.mostrar(singleton.getStage());
    }
}
