
import javafx.scene.Node;
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
public class Griglia extends GridPane{
    
    public int size;
    /**
     * metodo di default, crea la griglia
     * @param size indica la dimensione NxN
     */
    public Griglia (int size){
        this.size = size;
        
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.add(new Cella(i,j), i, j);
            }
        }
    }
    
    /**
     * metodo per il tasto clear
     */
    public void PulisciGriglia(){
        for (Node n : this.getChildren()){
            Cella c = (Cella) n;
            c.elimina();
        }
    }
    
    
}
