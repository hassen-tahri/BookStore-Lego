/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testprojet.service;

import edu.connexion.ConnexionDB;
import edu.testprojet.entities.Livre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LivreCRUD {

    Connection cnx;

    public LivreCRUD() {
        cnx = ConnexionDB.getInstance().getCnx();
    }

    public void ajouterLivre(Livre l) {
        try {

            String requete = " INSERT INTO livre ( titre ,auteur,langue,catégorie, description,type,prix, "
                    + "chemin,dateDepo, taille, imageLivre, duree,nbrPage, idClient) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
            PreparedStatement pst = cnx.prepareStatement(requete);
            
            //System.out.println(l.getIdClient());
            pst.setString(1, l.getTitre());
            pst.setString(2, l.getAuteur());
            pst.setString(3, l.getLangue());
            pst.setString(4, l.getCatégorie());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getType());
            pst.setFloat(7, l.getPrix());
            pst.setString(8, l.getChemin());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            Date date;
            date = new Date(System.currentTimeMillis());
            pst.setDate(9, date);
            pst.setFloat(10, l.getTaille());
            pst.setString(11, l.getImageLivre());
            pst.setString(12, l.getDuree());
            pst.setInt(13, l.getNbrPage());
            pst.setInt(14, l.getIdClient());
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
                l.setTitre(rs.getString(2));
                l.setAuteur(rs.getString(3));
                l.setLangue(rs.getString(4));
                l.setCatégorie(rs.getString(5));
                l.setDescription(rs.getString(6));
                l.setType(rs.getString(7));
               l.setPrix(rs.getFloat(8));
                l.setChemin(rs.getString(9));
                l.setDateDepo(rs.getDate(10));
                l.setTaille(rs.getFloat(11));
                l.setImageLivre(rs.getString(12));
                l.setDuree(rs.getString(13));
                l.setNbrPage(rs.getInt(14));
                l.setIdClient(rs.getInt(15));

                
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
