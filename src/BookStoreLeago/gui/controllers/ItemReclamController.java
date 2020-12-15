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
import static java.lang.System.load;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class ItemReclamController implements Initializable {

    @FXML
    private Text itemContenu;
    @FXML
    private Text datereclam;
    @FXML
    private Text etat;
    @FXML
    private Button butonSupp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Reclamation reclamation;
    private MyListener myListener;

    public void setData(Reclamation reclamation, MyListener myListener) {
        this.reclamation = reclamation;
        this.myListener = myListener;
        itemContenu.setText(reclamation.getContenuReclamation());
        datereclam.setText(reclamation.getDateReclamation().toString());
        if (reclamation.getEtatReclam()) {
            butonSupp.setDisable(true);
            etat.setText("Reclamation traitée");
        } else {
            etat.setText("Reclamation non traitée");
        }

    }

    @FXML
    private void click(MouseEvent event) {
    }

    @FXML
    private void deleteReclam(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Vous voulez vraiment supprimer cette reclamtion");
        alert.setContentText("");

        ButtonType oui = new ButtonType("oui");
        ButtonType non = new ButtonType("non");

        ButtonType buttonTypeCancel = new ButtonType("annuler", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(oui, non, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == oui) {
          
            System.out.println(reclamation.getContenuReclamation());
            ReclamationService reclamServ = new ReclamationService();
            reclamServ.supprimerReclamation(reclamation.getIdReclamation());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../interfaces/menuClient.fxml"));
                Parent root2 = loader.load();
                MenuClientController pc2 = loader.getController();
                etat.getScene().setRoot(root2);
                pc2.loadPage("reclamClient");

            } catch (IOException ex) {
                ex.getMessage();
            }

        } else if (result.get() == non) {
            // ... user chose "Two"
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

}
