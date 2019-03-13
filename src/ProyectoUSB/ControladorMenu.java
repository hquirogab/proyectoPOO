/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Juan
 */
public class ControladorMenu {
    private Menu menu;
    private Modelo modelo;

    public ControladorMenu(Modelo modelo) {
        this.menu = new Menu();
        this.modelo = new Modelo();
        
        //adicionar eventos
        
        this.menu.getPlay().setOnAction(new EventoPlay());
        this.menu.getHighScores().setOnAction(new EventoHighScores());
        this.menu.getExit().setOnAction(new EventoExit());
    }
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.menu.mostrar(singleton.getStage());
    }
    
    
    //Clase interna - inner class
    class EventoPlay implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           ControladorNivel1 n = new ControladorNivel1(modelo);
           n.mostrarVista();
           menu.getAudio().stop();
        }
        
    }
    
   
    
    class EventoHighScores implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           ControladorMejPun mp = new ControladorMejPun();
           mp.mostrarVista();
        }
        
    }
    
    class EventoExit implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            System.exit(0);
        }
        
    }

    public Menu getVentana1() {
        return menu;
    }
    
    
    
}
