/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class MejoresPuntuaciones {
    private Scene scene;
    private Label title;
    private Label l1;
    private Label l2;
    private Label l3;
    private Label l4;
    private Label l5;
    private Label l6;
    private Label l7;
    private Label l8;
    private Label l9;
    private Label l10;
    private Button back;
    private Image background;
    private ImageView image;
    private StackPane stackGrid;
   private GridPane grid;
   private VBox vbox;
    
    public MejoresPuntuaciones(){
        
        stackGrid = new StackPane();
        grid = new GridPane();
        grid.setVgap(35);
        grid.setAlignment(Pos.CENTER);
        
        stackGrid.setPadding(new Insets(25, 25, 25, 25));
        stackGrid.setAlignment(Pos.CENTER);
        
        vbox = new VBox(10); //Contiene los botones
        vbox.setAlignment(Pos.CENTER);
        
        background = new Image("Imagenes/Puntua.jpg");
        image = new ImageView(background);
        
        title = new Label ("High Scores");
        
        title.setTextFill(Color.web("#ffffff"));
        title.setFont(new Font("Georgia", 40));
        
        l1 = new Label("1. ABCDEFG : ######");
        l1.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l1);
        
        l2 = new Label("2. ABCDEFG : ######");
        l2.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l2);
        
        l3 = new Label("3. ABCDEFG : ######");
        l3.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l3);
        
        l4 = new Label("4. ABCDEFG : ######");
        l4.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l4);
        
        l5 = new Label("5. ABCDEFG : ######");
        l5.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l5);
        
        l6 = new Label("6. ABCDEFG : ######");
        l6.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l6);
        
        l7 = new Label("7. ABCDEFG : ######");
        l7.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l7);
        
        l8 = new Label("8. ABCDEFG : ######");
        l8.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l8);
        
        l9 = new Label("9. ABCDEFG : ######");
        l9.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l9);
        
        l10 = new Label("10. ABCDEFG : ######");
        l10.setTextFill(Color.web("#ffffff"));
        vbox.getChildren().add(l10);
        
        back = new Button("Back");
        back.setTextFill(Color.web("#000000"));
        vbox.getChildren().add(back);
       
        
        grid.add(title, 0, 1);
        grid.add(vbox, 0, 2);
        GridPane.setHalignment(title, HPos.CENTER); //Centra el titulo en su casilla        
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

    public Label getL1() {
        return l1;
    }

    public Label getL2() {
        return l2;
    }

    public Label getL3() {
        return l3;
    }

    public Label getL4() {
        return l4;
    }

    public Label getL5() {
        return l5;
    }

    public Label getL6() {
        return l6;
    }

    public Label getL7() {
        return l7;
    }

    public Label getL8() {
        return l8;
    }

    public Label getL9() {
        return l9;
    }

    public Label getL10() {
        return l10;
    }

    public Button getBack() {
        return back;
    }
     

}
