/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import BookStoreLeago.entities.Livre;
import BookStoreLeago.services.LivreService;
import BookStoreLeago.services.MyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class AcceuilClientController implements Initializable {
int idClientConnecte = 8 ; //el methode elli bech ta3meha zay
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private List<Livre> allLivre = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LivreService service = new LivreService();
        allLivre = service.getAllLivreByClientId(idClientConnecte);
        int column = 0;
        int row = 1;
        
        for(int i = 0 ; i< allLivre.size();i++)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../interfaces/itemLivre.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemLivreController itemLivre  = fxmlLoader.getController();
                itemLivre.setData(allLivre.get(i), myListener);
                System.out.println(allLivre);
                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException ex) {
                Logger.getLogger(AcceuilClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }

}
