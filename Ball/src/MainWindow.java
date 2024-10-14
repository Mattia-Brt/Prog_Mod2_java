
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattiabirti
 */
public class MainWindow extends BorderPane{
    
    public MainWindow(IterationWindow IW){
        
        VBox totale = new VBox();
        HBox head = new HBox();
        Griglia g;
        HBox bottom = new HBox();
        
        Button alg1 = new Button ("Alg1 |^->");
        alg1.setMinSize(150, 30);
        Button alg2 = new Button ("Alg2 |v");
        alg2.setMinSize(150, 30);
        Button alg3 = new Button ("Alg2 <-");
        alg3.setMinSize(150, 30);
        
        Button Print = new Button("Print");
        Print.setMinSize(150, 30);
        Button Clear = new Button ("Clear");
        Clear.setMinSize(150, 30);
        Button Step = new Button ("Step");
        Step.setMinSize(150, 30);
        Button Start = new Button ("Start");
        Start.setMinSize(150, 30);
        
        head.getChildren().addAll(alg1, alg2, alg3);
        g = new Griglia(IW.dimensioneGriglia);
        //g = new Griglia(8);               questo funziona, quello sopra invece no
        bottom.getChildren().addAll(Print, Clear, Step, Start);
        
        totale.getChildren().addAll(head, g, bottom);
        
        
        this.getChildren().add(totale);
        
        
        
        
        
        
        
    }
 
}
