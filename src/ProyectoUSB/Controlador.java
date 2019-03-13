/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Laura M
 */
public abstract class Controlador {
    protected Vista ventana;
    protected Modelo modelo;
    protected boolean movY;
    protected boolean movX;
    
    public void mostrarVista(){
        Singleton singleton=Singleton.getSingleton();
        this.ventana.mostrar(singleton.getStage());
    }
    
    class EventoBotonReintentar implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event){
          
    }
    }
    
    class EventoBotonContinuar implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event){
          
    }
    }
    
    class EventoBotonSalir implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent event){
          
    }
    }
    
    public String colision(Movable object1, Movable object2){ //Devuelve la posicion en la que se van a chocar desde la perspectiva del 
                                                              //primer objeto que se pone como parámetro
       boolean cond1=object1.getxPos()<(object2.getxPos()+object2.getWidth())&&(object1.getxPos()+object1.getWidth())>object2.getxPos();
       boolean cond2=object1.getyPos()<(object2.getyPos()+object2.getHeight())&&((object1.getyPos()+object1.getHeight())>object2.getyPos());
                                                              
        if(((object1.getyPos()-1)==(object2.getyPos()+object2.getHeight()))&&(cond1)){                     
            return "UP";
        } else if(((object1.getyPos()+object1.getHeight()+1)==(object2.getyPos()))&&(cond1)){
            return "DOWN";
        }else if(((object1.getxPos()+object1.getWidth()+1)==(object2.getxPos()))&&(cond2)){
            return "RIGHT";
        }else if(((object1.getxPos()-1)==(object2.getxPos()+object2.getWidth()))&&(cond2)){
            return "LEFT";
        }
        return "NONE";
    }
    
    public String colision(Movable object, ArrayList<StaticObject> objetos){ //Esta es más eficiente, depende de la necesidad
        
        /*Devuelve la direccion en la que se choca con algun objeto de el arraylist que se le pasa*/
        
        for(StaticObject objeto:objetos){
       
            boolean cond1=object.getxPos()<(objeto.getxPos()+objeto.getWidth())&&(object.getxPos()+object.getWidth())>objeto.getxPos();
            boolean cond2=object.getyPos()<(objeto.getyPos()+objeto.getHeight())&&((object.getyPos()+object.getHeight())>objeto.getyPos());
            
            
        /*if(((object.getyPos()-1)==(objeto.getyPos()+objeto.getHeight()))&&cond1){                     
            return "UP";
        } else if(((object.getyPos()+object.getHeight()+1)==(objeto.getyPos()))&&cond1){
            return "DOWN";
        }else*/ if(((object.getxPos()+object.getWidth()+1)==(objeto.getxPos()))&&cond2){
            return "RIGHT";
        }else if(((object.getxPos()-1)==(objeto.getxPos()+objeto.getWidth()))&&cond2){
            return "LEFT";
        }
        }
        
        return "NONE";
    }
    

    public boolean isMovY() {
        return movY;
    }

    public void setMovY(boolean movY) {
        this.movY = movY;
    }

    public boolean isMovX() {
        return movX;
    }

    public void setMovX(boolean movX) {
        this.movX = movX;
    }
    
}
