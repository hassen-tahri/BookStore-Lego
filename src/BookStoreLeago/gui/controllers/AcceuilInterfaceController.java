/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.UserSession;
import static BookStoreLeago.gui.controllers.RegisterController.loadWindow;
import BookStoreLeago.services.ClientService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class AcceuilInterfaceController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label titreLivre;
    @FXML
    private Label auteur;
    @FXML
    private Label prix;
    @FXML
    private Button inscriButon;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Button connectButon;

    public void authenticateUser(ActionEvent event) {
        Stage stage = (Stage) connectButon.getScene().getWindow();
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {
        ClientService myServices = new ClientService();
        String mdp = pwdField.getText();
        String username = loginField.getText();
        String errorMessage = "";
        System.out.println("username:" + username + "password: " + mdp);
        if (username == null || username.length() == 0) {
            errorMessage += "Please type username  \n";
        }
        if (mdp == null || mdp.length() == 0) {
            errorMessage += "Please type your password \n";
        }
        if (errorMessage.length() != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Alert");
            alert.setHeaderText("Invalid input");
            alert.setContentText(errorMessage);
            alert.show();
        } else {
            Boolean pas = myServices.verifierpassword(mdp, username);
            if (myServices.chercherUtilisateurBylogin(username) && pas == true) {
                Client user = new Client();
                user.setPseudo(username);
                try {
                    UserSession.user = myServices.getuser(user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (myServices.Gettype(username)) {
                    System.out.println("hello Admin");
                    Client userConnecter = myServices.chercherUtilisateurByUsername(username);
//                    imgProgress.setVisible(true);
//                    PauseTransition pauseTransition = new PauseTransition();
//                    pauseTransition.setDuration(Duration.seconds(3));
//                    pauseTransition.setOnFinished(); ev -> {;
                    try {
                        loadWindow(getClass().getResource("/BookStoreLeago/gui/interfaces/reclamClient.fxml"), "Registration", null);
                    } catch (Exception e) {
                        System.out.println(e.getCause());
                        System.out.println(e.getMessage());
                    }
                    loginField.getScene().getWindow().hide();
                    /* Notifications n = Notifications.create()
                                .title("Bienvenue")
                                .text("Vous étes connecté en tant que Administrateur!")
                                .graphic(null)
                                .hideAfter(Duration.seconds(5));
                        n.show();*///      });
                    //      pauseTransition.play();              
                }
                if (!myServices.Gettype(username)) {
                    System.out.println("hello user");
                    Client userConnecter = myServices.chercherUtilisateurByUsername(username);
                    try {
                     loadWindow(getClass().getResource("/BookStoreLeago/gui/interfaces/menuClient.fxml"), "menuClient", null);
                    } catch (Exception e) {
                        System.out.println(e.getCause());
                        System.out.println(e.getMessage());
                    }
                    loginField.getScene().getWindow().hide();

//  loginField.getScene().getWindow().hide();
                    //imgProgress.setVisible(true);
//                    PauseTransition pauseTransition = new PauseTransition();
//                    pauseTransition.setDuration(Duration.seconds(3));
//                    pauseTransition.setOnFinished(ev -> {
                    //yimchi lil interface mta3 accueil
                    /* Notifications n = Notifications.create()
                                .title("Bienvenue")
                                .text("Vous étes connecté !")
                                .graphic(null)
                                .position(Pos.TOP_CENTER)
                                .hideAfter(Duration.seconds(5));
                        n.showInformation();*/
//                    });
                    //  pauseTransition.play();
                    //   }
                }

            } else {

                /* Notifications n = Notifications.create()
                        .title("Bienvenue")
                        .text("Username ou mot de passe invalide!")
                        .graphic(null)
                        .position(Pos.TOP_CENTER)
                        .hideAfter(Duration.seconds(5));
                n.showInformation();/*
                 */
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error valeur");
                alert.setHeaderText("Invalid input");
                alert.setContentText("errorMessage");
                alert.show();

            }

        }

        /**
         * Initializes the controller class.
         */
    }

    @FXML
    void handleInscriButton(ActionEvent event) {
        try {
            loadWindow(getClass().getResource("/BookStoreLeago/gui/interfaces/register.fxml"), "register", null);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        loginField.getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
