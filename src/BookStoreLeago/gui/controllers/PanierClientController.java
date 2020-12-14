/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.entities.Panier;
import BookStoreLeago.services.MyConnection;
import BookStoreLeago.services.PanierService;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<Livre, String> id;
    @FXML
    private TableView<Livre> panierTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PanierService ps = new PanierService();

        Client c = new Client(3, "a", "a", "a", "a", "a", "a", true);
        List<Livre> myList = ps.getPanier(c);
        System.out.println(myList);
        
        title.setCellValueFactory(new PropertyValueFactory<Livre, String>("nom"));
        price.setCellValueFactory(new PropertyValueFactory<Livre, Float>("prix"));
        bookImg.setCellValueFactory(new PropertyValueFactory<Livre, String>("nom"));
        id.setCellValueFactory(new PropertyValueFactory<Livre, String>("dateAjout"));

        panierTable.getItems().setAll(myList);
        panierTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ObservableList<Livre> getPanierContent() {

        ObservableList<Livre> data = FXCollections.observableArrayList();

        PanierService ps = new PanierService();

        Client c = new Client(3, "a", "a", "a", "a", "a", "a", true);
        List<Livre> myList = ps.getPanier(c);
        
        for (int i=0;i<myList.size();i++)
        {
            data.add(myList.get(i));
            System.out.println(myList.get(i).getIdLivre());
        }

    return data;
    }

    @FXML
    public void deleteFromPanier(){
        PanierService ps = new PanierService();
    ObservableList<Livre> selectedBooks, allBooks;
    allBooks = panierTable.getItems();
    
   selectedBooks = panierTable.getSelectionModel().getSelectedItems();
   
   for (Livre l: selectedBooks)
   {
       allBooks.remove(l);
       System.out.println(l.getIdLivre());
       ps.supprimerLivreDuPanier(2, l);
       
   }
}
}