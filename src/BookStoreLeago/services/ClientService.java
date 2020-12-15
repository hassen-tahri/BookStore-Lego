package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hassen TAHRI
 */
public class ClientService {

    Connection cnx;

    public ClientService() {
        cnx = MyConnection.getInstance().getCnx();

    }

    public void ajouterClient() {

        try {
            String requete = "INSERT INTO client (nom,prenom,pseudo,mdp,email,numTel,etatBan) VALUES('Cheour','Zayneb','Freyja','passwordXD','zayneb.cheour@esprit.tn','55368649','false') ";
            //insertion statique
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Client inséré!");
            //executeQuery ken f select
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void ajouterClient(Client c) {

        try {
            //String requete = "INSERT INTO personne (nom,prenom) VALUES ('" + p.getNom() + "','" + p.getPrenom() + "')";
            //insertion dynamique  
            String requete = "INSERT INTO personne (nom,prenom,pseudo,mdp,email,numTel,etatBan) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
//plus rapide que statement, ts les rq yet5edmou b 2 st w pst juste pst yna99es l charge aal sgbd
//better use st for statique and pst for dynamic
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, c.getPseudo());
            pst.setString(4, c.getMdp());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getNumTel());
            pst.setBoolean(7, c.isEtatBan());
            pst.executeUpdate();
            System.out.println("personne insérée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Client> listerClients() {
        List<Client> myList = new ArrayList<Client>();
        try {
            String requete = "SELECT * FROM client";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Client c = new Client();
                // (nom,prenom,pseudo,mdp,email,numTel,etatBan)
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString(2));
                c.setPseudo(rs.getString(3));
                c.setMdp(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setNumTel(rs.getString(6));
                c.setEtatBan(rs.getBoolean(7));
                myList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

    public boolean supprimerClient(Client c) {
        boolean etat;
        try {
            String requete = "DELETE FROM client where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getIdClient());
            pst.executeUpdate();
            System.out.println("Client deleted");
            etat = true;
        } catch (SQLException ex) {
            etat = false;
            System.out.println(ex.getMessage());
        }
        return etat;
    }

//    public void updateClietNom(Client c, String nom){
//        try {
//            String requete ="UPDATE client set nom=?,prenom=? WHERE id=?";
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            pst.setString(1, c.getNom());
//            pst.setString(2, c.getPrenom());
//            pst.setInt(3, id);
//            pst.executeUpdate();
//            System.out.println("table updated");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());        }
//    
//    }
    // TODO Auto-generated method stub
    
    public void update(Client entity) {
    try {
            //(nom,prenom,pseudo,mdp,email,numTel,photo,etatBan,isAdmin)
//String query = "update client set  'nom'='" + entity.getNom() +
//        "' ,'prenom'='" + entity.getPrenom() + "', 'pseudo'='" + 
//        entity.getPseudo() + "' "
//        + "','mdp'=' " + entity.getMdp() + "' , email=' " + entity.getEmail() +
//        ",' numTel='" + entity.getNumTel() + "'" + "',photo=" + entity.getPhoto()
//        + "',etatBan='" + entity.isEtatBan() + "' ,isAdmin='" + false + "' where id = " 
//        + entity.getIdClient() + ";";

{String query ="UPDATE client set nom=?,prenom=?,pseudo=?,mdp=?,email=?,numTel=?,photo=?,etatBan=?,isAdmin=? WHERE idClient=?";           
   PreparedStatement pst = cnx.prepareStatement(query);
            pst.setString(1, entity.getNom());
            pst.setString(2, entity.getPrenom());
            pst.setString(3, entity.getPseudo());
            pst.setString(4, entity.getMdp());
            pst.setString(5, entity.getEmail());
            pst.setString(6, entity.getNumTel());
            pst.setString(7, entity.getPhoto());
            pst.setBoolean(8, entity.isEtatBan());
            pst.setBoolean(9, false);
            pst.setInt(10, entity.getIdClient());
        
            pst.executeUpdate();
            System.out.println("table updated");
//                Statement st = cnx.createStatement();
//                st.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO Auto-generated method stub
    }

        
}
