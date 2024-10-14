/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DISI.Unitn.it.Biti.Mattia;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;
/**
 *
 * @author mattiabirti
 */
public class InputDialog {
    /**
     * copiato da ronchetti
     * @return dimensione griglia
     */
    public static String getResponse(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Dimensione della griglia??");
        dialog.setTitle("Dimensione Grigllia");
        dialog.setContentText("Inserire NUMERO 2<numero<10:  ");
        
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
            return result.get();
        else
            return null;
    }
}
