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
public class ControladorNivel3 {
    private Nivel3 n3;
    
    public ControladorNivel3(){
    this.n3 = new Nivel3();
}
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.n3.mostrar(singleton.getStage());
    }
}
