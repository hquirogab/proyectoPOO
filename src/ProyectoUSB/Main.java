/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Juan
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        Modelo modelo = new Modelo();
        
        
        //Invocar el controlador de la vista que se quiere visualizar
        ControladorMenu c1= new ControladorMenu(modelo);
        c1.mostrarVista();
    }
}
