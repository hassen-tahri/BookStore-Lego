/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Comments;

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
 * @author Hassen TAHRI
 */
public class CommentsService {
      public void ajouterCom(Comments c) {
        try {
//           
            String requete = "INSERT INTO commentaire (idLivre, ContenuCommentaire, nbrEtoiles , dateCommentaire , idClient , nomClient) "
                    + "VALUES (?,?,?,?,?,?)";

            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setInt(1, c.getId_livre());
            pst.setString(2, c.getContent());
            pst.setInt(3, c.getStar());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            Date date;
            date = new Date(System.currentTimeMillis());
            pst.setDate(4, date);
            pst.setInt(5, c.getId_client());
            pst.setString(6, c.getNom_client());
            pst.executeUpdate();
            System.out.println("Comment ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean supprimerCom(Comments c) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM commentaire WHERE idCommentaire=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
            System.out.println("Commentaire supprimée");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public List<Comments> listerCom() {
        List<Comments> myList = new ArrayList<Comments>();
        try {
            String requete = "SELECT * FROM commentaire ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Comments p = new Comments();
                p.setId(rs.getInt(1));
                p.setContent(rs.getString(2));
                p.setStar(rs.getInt(3));
                p.setDateCom(rs.getDate(4));
                p.setId_livre(rs.getInt(5));
                p.setId_client(rs.getInt(6));
                p.setNom_client(rs.getString(7));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    
     public void modifierCom(Comments c,int id){
        try {
            String requete = "UPDATE commentaire set contenuCommentaire=?, nbrEtoiles=? WHERE idLivre=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, c.getContent());
            pst.setInt(2, c.getStar());
            pst.setInt(3, id);
            pst.executeUpdate();
            System.out.println("Commentaire Modifié !");
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());      
        }
        
    }

}
