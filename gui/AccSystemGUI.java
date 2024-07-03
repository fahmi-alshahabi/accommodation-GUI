/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accsystem.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;                                                                                                                                                                                     
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author james
 */

public class AccSystemGUI extends Application {
    @Override
    public void start(Stage primaryStage)
            throws IOException
   {   
        //load fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAccSystemGUI(3).fxml"));
        
        //load uwe icon for taskbar/top left window
        Image icon = new Image("file:///C:/Users/james/Documents/NetBeansProjects/JavaApplication1/src/resources/UWE.png");
        primaryStage.getIcons().add(icon);
        
        //create stage
        primaryStage.setTitle("Accommodation System");
        Scene accommodationSystemScene = new Scene(loader.load());
        primaryStage.setScene(accommodationSystemScene);
        primaryStage.show(); 
        
    }
        public static void main(String[] args) {
        launch(args);
        
       
    }
}

