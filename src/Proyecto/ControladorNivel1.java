/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


/**
 *
 * @author Juan
 */
public class ControladorNivel1 extends Controlador{
    private Nivel1 ventana;
    private Modelo modelo;
    
    public ControladorNivel1(Modelo modelo){
        this.movY=true;
        this.movX=true;
        this.ventana = new Nivel1();
        this.modelo=modelo;
        this.ventana.getScene().setOnKeyPressed(new ToPressKeyEvent());
        this.ventana.getScene().setOnKeyReleased(new ToReleaseKeyEvent());
        
            
}
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.ventana.mostrar(singleton.getStage());
    }
    
   
    
    
    
    class ToPressKeyEvent implements EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent event){

          String code = event.getCode().toString();
            if(!ventana.getKeyPresses().contains(code)){
                        ventana.getKeyPresses().add(code);
            }

            /*Solo se mueve hacia la derecha si no colisiona con ningún objeto en esa dirección*/
            if (ventana.getKeyPresses().contains("RIGHT")&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("RIGHT"))){
                System.out.println(colision(ventana.getPlayer(), ventana.getObjects()));
                ventana.getBg().moveLeft();//bg se mueve invertido
                ventana.getBgInverted().moveLeft();
                ventana.getFloor().moveLeft();
                for(StaticObject objecto:ventana.getObjects()){
                    objecto.moveLeft();
                }
                for(Enemy enemy : ventana.getEnemigos()){
                    enemy.moveLeft();
                }
            }
            /*Solo se mueve hacia la izquierda si no colisiona con ningún objeto en esa dirección*/
            if ((ventana.getKeyPresses().contains("LEFT"))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("LEFT"))){
                if(ventana.getBg().xPos!=0){
                ventana.getBg().moveRight();//bg se mueve invertido
                ventana.getBgInverted().moveRight();
                ventana.getFloor().moveRight();
                for(StaticObject objecto:ventana.getObjects()){
                    objecto.moveRight();
                }
                for(Enemy enemy : ventana.getEnemigos()){
                    enemy.moveRight();
                }
              }
            }
            /*Solo se mueve hacia arriba si no colisiona con ningún objeto en esa dirección*/
            if (((ventana.getKeyPresses().get(0).equals("UP")||ventana.getKeyPresses().get(ventana.keyPresses.size() -1 ).equals("UP")))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("UP"))){
                ventana.setSalto(true);
              /*  if(ventana.getPlayer().getyPos() > 200 && ventana.getPlayer().getDirection().equals("UP")){

                        ventana.getPlayer().moveUp();
              
                        System.out.println(ventana.getPlayer().getyPos());
              
                        if(ventana.getPlayer().getyPos() == 286)ventana.getPlayer().setDirection("DOWN"); //331 - mutiplo de 3
                    
                  ventana.getPlayer().setDirection("DOWN");
                }
                
                if(ventana.getPlayer().getDirection().equals("DOWN")){
                           ventana.getPlayer().moveDown();
                        if(ventana.getPlayer().getyPos() == 331)ventana.getPlayer().setDirection("UP"); ////331 + mutiplo de 3
                }
            }*/
    }
            
    }
    }
    
    class ToReleaseKeyEvent implements EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent event){
        
          String code = event.getCode().toString();
                    if(ventana.getKeyPresses().contains(code)){
                        ventana.getKeyPresses().remove(code);
                    }
                    ventana.setSalto(false);
        }
    }
    
    class PauseEvent implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            try {
                Singleton.getSingleton().getStage().wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorNivel1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    }

