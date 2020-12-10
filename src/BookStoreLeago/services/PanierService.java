/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hassen TAHRI
 */
public class PanierService {

    Connection cnx;

    public PanierService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPanier(Client c) {
        try {
            String requete = "INSERT INTO panier ( idclient)"
                    + "values (?)";

            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setInt(1, c.getIdClient());

            pst.executeUpdate();
            System.out.println("Panier ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean supprimerPanier(Client c) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM panier WHERE idClient=?";
            PreparedStatement pst = cnx
                    .prepareStatement(requete);
            pst.setInt(1, c.getIdClient());
            pst.executeUpdate();
            System.out.println("Panier supprimée");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public void ajouterLivreAuPanier(Client c, Livre l) {
        try {
            String requete = "INSERT INTO panier (idclient,idlivre,prix)"
                    + "values (?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setInt(1, c.getIdClient());
            pst.setInt(2, l.getIdLivre());
            pst.setDouble(3, l.getPrix());

            pst.executeUpdate();
            System.out.println("Livre ajouté au panier!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
