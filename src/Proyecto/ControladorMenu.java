/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Juan
 */
public class ControladorMenu {
    private Menu menu;

    public ControladorMenu() {
        this.menu = new Menu();
        
        //adicionar eventos
        
        this.menu.getPlay().setOnAction(new EventoPlay());
        this.menu.getOptions().setOnAction(new EventoOptions());
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
           ControladorNivel1 n = new ControladorNivel1();
           n.mostrarVista();
        }
        
    }
    
    class EventoOptions implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
           //Controlador2 c2 = new Controlador2(modelo);
           //c2.mostrarVista();
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
           //Controlador2 c2 = new Controlador2(modelo);
           //c2.mostrarVista();
        }
        
    }

    public Menu getVentana1() {
        return menu;
    }
    
    
    
}
