
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattiabirti
 */
public class Cella extends StackPane{
    private int x, y;
    Palle p ;
    boolean occupata;
    static final int cellDim = 50;
    
    public Cella(int x, int y){
        this.x = x;
        this.y = y; 
        p = new Palle();
        
        Rectangle cell = new Rectangle (cellDim, cellDim);
        cell.setFill(Color.TRANSPARENT);
        cell.setStroke(Color.GREEN);     //bordo
        cell.setStrokeWidth(1);
        
        this.getChildren().addAll(cell, p.noPalla());
        this.occupata = false;
        
        /**
         * EVENT
         * se clicco la cella mi aggiunge la palla
         * se è gia occupata la elimina
         */
        this.setOnMouseClicked((event)->{
            modificaCella();
        }
        );
    }
    
    /**
     * metodo che aggiunge o toglie la palla da una cella
     * @param occupata dice se c'è o no la palla nella cella
     */
    private void modificaCella(){
        if(occupata){
                elimina();
            }else{
                Agg();
            }
    }
    
    /**
     * metodo che pulisce la cella
     */
    void elimina(){
        this.p.noPalla();
        this.occupata = false;
    }
    /**
     * metodo che aggiunge la palla alla cella
     */
    void Agg(){
        this.p.aggPalla();
        this.occupata = true;
    }
    
    /**
     * metodo che restituisce la coordinata x della cella
     * @return ascissa
     */
    public int getX (){
        return x;
    }
    
    /**
     * metodo che restituisce la coordinata y della cella
     * @return ordinata
     */
    public int getY (){
        return y;
    }
}
