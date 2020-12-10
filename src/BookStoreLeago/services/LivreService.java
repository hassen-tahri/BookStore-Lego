/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassen TAHRI
 */
public class LivreService {

    Connection cnx;

    public LivreService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterLivre(Livre l) {
        try {

            String requete = " INSERT INTO livre (nom , description, auteur, langue, catégorie, prix) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getNom());
            pst.setString(2, l.getDescription());
            pst.setString(3, l.getAuteur());
            pst.setString(4, l.getLangue());
            pst.setString(5, l.getCatégorie());
            pst.setFloat(6, l.getPrix());
            pst.executeUpdate();
            System.out.println("Livre ajoutée ! ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Livre> listerLivre() {
        List<Livre> myList = new ArrayList<Livre>();
        try {
            String requete = "SELECT * FROM livre";
            Statement st = cnx
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();
                l.setIdLivre(rs.getInt(1));
                l.setNom(rs.getString("nom"));

                myList.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    public boolean supprimerLivre(Livre l) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM Livre where idLivre=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, l.getIdLivre());
            pst.executeUpdate();
            System.out.println("Livre supprimée ! ");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etat;
    }

    public void updateLivre(Livre l, int idLivre) {
        try {
            String requete = "UPDATE livre SET description=? , prix=?   WHERE idLivre=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getDescription());
            pst.setDouble(2, l.getPrix());
            pst.setInt(3, idLivre);
            pst.executeUpdate();
            System.out.println("Livre modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
