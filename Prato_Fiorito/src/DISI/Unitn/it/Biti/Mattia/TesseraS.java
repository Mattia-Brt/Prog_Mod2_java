/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import java.util.Random;
import javafx.scene.control.Label;
/**
 *
 * @author mattiabirti
 */
public class TesseraS extends Tessera{
    
    final Random random = new Random();
    Label x;
    
    public TesseraS(){
        Valore = random.nextInt(8)+1;
        x = new Label (Integer.toString(Valore));
    }
    
    public int Scopri(){
        isNascosta = false;
        this.setStyle("-fx-background-color:white; -fx-background-color:black");
        this.getChildren().add(x);
        return Valore;
    }
    
    public int Nascondi(){
        isNascosta = true;
        this.setStyle("-fx-background-color:green; -fx-background-color:black");
        this.getChildren().remove(x);
        return Valore*-1;
    }
}
