/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggiungi.togli.bottoni;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
/**
 *
 * @author mattiabirti
 */
public class Bottoni extends Button{
    
    public boolean attivo;
    public String testo;
    Button pulsante;
    public int nome;
    boolean cliccato;
    
    public Bottoni(int i){  //costruttore -> input solo il numero e lo crea
        
        this.attivo = true; 
        this.nome = i;
        this.testo = "" + i;
        this.pulsante = new Button(testo);
        this.pulsante.setPrefWidth(100);
        this.pulsante.setPrefHeight(100);
        this.pulsante.setOpacity(100);
        this.cliccato = false;
        
        this.pulsante.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cliccato = true;
                System.out.println("Mouse "+nome);
            }
        });
    }
    
    
   
    public void EliminaBottone(){
        this.pulsante.setOpacity(0.00);  //Sia qui che sotto mancava "pulsante" (era this.setOpacity -> così non aggiorni nessuna opacità)
        this.attivo = false;
        
    }
    
    public void AttivaBottone(){
        this.pulsante.setOpacity(1);
        //this.pulsante.setStyle("-fx-background-color: Yellow");
        this.attivo = true;
        
    }
    
    public Node getNode() {
        return this.pulsante;
    }
        
    
}
