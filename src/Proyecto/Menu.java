/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Juan
 */
public class Menu {
    private Scene scene;
    private StackPane stackGrid;
    private Image background;
    private Label title;
    private Button play;
    private Button options;
    private Button highScores;
    private Button exit;
    private ImageView image;
    private VBox internalVBox; 
    private VBox externalVBox;
    private GridPane grid;
    
    public Menu(){
        
        //Contiene todos los elementos
        stackGrid = new StackPane();
        stackGrid.setPadding(new Insets(25, 25, 25, 25));
        stackGrid.setAlignment(Pos.CENTER);
        
        
        internalVBox = new VBox(20); //Contiene los botones
        internalVBox.setAlignment(Pos.CENTER);
        
        //GridPane que contiene el titulo y los botones
        grid = new GridPane();
        grid.setVgap(50);
        grid.setAlignment(Pos.CENTER);
        
        
        
        background = new Image("Imagenes/fondoInicio.jpg");
        image = new ImageView(background);
        
        title = new Label("Orion's Maze");
        title.setTextFill(Color.web("#ffffff"));
        title.setFont(new Font("Georgia", 40));
        
        play = new Button("Play");
        play.setTextFill(Color.web("#000000"));
        play.setMaxWidth(100);
        
        options = new Button("Options");  
        options.setTextFill(Color.web("#000000"));

        options.setMaxWidth(100);
        
        highScores = new Button("High Scores");
        highScores.setTextFill(Color.web("#000000"));
        highScores.setMaxWidth(100);
        
        exit = new Button("Exit");
        exit.setTextFill(Color.web("#000000"));
        exit.setMaxWidth(100);
    
        internalVBox.getChildren().add(play);
        internalVBox.getChildren().add(options);
        internalVBox.getChildren().add(highScores);
        internalVBox.getChildren().add(exit);
        
        //Añade los elementos al GridPane
        grid.add(title, 0, 1);
        grid.add(internalVBox, 0, 2);
        grid.setHalignment(title, HPos.CENTER); //Centra el titulo en su casilla
        
        stackGrid.getChildren().add(image);
        stackGrid.getChildren().add(grid);
        
        scene = new Scene(stackGrid, 650, 406);
    
    
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

    
    public Button getPlay() {
        return play;
    }

    public Button getOptions() {
        return options;
    }

    public Button getHighScores() {
        return highScores;
    }

    public Button getExit() {
        return exit;
    }

    
    
    
}
