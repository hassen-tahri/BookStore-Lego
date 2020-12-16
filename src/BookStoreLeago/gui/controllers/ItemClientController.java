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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class ItemClientController implements Initializable {

    private MyListener myListener;
    private Client client;
    @FXML
    private Text nom;
    @FXML
    private Text prenom;
    @FXML
    private Text pseudo;
    @FXML
    private Button clicBan;
    @FXML
    private Button clicdeban;

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

    public void setData(Client client, MyListener myListener) {
        this.client = client;
        this.myListener = myListener;
        nom.setText(client.getNom());
        prenom.setText(client.getPrenom());
        pseudo.setText(client.getPseudo());
        if (client.isEtatBan()) {
            clicBan.setDisable(false);
            clicdeban.setDisable(true);
        } else {
            clicBan.setDisable(true);
            clicdeban.setDisable(false);
        }

    }

    @FXML
    private void debanirclient(ActionEvent event) {
        System.out.println("etat client" + client.isEtatBan());
        ClientService service = new ClientService();
        client.setEtatBan(false);
        service.update(client);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../interfaces/menuClient.fxml"));
            Parent root2 = loader.load();
            MenuClientController pc2 = loader.getController();
            clicdeban.getScene().setRoot(root2);
            pc2.loadPage("banir");

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void banirClient(ActionEvent event) {
        System.out.println("etat client" + client.isEtatBan());
        ClientService service = new ClientService();
        client.setEtatBan(true);
        service.update(client);
        System.out.println(Boolean.toString(client.isEtatBan()));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../interfaces/menuClient.fxml"));
            Parent root2 = loader.load();
            MenuClientController pc2 = loader.getController();
            clicdeban.getScene().setRoot(root2);
            pc2.loadPage("banir");

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
