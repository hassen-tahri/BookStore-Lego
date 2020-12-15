/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Reclamation;
import BookStoreLeago.services.MyListener;
import BookStoreLeago.services.ReclamationService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Region;

import javafx.scene.text.Text;
import javafx.scene.image.Image;

import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class ReclamClientController implements Initializable {
int idClientConnecte = 8; //la methode getClientConnecté de zayneb
    @FXML
    private TextArea contenuReclam;
    @FXML
    private Button submitButon;
    @FXML
    private Text msg;

    private List<Reclamation> listReclam = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private ScrollPane scroll;

    public GridPane getGrid() {
        return grid;
    }

    public ScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(ScrollPane scroll) {
        this.scroll = scroll;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }
    @FXML
    private GridPane grid;

    @FXML
    private void saveReclam(ActionEvent event) throws IOException {
        String contenu = contenuReclam.getText();
        if (contenu.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreu d'ajout");
            alert.setContentText("Ce champs ne doits pas etre vide");
            alert.showAndWait();

        } else {
            Reclamation reclamation = new Reclamation(contenu, idClientConnecte);
            ReclamationService reclamServ = new ReclamationService();
            reclamServ.ajoutReclamation(reclamation);
            System.out.println("ajout reclam");
            contenuReclam.setText("");

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("success");
            alert.setContentText("votre reclamation est envoyée ");
            alert.showAndWait();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../interfaces/menuClient.fxml"));
                Parent root2 = loader.load();
                MenuClientController pc2 = loader.getController();
                msg.getScene().setRoot(root2);
                pc2.loadPage("reclamClient");

            } catch (IOException ex) {
                ex.getMessage();
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ReclamationService reclamServ = new ReclamationService();
        listReclam = reclamServ.getReclamationByIdClient(idClientConnecte);
        int column = 1;
        int row = 2;
        try {
            for (int i = 0; i < listReclam.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../interfaces/itemReclam.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemReclamController itemRclamController = fxmlLoader.getController();
                itemRclamController.setData(listReclam.get(i), myListener);

                if (column == 1) {
                    row++;
                    column = 0;

                }

                grid.add(anchorPane, column++, row); //(child,column,row)

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(751);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(139);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
