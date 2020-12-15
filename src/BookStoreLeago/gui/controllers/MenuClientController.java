/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Livre;
import BookStoreLeago.services.LivreService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class MenuClientController extends Application implements Initializable {

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
    @FXML
    private Label pseudo;
    @FXML
    private Button statbuton;
    @FXML
    private Button banButon;
    @FXML
    private Button ajouLivre;

    @FXML
    private void acceuilClic(MouseEvent event) throws InterruptedException {
      loadPage("acceuilClient");
    }

    @FXML
    private void meslivresClic(MouseEvent event) {
        loadPage("acceuilClient");
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

    @FXML
    private void statclic(MouseEvent event) {
        loadPage("stat");
    }

    @FXML
    private void banclic(MouseEvent event) {
        loadPage("banir");
    }
     @FXML
    private void ajouLivreClic(MouseEvent event) {
        loadPage("FormulaireAjout");
    }


    void loadPage(String page) {
        Parent root = null;
       
        try { System.out.println("salem");
            root = FXMLLoader.load(getClass().getResource("../interfaces/" + page + ".fxml"));
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadPage("acceuilClient");
  
     
    }

   

}
