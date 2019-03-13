/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoUSB;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Laura M
 */
public abstract class Vista extends AnimationTimer{
    protected Scene scene;
    protected Background bg;
    protected Background bgInverted;
    protected Button reintentar;
    protected Button salir;
    protected Button continuar;
    protected Pane layout;
    protected Canvas canvas;
    protected GraphicsContext pencil;
    protected Image placeholder;
    protected ArrayList<String> keyPresses; 
    protected StaticObject floor;
    protected ArrayList<StaticObject> objects=new ArrayList<>();
    protected ArrayList<Enemy> enemigos;
    protected Player player;
    protected ArrayList<Hole> holes;
    protected int frames;
    protected ArrayList<Projectile> projectiles;
    protected ArrayList<Projectile> enemyProjectiles;

    
    
    public Vista() {
        this.objects=new ArrayList<>();
        this.enemigos=new ArrayList<>();
        this.layout = new Pane();
        this.canvas = new Canvas(650, 406); 
        layout.getChildren().add(canvas); 
        this.scene = new Scene(layout, canvas.getWidth(), canvas.getHeight());
        this.pencil = canvas.getGraphicsContext2D();
        this.keyPresses= new ArrayList<>();   
        this.holes=new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.enemyProjectiles = new ArrayList<>();
    }
    
    
    
    public void mostrar(Stage stage) {
      stage.setTitle("Orion's Maze");
      this.start();
      stage.setScene(this.scene);
      stage.show();
   }

    public Button getReintentar() {
        return reintentar;
    }

    public void setReintentar(Button Reintentar) {
        this.reintentar = Reintentar;
    }

    public Button getSalir() {
        return salir;
    }

    public void setSalir(Button salir) {
        this.salir = salir;
    }

    public Button getContinuar() {
        return continuar;
    }

    public void setContinuar(Button continuar) {
        this.continuar = continuar;
    }

    public Background getBg() {
        return bg;
    }

    public void setBg(Background bg) {
        this.bg = bg;
    }

    public Pane getLayout() {
        return layout;
    }

    public void setLayout(Pane layout) {
        this.layout = layout;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getPencil() {
        return pencil;
    }

    public void setPencil(GraphicsContext pencil) {
        this.pencil = pencil;
    }

    public Image getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Image placeholder) {
        this.placeholder = placeholder;
    }

    public ArrayList<String> getKeyPresses() {
        return keyPresses;
    }

    public void setKeyPresses(ArrayList<String> keyPresses) {
        this.keyPresses = keyPresses;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public Scene getScene() {
        return scene;
    }

    public ArrayList<StaticObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<StaticObject> objects) {
        this.objects = objects;
    }

    public ArrayList<Enemy> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<Enemy> enemigos) {
        this.enemigos = enemigos;
    }

    public Background getBgInverted() {
        return bgInverted;
    }

    public void setBgInverted(Background bgInverted) {
        this.bgInverted = bgInverted;
    }

    public StaticObject getFloor() {
        return floor;
    }

    public void setFloor(StaticObject floor) {
        this.floor = floor;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

    public void setHoles(ArrayList<Hole> holes) {
        this.holes = holes;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    
    
    
}
