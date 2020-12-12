/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.entities.Panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

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

    public boolean supprimerLivreDuPanier(Client c, Livre l) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM panier WHERE idClient=? and idLivre=?";
            PreparedStatement pst = cnx
                    .prepareStatement(requete);
            pst.setInt(1, c.getIdClient());
            pst.setInt(2, l.getIdLivre());
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
    public List<Livre> getPanier(Client c)
    {
        List<Livre> myList = new ArrayList<Livre>();
        try {
            String requete = "select titre, livre.prix from livre join panier on panier.idLivre=livre.idLivre where panier.idClient = "+c.getIdClient();
           // String requetePrixT = "select sum(prix) from panier where idClient = "+c.getIdClient();
            
            
            Statement st = cnx
                    .createStatement();
           
            ResultSet rs = st.executeQuery(requete);
    
            while(rs.next()){
                
                String titre = (rs.getString(1));
                Float prix = (rs.getFloat(2));
            
                System.out.println(titre+' '+prix);
                Livre l = new Livre(titre, prix);
                myList.add(l);
               
                
            } 
        } 
        
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

}