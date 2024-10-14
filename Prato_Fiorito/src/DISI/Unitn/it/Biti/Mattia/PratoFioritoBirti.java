/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;
import java.awt.event.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

/**
 *
 * @author mattiabirti
 */
public class PratoFioritoBirti extends Application {
    
    Stage mainWindow = null;
    Scacchiera scacchiera;
    ValueBox txtPunteggio;
    ValueBox txtVittorie;
    BorderPane root;
    Alert alert;
    
    int n = 4;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        settaNumCelle();        //richiama il metodo che modifica la n globale (dimensione scacchiera)
        
        root = new BorderPane();
        
        HBox Contatori = new HBox();
        Label Punteggio = new Label("Punteggio: ");
        Label Vittorie = new Label("Vittorie: ");
        txtPunteggio = new ValueBox("0");
        txtVittorie = new ValueBox("0");
        Contatori.setSpacing(10);
        Contatori.setAlignment(Pos.CENTER);
        Contatori.getChildren().addAll(Punteggio, txtPunteggio, Vittorie, txtVittorie);
        
        HBox Pulsanti = new HBox();
        Pulsanti.setAlignment(Pos.CENTER);
        Pulsanti.setSpacing(30);
        MyButton btnReset = new MyButton("Reset", false, new ListenerReset());
        MyButton btnCheat = new MyButton("Cheat", false, new ListenerCheat());
        Pulsanti.getChildren().addAll(btnReset, btnCheat);
        
        //crea classe scacchiera e relativo costruttore 
        scacchiera = new Scacchiera(n, new ListenerScacchiera());
        
        root.setTop(Contatori);
        root.setCenter(scacchiera);
        root.setBottom(Pulsanti);
        
        Scene scene = new Scene(root, 800, 500);
        mainWindow = primaryStage;
        primaryStage.setTitle("PratoFiortio_BirtiMattia");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * metodo settaNumCelle
     * input numero celle dalla InputDialog class
     * chage la n globale
     */
    private void settaNumCelle(){
        
        boolean numeroValido = true;
        
        do{
            String response = InputDialog.getResponse();
            if(response != null){
                try {
                    n = Integer.parseInt(response);
                    System.out.println(n);
                    if(n>2 && n<10){
                        numeroValido = false;
                    }else {
                        System.out.println("numero fuori range");
                    }
                }
                catch(NumberFormatException nfe){
                    System.out.println("ERRORE FORMATO");
                }
            }
        }while (numeroValido);
    }
    
    /**
     * class ValueBox
     * rispettivi metodi di modifica dei valori (punteggio e vittorie)
     */
    class ValueBox extends TextField{
        
        public ValueBox (String text){
            super(text);
            this.setPrefWidth(40);
            this.setDisable(true);
            this.setAlignment(Pos.CENTER);
        }
        
        public void incrementa (int i){
            int n = Integer.parseInt(this.getText());
            n = n+i;
            this.setText(Integer.toString(n));
        }
        
        public int getNum(){
            return Integer.parseInt(this.getText());
        }
        
    }
    
    /**
     * class MyButton
     * Semplice cotruttore di un Button
     * assegna il rispettivo Listener
     */
    class MyButton extends Button{
        
        public MyButton (String nome, boolean isDisable, EventHandler EH){
            super(nome);
            this.setDisable(isDisable);
            this.addEventHandler(ActionEvent.ACTION, EH);
        }
    }
    
    /**
     * metodo verifica puntggio
     * colora anche il punteggio 
     * dichiara la vittoria
     */
    private void verificaPunteggio(){
        
        if (txtPunteggio.getNum() >10){
            txtPunteggio.setStyle("-fx-control-inner-background:red;");
        } else if (txtPunteggio.getNum() <10){
            txtPunteggio.setStyle("-fx-control-inner-background:blue;");
        } else {
            txtPunteggio.setStyle("-fx-control-inner-background:green;");
            dichiaraVittoria();
        }
    }
    
    /**
     * metodo dichiaravittoria
     * apre un PopUp
     * resetta la scacchiera
     * aggiorna punteggio e vittorie
     */
    private void dichiaraVittoria(){
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("HAI VINTO");
        alert.setHeaderText("Complimenti");
        alert.showAndWait();
        
        txtVittorie.incrementa(1);
        txtPunteggio.setText("0");
        txtPunteggio.setStyle("");
        
        root.getChildren().remove(scacchiera);
        scacchiera = new Scacchiera(n, new ListenerScacchiera());
        root.getChildren().add(scacchiera);
        
    }
    
    /**
     * metodo dichiaraSconfitta
     * apre un PopUp
     */
    private void dichiaraSconfitta(){
        
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("HAIPERSO");
        alert.setHeaderText("peccato");
        
        alert.showAndWait();
        //aggiungi il reset dei label superiori
    }
    
    /**
     * Listener per la scacchiera
     */
    class ListenerScacchiera implements EventHandler{
        
        public void handle(Event t){
            Tessera tmp = (Tessera)t.getSource();       //creo una tessera copia della tessera cliccata
            if(tmp.isNascosta == true){
                int result = tmp.Scopri();              //ritorna il valore e scopre
                
                if (result == -1){
                    dichiaraSconfitta();
                    System.exit(0);
                } else if (result == 0){
                    dichiaraVittoria();
                } else {
                    txtPunteggio.incrementa(result);
                    verificaPunteggio();
                }
            } else {
                int res =((TesseraS)tmp).Nascondi();
                txtPunteggio.incrementa(res);           //ritorna il valore e nasconde
                verificaPunteggio();
            }
            
        }
    }
    
    /**
     * listener per il button Reset
     */
    class ListenerReset implements EventHandler{
        
        public void handle(Event t){
            txtPunteggio.setStyle("");
            txtPunteggio.setText("0");
            txtVittorie.setText("0");
            root.getChildren().remove(scacchiera);
            
            scacchiera = new Scacchiera(n, new ListenerScacchiera());
            root.setCenter(scacchiera);
        }
    }
    
    /**
     * listener per il button Cheat
     */
    class ListenerCheat implements EventHandler{
        
        public void handle (Event t){
            System.out.println("--------------");
            System.out.print(scacchiera+"\n");
            
            Label label = new Label(scacchiera.toString());
            label.setAlignment(Pos.CENTER);
            Scene sc = new Scene (label, 500, 200);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(sc);
            stage.setX(100);
            stage.setY(100);
            stage.initOwner(mainWindow);
            stage.show();
        }
    }
    
}