/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testprojet.gui;

import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class LivreDetailsController implements Initializable {
    
    @FXML
    private TextField resNom;
    @FXML
    private TextField resDescription;
    @FXML
    private TextField ResAuteur;
    @FXML
    private TextField resLangue;
    @FXML
    private TextField ResCatégorie;
    @FXML
    private TextField resPrix;
    @FXML
    private TextField resTaille;
    @FXML
    private TextField resChemin;
    @FXML
    private TextField resImageLivre;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void setResNom(String nom) {
        this.resNom.setText(nom);
        
    }
    
    void setResDescription(String description) {
        this.resDescription.setText(description);
    }
    
    void setResAuteur(String auteur) {
        this.ResAuteur.setText(auteur);
    }
    
    void setResLangue(String langue) {
        this.resLangue.setText(langue);
    }
    
    void setResCatégorie(String categorie) {
        this.ResCatégorie.setText(categorie);
    }
    void setResChemin(String chemin) {
        this.resChemin.setText(chemin);
    }
    void setResImageLivre(String imageLivre) {
        this.resImageLivre.setText(imageLivre);
    }
    
    void setResPrix(float prix) {
        this.resPrix.setTranslateY(prix);
    }
    void setResTaille(float taille) {
        this.resTaille.setTranslateY(taille);
    }
    
}
