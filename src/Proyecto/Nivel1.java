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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
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
    private boolean objectUp;
    private boolean objectDown;
    
    public Nivel1(){
        
        objectUp=false;
        objectDown=true;
        
        
        
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
        
        
        this.player = new Player(300, 331, 29, 39, 20, new Image("Imagenes/down1.png"));
        this.floor= new StaticObject(0, 371, 300, 200, new Image("Imagenes/alienfloor1_normal.jpg"));
        this.bg=new Background(0, 0, 1800, 860, new Image("Imagenes/fondoN1.jpg"));
        this.bgInverted=new Background(0, 0, 1800, 860, new Image("Imagenes/fondoN1invertido.jpg"));
        
        StaticObject plataforma0=new StaticObject(495, 346, 59, 14, new Image("Imagenes/alienfloor2_diffuse.jpg")); //Los terminos x, y deben ser el x, y
        this.objects.add(plataforma0);                                        //del jugador + o - multiplos de quince para que las colisiones se registren 
                                                       //Widht y height deben ser multipos de 15 menos una unidad
                                                       
        Hole hole1=new Hole(800, 1000);
        this.holes.add(hole1);
        
        
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
        
        Shape playerHitbox = new Rectangle(player.getxPos(), player.getyPos(), 29, 39);
        
        if(frames % 2 == 0){
            
            pencil.clearRect(0, 0, 650, 406);
            
            pencil.setFill(Color.BLACK);
            
            if(enemigos.isEmpty()){
                Enemy enemigo = new Enemy(this.floor.getxPos()+600, 324, 40, 40, new Image("Imagenes/left0.png"));
                enemigos.add(enemigo);
            }
            
            
            //Dibuja el suelo con los huecos (no funciona aun)
            //boolean canDrawFloor=true;
            /*for(long n=0; n<9999; n++){
                if(canDrawFloor){
               pencil.drawImage(floor.getSprite(), floor.getxPos(), floor.getyPos(), floor.getWidth(), floor.getHeight());
                }
               for(Hole hole:this.holes){
                
                 if((floor.getxPos()>=hole.getxPos()&&floor.getxPos()<=hole.getWidth())){
                    canDrawFloor=false;
                 } else {canDrawFloor=true;}
               }
            
               floor.setxPos(floor.getxPos()+1);
            }*/
            //floor.setxPos(0);
            
            for(int n=0; n<8; n++){
                pencil.drawImage(floor.getSprite(), floor.getxPos()+(300*(n-1)), floor.getyPos(), floor.getWidth(), floor.getHeight());
              if(n%2==0){
              pencil.drawImage(bg.getSprite(), bg.getxPos()+(1790*n), bg.getyPos(), bg.getWidth(), bg.getHeight());
              } else pencil.drawImage(bgInverted.getSprite(), bgInverted.getxPos()+(1790*n), bgInverted.getyPos(), bgInverted.getWidth(), bgInverted.getHeight());
            }
            
            
            for(StaticObject object:this.objects){
                if(object.getxPos()+object.getWidth()>=0)
                pencil.drawImage(object.getSprite(), object.getxPos(), object.getyPos(), object.getWidth(), object.getHeight());
            }
            
            for(Enemy enemy : this.enemigos){
                if(!enemigos.isEmpty()){
                    Shape enemyHitbox = new Rectangle (enemy.getxPos(), enemy.getyPos(), enemy.getWidth(), enemy.getHeight());
                    Shape comparator = SVGPath.intersect(enemyHitbox, playerHitbox);
                    pencil.drawImage(enemy.getSprite(), enemy.getxPos(), enemy.getyPos());
                    enemy.start();
                    if(/*comparator.getBoundsInLocal().getWidth() != -1 && */comparator.getBoundsInLocal().getHeight() != -1){
                        System.out.println("aaa");
                    }
                }
            }
            
            pencil.drawImage(player.getSprite(), player.getxPos(), player.getyPos());
            pencil.strokeRect(player.getxPos(), player.getyPos(), 29, 39);
            
            //Aqui mira si hay objetos arriba o abajo del personaje
            for(StaticObject objeto:this.objects){
                
               boolean cond1=player.getxPos()<(objeto.getxPos()+objeto.getWidth())&&(player.getxPos()+player.getWidth())>objeto.getxPos();
            
               if(((player.getyPos()-1)==(objeto.getyPos()+objeto.getHeight()))&&cond1){                     
                 objectUp=true;
               } else {
                 objectUp=false;
               }
                 
               if(((player.getyPos()+player.getHeight()+1)==(objeto.getyPos()))&&cond1){
                 objectDown=true;
               } else{
                 objectDown=false;
               }
            }
            
            //Aqui mira exclusivamente si no tiene piso debajo
               if((player.getyPos()+player.getHeight()+1)==(floor.getyPos())){
                 objectDown=true;
               }
               
               /*Idea: Para que el player se caiga, se deben programar los huecos con dos atributos: Posicion x y ancho (width)*/
            
            
            if(salto&&contadorSalto<=50&&!objectUp){
            
                player.moveUp();
                contadorSalto++;
                
            }else if(!objectDown){
                //contadorSalto>0&&
                player.moveDown();
                contadorSalto--;
                salto=false;
            }
            }
            
        
        frames++;
        if(frames == 5) frames = 0;
    }
    
    
}

