/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testprojet.gui;

import edu.testprojet.controlleur.Helpers;
import edu.testprojet.entities.Livre;
import edu.testprojet.service.LivreCRUD;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FormulaireAjoutController implements Initializable {

    @FXML
    private Label labelType;
    @FXML
    private TextField tfNom;
    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfAuteur;
    @FXML
    private TextField tfLangue;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfCatégorie;
    @FXML
    private TextField tfTaille;
    @FXML
    private TextField tfChemin;
    @FXML
    private TextField tfImageLivre;
    @FXML
    private TextField tfNbrPage;
    @FXML
    private TextField tfDuree;
    @FXML
    private Button btImage;
    @FXML
    private ListView listeView;
    @FXML
    private TextField tfIdClient;
    @FXML
    private MenuButton listType;

    private String path, path1;
    private FileChooser fc = new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MenuItem item1 = new MenuItem("Audio");
        MenuItem item2 = new MenuItem("PDF");
        listType.getItems().clear();
        listType.getItems().addAll(item1, item2);
        //typeText.setVisible(false);
        item1.setOnAction((e) -> {
            listType.setText("Audio");
            if(tfDuree.isDisabled()) {
                System.out.println("Field is diabled");
                tfDuree.setDisable(false);
                tfNbrPage.setDisable(true);
            }
            else {
                tfNbrPage.setDisable(true);
            }
        });

        item2.setOnAction((e) -> {
            listType.setText("PDF");
            if(tfNbrPage.isDisabled()) {
                tfNbrPage.setDisable(false);
                tfDuree.setDisable(true);
            }
            else {
                tfDuree.setDisable(true);
            }
        });

        // TODO
    }

    @FXML

    private void saveLivre(ActionEvent event) {

        try {
            System.out.println("=================Sauvegarde dans la base==================");
            String titre = tfNom.getText();
            String description = tfDescription.getText();
            String auteur = tfAuteur.getText();
            String langue = tfLangue.getText();
            String categorie = tfCatégorie.getText();
            String chemin = tfChemin.getText();
            String type = listType.getText();
            String duree = tfDuree.getText();
            float prix = (float) tfPrix.getHeight();
            float taille = (float) tfTaille.getHeight();
            String imageLivre = tfImageLivre.getText();
            
            int nbrPage = Helpers.getInputAsInt(tfNbrPage);
            
            int idClient = Integer.parseInt(tfIdClient.getText());
            Livre l = new Livre( titre, auteur, langue, categorie, description, type, prix, chemin, taille, imageLivre, nbrPage, idClient);
            if(!duree.isEmpty()) {
                l.setDuree(duree);
            };
            LivreCRUD lv = new LivreCRUD();
            lv.ajouterLivre(l);
            System.out.println("==================redirection=================");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LivreDetails.fxml"));
            Parent root = loader.load();
            LivreDetailsController lv2 = loader.getController();
            lv2.setResNom(titre);
            lv2.setResDescription(description);
            lv2.setResAuteur(auteur);
            lv2.setResLangue(langue);
            lv2.setResCatégorie(categorie);
            lv2.setResPrix(prix);
            lv2.setResTaille(taille);
            lv2.setResChemin(path);
            lv2.setResImageLivre(path1);
            tfNom.getScene().setRoot(root);
            tfDescription.getScene().setRoot(root);
            tfAuteur.getScene().setRoot(root);
            tfLangue.getScene().setRoot(root);
            tfCatégorie.getScene().setRoot(root);
            tfPrix.getScene().setRoot(root);
            tfTaille.getScene().setRoot(root);
            tfChemin.getScene().setRoot(root);
            tfImageLivre.getScene().setRoot(root);
            tfNbrPage.getScene().setRoot(root);
            tfDuree.getScene().setRoot(root);
            tfIdClient.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(FormulaireAjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void choisirImage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.jpg"));
        File selectedFile = fc.showOpenDialog(tfAuteur.getScene().getWindow());
        path1 = selectedFile.getPath();
        if (path1 != null) {
            tfImageLivre.setText(path1);

        } else {
            System.out.println("file is not valid");
        }
    }

    @FXML
    private void choisirFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("files", "*.pdf"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("files", "*.mp3"));
        File selectedFile = fc.showOpenDialog(tfChemin.getScene().getWindow());
        path = selectedFile.getPath();

        if (path != null) {
            tfChemin.setText(path);

        } else {
            System.out.println("file is not valid");
        }
    }

}
