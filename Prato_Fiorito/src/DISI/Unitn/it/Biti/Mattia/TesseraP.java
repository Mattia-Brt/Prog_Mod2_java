/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import javafx.scene.control.Label;
/**
 *
 * @author mattiabirti
 */
public class TesseraP extends Tessera{
    
    public TesseraP(){
        Valore = -1;
    }
    
    public int Scopri(){
        isNascosta = false;
        this.setStyle("-fx-background-color:grey; -fx-background-color:black");
        this.getChildren().add(new Label("P"));
        return -1;
    }
}
