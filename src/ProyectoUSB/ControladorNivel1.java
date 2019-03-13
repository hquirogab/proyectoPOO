/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Juan
 */
public class ControladorNivel1 extends Controlador{
    private Nivel1 ventana;
    private Modelo modelo;
    private boolean paused = false;
    
    public ControladorNivel1(Modelo modelo){
        this.movY=true;
        this.movX=true;
        this.ventana = new Nivel1(modelo);
        this.modelo=modelo;
        this.ventana.getScene().setOnKeyPressed(new ToPressKeyEvent());
        this.ventana.getScene().setOnKeyReleased(new ToReleaseKeyEvent());
        this.ventana.getPause().setOnAction(new PauseEvent());
        
            
}
    
    public void mostrarVista(){
        Singleton singleton = Singleton.getSingleton();
        this.ventana.mostrar(singleton.getStage());
    }
    
    
    class ToPressKeyEvent implements EventHandler<KeyEvent>{
    @Override
    public void handle(KeyEvent event){
          String code = event.getCode().toString();
          
          if(!paused){
            if(!ventana.getKeyPresses().contains(code)){
                        ventana.getKeyPresses().add(code);
            }

            /*Solo se mueve hacia la derecha si no colisiona con ningún objeto en esa dirección*/
            if ((ventana.getKeyPresses().contains("RIGHT") || ventana.getKeyPresses().contains("D"))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("RIGHT"))){
                //System.out.println(colision(ventana.getPlayer(), ventana.getObjects()));
                ventana.getBg().moveLeft();//bg se mueve invertido
                ventana.getBgInverted().moveLeft();
                ventana.getFloor().moveLeft();
                ventana.getPlayer().moveRight();
                for(StaticObject objecto:ventana.getObjects()){
                    objecto.moveLeft();
                }
                for(Enemy enemy : ventana.getEnemigos()){
                    enemy.moveLeft();
                }
                for(Hole hole:ventana.getHoles()){
                    hole.moveLeft();
                    hole.setWidth(hole.getWidth()-15);
                }
            }
            /*Solo se mueve hacia la izquierda si no colisiona con ningún objeto en esa dirección*/
            if ((ventana.getKeyPresses().contains("LEFT") || ventana.getKeyPresses().contains("A"))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("LEFT"))){
                if(ventana.getBg().xPos!=0){
                    ventana.getBg().moveRight();//bg se mueve invertido
                    ventana.getBgInverted().moveRight();
                    ventana.getFloor().moveRight();
                    ventana.getPlayer().moveLeft();
                    for(StaticObject objecto:ventana.getObjects()){
                        objecto.moveRight();
                    }
                    for(Enemy enemy : ventana.getEnemigos()){
                        enemy.moveRight();
                    }
                    for(Hole hole:ventana.getHoles()){
                        hole.moveRight();
                        hole.setWidth(hole.getWidth()+15);
                    }
              }
            }
            /*Solo se mueve hacia arriba si no colisiona con ningún objeto en esa dirección*/
            if (((ventana.getKeyPresses().get(0).equals("UP")||ventana.getKeyPresses().get(ventana.keyPresses.size() -1 ).equals("UP")))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("UP"))){
                ventana.setSalto(true);
            }
            if (((ventana.getKeyPresses().get(0).equals("W")||ventana.getKeyPresses().get(ventana.keyPresses.size() -1 ).equals("W")))&&(!colision(ventana.getPlayer(), ventana.getObjects()).equals("UP"))){
                ventana.setSalto(true);
            }
            if(ventana.getKeyPresses().contains("C")){
                Projectile projectile = ventana.getPlayer().shoot();
                ventana.getProjectiles().add(projectile);
            }
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
            if(!paused){
                ventana.stop();
                paused = true;
                System.out.println("pausa");
            }
            else{
                ventana.start();
                paused = false;
                System.out.println("despausa");
            }
        }
    }
    
  }

