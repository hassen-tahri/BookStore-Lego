/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Client;
import BookStoreLeago.services.ClientService;
import BookStoreLeago.services.MyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class BanirController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
       private List<Client> listClient = new ArrayList<>();
    private MyListener myListener;

    /**
     * Initializes the controller class.
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        ClientService service = new ClientService();
        listClient = service.listerClients();
        int column = 1;
        int row = 2;
        try {
            for (int i = 0; i < listClient.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../interfaces/itemClient.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemClientController itemClientController = fxmlLoader.getController();
                itemClientController.setData(listClient.get(i), myListener);
                System.out.println(listClient.get(i));

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
