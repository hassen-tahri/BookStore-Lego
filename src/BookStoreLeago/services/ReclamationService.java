/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassen TAHRI
 */
public class ReclamationService {

    Connection cnx;

    public ReclamationService() {
        cnx = MyConnection.getInstance().getCnx();
    }

//    public void ajoutReclamation(Reclamation R) {
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat formattter = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            String requete = "INSERT INTO reclamation(contenuReclamation,dateReclamation,idClient) " + "VALUES ('" + R.getContenuReclamation() + "','" + date + "','" + R.getIdClient() + "')";
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.executeUpdate();
//            System.out.println("Reclamation ajoutée!");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    public void ajoutReclamation(Reclamation R) {
        Date date = new Date(System.currentTimeMillis());
        try {
            String requete = "INSERT INTO reclamation(contenuReclamation,dateReclamation,etatReclam,archive,idClient)" + "VALUE(?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, R.getContenuReclamation());
            pst.setDate(2, date);
            pst.setBoolean(3, false);
            pst.setString(4, "false");
            pst.setInt(5, R.getIdClient());
            pst.executeUpdate();
            System.out.println("reclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modifierReclamation(Reclamation R, int id) {
        try {
            String requete = "UPDATE reclamation set contenuReclamation='" + R.getContenuReclamation() + "',dateReclamation='" + R.getDateReclamation() + "',etatReclam='" + R.getEtatReclam() + "',archive='" + R.getArchive() + "',idClient='" + R.getIdClient() + "'" + "where id ='" + id + "'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.executeUpdate();
            System.out.println("reclamation modifieé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean supprimerReclamation(Reclamation R) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM reclamation WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, R.getIdReclamation());
            pst.executeUpdate();
            System.out.println("reclamation supprimée");
            etat = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public boolean supprimerReclamation(int id) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM reclamation WHERE idReclamation='" + id + "'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.executeUpdate();
            System.out.println("reclamation supprimée");
            etat = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public Reclamation getReclamationById(int id) {
        Reclamation reclam = new Reclamation();
        try {
            String requete = "SELECT * FROM reclamation WHERE idReclamation='" + id + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                reclam.setIdReclamation(rs.getInt(1));
                reclam.setContenuReclamation(rs.getString("contenuReclamation"));
                reclam.setDateReclamation(rs.getDate("dateReclamation"));
                reclam.setEtatReclam(rs.getBoolean("etatReclam"));
                reclam.setArchive(rs.getString("archive"));
                reclam.setIdClient(rs.getInt("idClient"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclam;
    }

    public List<Reclamation> getReclamationByIdClient(int id) {
        List<Reclamation> myList = new ArrayList<Reclamation>();
        try {
            String requete = "SELECT * FROM reclamation WHERE idClient='" + id + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation reclam = new Reclamation();
                reclam.setIdReclamation(rs.getInt(1));
                reclam.setContenuReclamation(rs.getString("contenuReclamation"));
                reclam.setDateReclamation(rs.getDate("dateReclamation"));
                reclam.setEtatReclam(rs.getBoolean("etatReclam"));
                reclam.setArchive(rs.getString("archive"));
                reclam.setIdClient(rs.getInt("idClient"));
                myList.add(reclam);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }

    public List<Reclamation> getAllReclamation() {
        List<Reclamation> myList = new ArrayList<Reclamation>();
        try {
            String requete = "SELECT * FROM reclamation";
            Statement st = cnx
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation reclam = new Reclamation();
                reclam.setIdReclamation(rs.getInt(1));
                reclam.setContenuReclamation(rs.getString("contenuReclamation"));
                reclam.setDateReclamation(rs.getDate("dateReclamation"));
                reclam.setIdClient(rs.getInt("idClient"));
                reclam.setEtatReclam(rs.getBoolean("etatReclam"));
                reclam.setArchive(rs.getString("archive"));

                myList.add(reclam);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

}
