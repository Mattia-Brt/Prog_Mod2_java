/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattiabirti
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class calcolatrice extends Application{
    
    boolean isFirst = true;
    Button numeri[] = new Button [10];          //creo i 10 bottoni
    
    
    @Override
    public void start (Stage primarystage){
        
        for (int i = 0; i< numeri.length; i++){
            numeri[i] = new Button();
            numeri[i].setText(String.valueOf(i));   //TESTO ALL'INTERNO DEI BOTTONI

            
        }
        
        
        TextField somma = new TextField("somma");      //nuovi campi di testo
        somma.setEditable(false);
        TextField sottrazione = new TextField("sottrazione");
        sottrazione.setEditable(false);
        TextField moltiplicazione = new TextField("moltiplicazione");
        moltiplicazione.setEditable(false);
        
        
        for (int i = 0 ; i < numeri.length; i++){
            numeri[i].setOnMouseClicked(new EventHandler<MouseEvent>(){
                
                
                @Override
                public void handle (MouseEvent event){
                    
                    
                    if (isFirst){
                        
                    }else{
                        
                    }
                    isFirst = !isFirst;
                }
                
                
                
            }
            );            
        }
        /*zero.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle (MouseEvent event){
                somma.setText("0");
                sottrazione.setText("0");
                moltiplicazione.setText("0");
            }
        }
        );*/
        
        Pane num = new HBox();
        num.getChildren().addAll(numeri);
        
        Pane risultati = new VBox();
        risultati.getChildren().addAll(somma, sottrazione, moltiplicazione);
        
        BorderPane principale = new BorderPane();
        principale.setTop(num);
        principale.setLeft(risultati);
        
        Scene scene = new Scene(principale, 500, 500);
        
        primarystage.setTitle("calcolatrice");
        primarystage.setScene(scene);
        primarystage.show();
        
        
        
    }
     
    
    public static void main (String[] args){
        launch(args);
    }
}
