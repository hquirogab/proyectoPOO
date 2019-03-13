/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Juan
 */
public class Nivel3 {
     private Scene scene;
    private GraphicsContext gc;
    private StackPane stackGrid;
    private Image background1;
    private ImageView image1;
    private Button pause;
    private Image background2;
    private ImageView image2;
    private Canvas canvas;
    private int cont=650;
    
    public Nivel3(){
        stackGrid = new StackPane();
        background1 = new Image("Imagenes/esc3.jpg");
        image1 = new ImageView(background1);
        //background2 = new Image("Imagenes/ground.jpg");
        //image2 = new ImageView(background2);
        
        pause = new Button ("Pause");
        
        
        stackGrid.getChildren().add(image1);
        //stackGrid.getChildren().add(pause);
        scene = new Scene (stackGrid, 650, 406);
    }
    public void show(Stage stage) {
      stage.setTitle("Orion's Maze");
      stage.setScene(scene);
      stage.show();
   }
    
    public void mostrar(Stage stage){
        stage.setTitle("Ventana 1");
        stage.setScene(scene);
        stage.show();
    }  

    public Button getPause() {
        return pause;
    }
}
