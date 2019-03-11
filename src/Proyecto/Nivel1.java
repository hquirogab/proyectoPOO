/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Juan
 */
public class Nivel1 extends Vista {
   // private Scene scene;
    private GraphicsContext gc;
    private StackPane stackGrid;
    private Image background1;
    private ImageView image1;
    private Button pause;
    private Image background2;
    private ImageView image2;
    private Canvas canvas;
    private HBox hbox;
    private int cont=650;
    private boolean salto;
    private int contadorSalto;
    
    public Nivel1(){
        contadorSalto=0;
        salto=false;
        stackGrid = new StackPane();
        background1 = new Image("Imagenes/esc1.jpg");
        image1 = new ImageView(background1);
        //background2 = new Image("Imagenes/ground.jpg");
        //image2 = new ImageView(background2);
         
        
        pause = new Button ("Pause");
        pause.setAlignment(Pos.TOP_RIGHT);
        
        
        hbox = new HBox();
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.getChildren().add(pause);
        
        layout.getChildren().add(hbox);
        //scene = new Scene (stackGrid, 650, 406);
        
        
        this.player = new Player(300, 331, 29, 38, 20, new Image("Imagenes/down1.png"));
        this.floor= new StaticObject(0, 370, 650, 200, new Image("Imagenes/alienfloor1_normal.jpg"));
        this.bg=new Background(0, 0, 1800, 860, new Image("Imagenes/fondoN1.jpg"));
        this.bgInverted=new Background(0, 0, 1800, 860, new Image("Imagenes/fondoN1invertido.jpg"));
        
        StaticObject plataforma0=new StaticObject(495, 355, 50, 10, new Image("Imagenes/alienfloor2_diffuse.jpg")); //Los terminos x, y deben ser el x, y
        this.objects.add(plataforma0);                                        //del jugador + o - multiplos de quince para que las colisiones se registren 
 
    }
    public void show(Stage stage) {
      stage.setTitle("Orion's Maze");
      stage.setScene(scene);
      this.start();
      stage.show();
   }

    public boolean getSalto() {
        return salto;
    }

    public void setSalto(boolean salto) {
        this.salto = salto;
    }
    
    
    public void mostrar(Stage stage){
        
        stage.setTitle("Ventana 1");
        this.start();
        stage.setScene(this.scene);
        
        stage.show();
    }  

    public Button getPause() {
        return pause;
    }
    
    public void toJump(){
        this.player.start();
        salto=false;
    }
    
    @Override
    public void handle(long now){

        if(frames % 2 == 0){
            pencil.clearRect(0, 0, 650, 406);
            
            if(enemigos.isEmpty()){
                Enemy enemigo = new Enemy(this.floor.getxPos()+600, 324, 40, 40, new Image("Imagenes/left0.png"));
                enemigos.add(enemigo);
            }
            
            for(int n=0; n<8; n++){
            pencil.drawImage(floor.getSprite(), floor.getxPos()+(649*(n-1)), floor.getyPos(), floor.getWidth(), floor.getHeight());

            if(n%2==0){
            pencil.drawImage(bg.getSprite(), bg.getxPos()+(1799*n), bg.getyPos(), bg.getWidth(), bg.getHeight());
            } else pencil.drawImage(bgInverted.getSprite(), bgInverted.getxPos()+(1919*n), bgInverted.getyPos(), bgInverted.getWidth(), bgInverted.getHeight());
            }
            
            
            for(StaticObject object:this.objects){
                if(object.getxPos()+object.getWidth()>=0)
                pencil.fillRect(object.getxPos(), object.getyPos(), object.getWidth(), object.getHeight());
                pencil.drawImage(object.getSprite(), object.getxPos(), object.getyPos(), object.getWidth(), object.getHeight());
            }
            
            for(Enemy enemy : this.enemigos){
                if(!enemigos.isEmpty()){
                    pencil.drawImage(enemy.getSprite(), enemy.getxPos(), enemy.getyPos());
                    enemy.start();
                }
            }
            
            //Aqui dibuja el rectangulo de la cabeza
            pencil.fillRect(player.getxPos(), player.getyPos(), player.getWidth(), player.getHeadHeight());
            //Aquí dibuja el rectangulo del cuerpo
            pencil.fillRect(player.getxPos(), player.getyPos()+player.getHeadHeight(), player.getWidth(), player.getHeight()-player.getHeadHeight());
            
            pencil.drawImage(player.getSprite(), player.getxPos(), player.getyPos());
            
            
            if(salto&&contadorSalto<=50){
                
                player.moveUp();
                
                /*if(player.getyPos() > 200 && player.getDirection().equals("UP")){

                        player.moveUp();
              
              
                        if(player.getyPos() == 286)player.setDirection("DOWN"); //331 - mutiplo de 3
                    
                }
                
                if(player.getDirection().equals("DOWN")){
                           player.moveDown();
                        if(player.getyPos() == 331)player.setDirection("UP"); ////331 + mutiplo de 3
                }*/
                contadorSalto++;
                
            }else if(contadorSalto>0){
                player.moveDown();
                contadorSalto--;
                salto=false;
            }
            }
            
        
        frames++;
        if(frames == 5) frames = 0;
    }
    
    
}
