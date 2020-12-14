package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Security.PAssword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.*;

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

//    public void ajouterClient() {
//
//        try {
//            String requete = "INSERT INTO client (nom,prenom,pseudo,mdp,email,numTel,etatBan) VALUES('Cheour','Zayneb','Freyja','passwordXD','zayneb.cheour@esprit.tn','55368649','false') ";
//            //insertion statique
//            Statement st = cnx.createStatement();
//            st.executeUpdate(requete);
//            System.out.println("Client inséré!");
//            //executeQuery ken f select
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//    }
    public void ajouterClient(Client c) {

        try {
            //String requete = "INSERT INTO personne (nom,prenom) VALUES ('" + p.getNom() + "','" + p.getPrenom() + "')";
            //insertion dynamique  
            String requete = "INSERT INTO client (nom,prenom,pseudo,mdp,email,numTel,photo,etatBan,isAdmin) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
//plus rapide que statement, ts les rq yet5edmou b 2 st w pst juste pst yna99es l charge aal sgbd
//better use st for statique and pst for dynamic
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, c.getPseudo());
            pst.setString(4, c.getMdp());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getNumTel());
            pst.setString(7, c.getPhoto());
            pst.setBoolean(8, c.isEtatBan());
            pst.setBoolean(9, c.isIsAdmin());
            pst.executeUpdate();
            System.out.println("personne insérée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
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

    public boolean chercherUtilisateurByEmail(String s) {
        Client c = null;
        String req = "select * from client where email =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                c = new Client(
                        //						resultSet.getInt("idClient"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("pseudo"),
                        resultSet.getString("mdp"),
                        resultSet.getString("email"),
                        resultSet.getString("numTel"),
                        resultSet.getString("photo"),
                        resultSet.getBoolean("etatBan"),
                        resultSet.getBoolean("isAdmin"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (c == null) {
            return false;
        }
        return true;
    }

    public boolean chercherUtilisateurBylogin(String s) {
        Client c = null;
        String req = "select * from client where pseudo =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                c = new Client(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("pseudo"),
                        resultSet.getString("mdp"),
                        resultSet.getString("email"),
                        resultSet.getString("numTel"),
                        resultSet.getString("photo"),
                        resultSet.getBoolean("etatBan"),
                        resultSet.getBoolean("isAdmin"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (c == null) {
            return false;
        }
        return true;
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Leago BookStore");
            String htmlCode = "welcome to Leago BookStore";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            ex.printStackTrace();
            //Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "legobookstore7@gmail.com";
        //Your gmail password
        String password = "54857754";
        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    public Client chercherUtilisateurByUsername(String s) {
        Client user = null;

        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement("select * from client where pseudo =?");
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new Client(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("pseudo"),
                        resultSet.getString("mdp"),
                        resultSet.getString("email"),
                        resultSet.getString("numTel"),
                        resultSet.getString("photo"),
                        resultSet.getBoolean("etatBan"),
                        resultSet.getBoolean("isAdmin"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return null;
        }
        return user;
    }

    public Boolean verifierpassword(String pword, String uname) {
        String s1 = "";
        String req = "Select mdp from client where pseudo= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, uname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getString(1);
                System.out.println(s1);
                s1 = s1.trim();
                System.out.println(s1);
                // String s2=uname+"{"+s1+"}";

                System.out.println("decrypted pass==>" + PAssword.checkPassword(pword, s1));
                //   System.out.println(uname);
                System.out.println(s1);

                if ((PAssword.checkPassword(pword, s1))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    

    public Boolean Gettype(String s) {
        boolean s1 = false;
        String req = "select isAdmin from client where pseudo =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s1 = resultSet.getBoolean("isAdmin");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s1;
    }
//	public void banClient(Client entity) {
//		String  query = "update client set  etatBan=true where id="+entity.getIdClient()+"; ";
//		try {
//                      Statement st = cnx.prepareStatement(query);
//
//			st.executeUpdate(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//	}
    public Client getuser(Client c) throws SQLException {
        Client us = new Client();
        PreparedStatement pre = cnx.prepareStatement("SELECT * FROM client WHERE pseudo LIKE ? ;");

        pre.setString(1, c.getPseudo());
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int idClient = rs.getInt("idClient");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String pseudo = rs.getString("pseudo");
            String mdp = rs.getString("mdp");
            String email = rs.getString("email");
            String phone = rs.getString("numTel");
            String photo = rs.getString("photo");
            boolean ban =rs.getBoolean("etatBan");
            boolean role = rs.getBoolean("isAdmin");

            us.setIdClient(idClient);
            us.setNom(nom);
            us.setPrenom(prenom);
            us.setNumTel(phone);
            us.setEmail(email);
            us.setMdp(mdp);
            us.setPseudo(pseudo);
            us.setPhoto(photo);
            us.setEtatBan(ban);
            us.setIsAdmin(role);
        }
        return us;

    }

}
