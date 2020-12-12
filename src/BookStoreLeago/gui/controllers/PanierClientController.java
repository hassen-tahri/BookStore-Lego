/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.services.PanierService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Luoa
 */
public class PanierClientController implements Initializable {

    @FXML
    private TableColumn<Livre, String> bookImg;
    @FXML
    private TableColumn<Livre, String> title;
    @FXML
    private TableColumn<Livre, Float> price;
    @FXML
    private TableColumn<Livre, Button> remove;
    @FXML
    private TableView<Livre> panierTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PanierService ps = new PanierService();

        Client c = new Client(2, "a", "a", "a", "a", "a", "a", true);
        List<Livre> myList = ps.getPanier(c);
        
        title.setCellValueFactory(new PropertyValueFactory<Livre, String>("nom"));
        price.setCellValueFactory(new PropertyValueFactory<Livre, Float>("prix"));
        bookImg.setCellValueFactory(new PropertyValueFactory<Livre, String>("nom"));
        remove.setCellValueFactory(new PropertyValueFactory<Livre, Button>("del"));

        panierTable.getItems().setAll(myList);
    }

    public ObservableList<Livre> getPanierContent() {

        ObservableList<Livre> data = FXCollections.observableArrayList(new Livre("Test", 1));

        PanierService ps = new PanierService();

        Client c = new Client(2, "a", "a", "a", "a", "a", "a", true);
        List<Livre> myList = ps.getPanier(c);
        
        for (int i=0;i<myList.size();i++)
        {
            data.add(myList.get(i));
        }

    return data;
    }

}
