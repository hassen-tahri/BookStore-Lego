/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Livre;
import BookStoreLeago.services.MyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class ItemLivreController implements Initializable {

    @FXML
    private Label titreitem;
    @FXML
    private ImageView imgitem;
    @FXML
    private Label prixitem;
    private MyListener myListener;
    private Livre livre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
    }
    
     public void setData(Livre livre, MyListener myListener) throws FileNotFoundException {
        this.livre = livre;
        this.myListener = myListener;
        titreitem.setText(livre.getTitre());
        prixitem.setText(Float.toString(livre.getPrix()));

        String chemin=livre.getChemin();
        File file = new File(chemin);  
        InputStream stream = new FileInputStream(file);
        Image image = new Image(stream);
        
        imgitem.setImage(image);
    }
    
}
