/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import java.util.Collections;

/**
 *
 * @author mattiabirti
 */
public class Scacchiera extends GridPane{
    
    ArrayList<Tessera> ATessere;
    int n;
    int nxn;
    EventHandler eventHandler;
    
    public Scacchiera(int N, EventHandler EH){
        this.setAlignment(Pos.CENTER);
        ATessere = new ArrayList<Tessera>();
        eventHandler = EH;
        n = N;
        nxn = N*N;
        
        GeneraTessere();
        RiempiScacchiera();
    }
    
    /**
     * Metodo GeneraTessere
     * 1 Tessera Vittoria
     * 1 Tessera Perdita
     * NxN -2 tessere S
     * disordina in modo casuale l'ArrayList
     */
    public void GeneraTessere(){
        Tessera tmp;
        
        //aggiunge all'array una tessera Vittoria
        tmp  = new TesseraV();
        tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        ATessere.add(tmp);
        
        //aggiunge all'array una tessera Perdita
        tmp  = new TesseraP();
        tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        ATessere.add(tmp);
        
        //aggiunge all'array le tessere Valori
        for (int i = 0; i<nxn-2; i++){
            tmp = new TesseraS();
            tmp.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
            ATessere.add(tmp);
        }
        
        Collections.shuffle(ATessere);
    }
    
    /**
     * metodo RiempiScacchiera
     * estrae in ordine le teesere dall'Arraylist
     */
    public void RiempiScacchiera(){
        
        int index = 0;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j<n; j++){
                this.add(ATessere.get(index), j, i);
                index++;
            }
        }
    }
    
    /**
     * toString
     * @return copia della Scacchiera in console
     */
    @Override
    public String toString(){
        int tmp;
        String s="";
        
        for (int i=0; i<nxn; i++){
            tmp = ATessere.get(i).Valore();
            
            if(tmp == 0){
                s+="V ";
            } else if(tmp == -1){
                s+="P ";
            } else{
                s+=tmp+" ";
            }
            s+="\t";
            
            if((i+1) % n == 0){
                s+="\n";
            }
        }
        return s;
    }
}
