/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 *
 * @author mattiabirti
 */
public abstract class Tessera extends HBox {
    
    boolean isNascosta;
    int Valore;
    
    public Tessera(){
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(30,30);
        this.setStyle("-fx-background-color : yellow; -fx-border-color: black");
        isNascosta = true;
    }
    
    public abstract int Scopri();
    
    public boolean isNascosta(){
        return isNascosta;
    }
    
    public int Valore(){
        return Valore;
    }
    
}
