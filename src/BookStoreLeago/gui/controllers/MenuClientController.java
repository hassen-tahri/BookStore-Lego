/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Hassen TAHRI
 */
public class MenuClientController extends Application {

    @FXML
    private Button acceuilButon;
    @FXML
    private Button livreButon;
    @FXML
    private Button profilButon;
    @FXML
    private Button panierButon;
    @FXML
    private Button reclamaButon;
    @FXML
    private Button deconectButon;
    @FXML
    private BorderPane bp;

//    public BorderPane getBp() {
//        return bp;
//    }
    @FXML
    private Label pseudo;

    @FXML
    private void acceuilClic(MouseEvent event) {
        loadPage("acceuilInterface");

    }

    @FXML
    private void meslivresClic(MouseEvent event) {
        loadPage("meslivreClient");
    }

    @FXML
    private void profilClic(MouseEvent event) {
        loadPage("profilClient");
    }

    @FXML
    private void panierClic(MouseEvent event) {
        loadPage("panierClient");
    }

    @FXML
    private void reclamClic(MouseEvent event) {
        loadPage("reclamClient");
    }

    public void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../interfaces/" + page + ".fxml"));
           // /BookStoreLeago/gui/interfaces/menuClient.fxml
        } catch (IOException ex) {
            Logger.getLogger(MenuClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);

    }
 
    
    
    @Override
    public void start(Stage primaryStage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../interfaces/menuClient.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Accueil");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            System.out.println("erreur main");
            Logger.getLogger(MenuClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        launch(args);
//    }

}
