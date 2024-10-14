/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mattiabirti
 */
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Launcher extends Application{
    
    @Override
    public void start (Stage primaryStage){
        
        /**
         * iteration window
         */
        IterationWindow primo = new IterationWindow();
        Scene iterationScene = new Scene(primo, 300, 250);
        Stage iterationStage = new Stage();
        
        iterationStage.setTitle("Scegli la dimensione");
        iterationStage.setScene(iterationScene);
        
        /*iterationStage.setOnHidden(new EventHandler<WindowEvent>() { // "import javafx.event.EventHandler;"
            @Override
            public void handle (WindowEvent event){
                Platform.exit();
                System.exit(0);
            }
        });

        /**
         * main window
         */
        MainWindow seconda = new MainWindow(primo);
        Scene mainScene = new Scene(seconda, 600, 500);
        
        primaryStage.setTitle("Life!");
        primaryStage.setScene(mainScene);
        
        primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle (WindowEvent event){
                Platform.exit();
                System.exit(0);
            }
        });
        
        
        iterationStage.showAndWait();
        primaryStage.show();
        
        
        
        
    }
    
    public static void main (String[] args){
        launch(args);
    }
}
