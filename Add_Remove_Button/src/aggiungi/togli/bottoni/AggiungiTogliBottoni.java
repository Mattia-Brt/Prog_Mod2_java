/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggiungi.togli.bottoni;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.scene.input.KeyCode;
import javafx.scene.Node;


/**
 *
 * @author mattiabirti
 */
public class AggiungiTogliBottoni extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        final int NBottoni = 9;
        Bottoni[] bottoni = new Bottoni[NBottoni]; //Ho sistemato la dichiarazione degli elementi. Tu dichiaravi l'array e lo inizializzavi NBottoni volte, ma non inizializzavi mai i singoli bottoni. Cosa che ho fatto nel for.
        
        
        for (int i = 0; i<NBottoni; i++){
            bottoni[i] = new Bottoni(i);
            
        }
        
        TilePane tpane = new TilePane();
        tpane.setPrefColumns(3);
        tpane.setPrefHeight(300);
        tpane.setPrefWidth(300);
        
        
        for (int i = 0; i<NBottoni; i++){
            tpane.getChildren().add(bottoni[i].getNode()); //<- ho creato una funzione getNode nella classe Bottoni. Questa ritorna un Node che può essere aggiunto al Pane
            
        }

        Scene scene = new Scene(tpane);
        
        tpane.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){ 
            @Override
            public void handle (KeyEvent Event){
                KeyCode codiceTasto = Event.getCode();
                
                int num = Integer.parseInt(codiceTasto.getName());
                System.out.println(num);
                
                if (bottoni[num].attivo){
                    elimina(tpane, bottoni[num], num, primaryStage, scene);
                }   else {
                    aggiungi(tpane, bottoni[num], num, primaryStage, scene);
                }
                
            }
        });
        
        tpane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle (MouseEvent event){
                for (int i = 0; i<NBottoni; i++){
                    if (bottoni[i].cliccato){
                        bottoni[i].cliccato = false;
                        if (bottoni[i].attivo){
                            elimina(tpane, bottoni[i], i, primaryStage, scene);
                            System.out.println("ciao 1");
                        } else {
                            aggiungi(tpane, bottoni[i], i, primaryStage, scene);
                            System.out.println("ciao 2");
                        }
                    }
                }
            }
        });
        
        
        primaryStage.setTitle("Sghiza Botoni");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void elimina(TilePane tpane, Bottoni btn, int index, Stage stg, Scene sc) {
        btn.EliminaBottone();
        tpane.getChildren().remove(index);
        tpane.getChildren().add(index, btn.getNode());
        sc.setRoot(tpane);
        stg.setScene(sc);
    }
    public void aggiungi(TilePane tpane, Bottoni btn, int index, Stage stg, Scene sc) {
        btn.AttivaBottone();
        tpane.getChildren().remove(index);
        tpane.getChildren().add(index, btn.getNode());
        sc.setRoot(tpane);
        stg.setScene(sc);
    }
    
    
}
