/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Juan
 */
public class Menu {
    private Scene scene;
    private StackPane grid;
    private Image background;
    private Label title;
    private Button play;
    private Button options;
    private Button highScores;
    private Button exit;
    private ImageView image;
    private VBox vbox; 
    private VBox v1;
    
    public Menu(){
      
    grid = new StackPane();
    //grid.setAlignment(Pos.CENTER);
    grid.setPadding(new Insets(25,25,25,25));
    
    background = new Image("Imagenes/fondoInicio.jpg");
    
    image = new ImageView();
    image.setImage(background);
    grid.getChildren().add(image);
    
    v1 = new VBox(70);
    v1.setAlignment(Pos.BASELINE_CENTER);
    //v1.setLayoutY(500);
    //v1.setLayoutX(500);
    
    vbox = new VBox(20);
    vbox.setAlignment(Pos.BOTTOM_CENTER);
    
    title = new Label("Orion's Maze");
    title.setLayoutX(200);
    title.setLayoutY(0);
    grid.getChildren().add(title);
    //v1.getChildren().add(title);
    
    play = new Button ("Play");
    vbox.getChildren().add(play);
    play.setMaxSize(100, 0);
    
    options = new Button ("Options");
    vbox.getChildren().add(options);
    options.setMaxSize(100, 0);
    
    highScores = new Button ("High Scores");
    vbox.getChildren().add(highScores);
    highScores.setMaxSize(100, 0);
    
    exit = new Button ("Exit");
    vbox.getChildren().add(exit);
    exit.setMaxSize(100, 0);
    
    //grid.getChildren().add(v1);
    grid.getChildren().add(vbox);
    
    scene = new Scene(grid, 650, 406);
    }
    
    public void show(Stage stage) {
      stage.setTitle("Orion's Maze");
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
