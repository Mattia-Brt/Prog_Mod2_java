

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattiabirti
 */
public class IterationWindow extends BorderPane{
    
    public int dimensioneGriglia = 0;
    
    public IterationWindow(){
        GridPane v = new GridPane();
        
        Text titolo = new Text("Scegli la dimensione");
        TextField dim = new TextField();
        Button ok = new Button ("Conferma");
        
        
        v.add(titolo, 1, 0);
        v.add(dim, 1, 1);
        v.add(ok, 1, 2);
        
        this.getChildren().add(v);
        
        ok.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                dimensioneGriglia = Integer.parseInt(dim.getText());
            }
        });
        
        /*ok.setOnMouseClicked((event)->{
            dimensioneGriglia = Integer.parseInt(dim.getText());
            //this.close();
        }
        );*/
        
    }
    
    
    
}
