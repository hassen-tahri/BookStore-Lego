/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.entities.Panier;
import ds.desktop.notify.DesktopNotify;
import java.awt.Desktop;
import java.sql.Connection;
    import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoUnit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.DAYS;

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

    public boolean supprimerLivreDuPanier(int c, Livre l) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM panier WHERE idClient=? and idLivre=?";
            PreparedStatement pst = cnx
                    .prepareStatement(requete);
            pst.setInt(1, c);
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
            String requete = "INSERT INTO panier (idclient,idlivre,dateAjout)"
                    + "values (?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            pst.setInt(1, c.getIdClient());
            pst.setInt(2, l.getIdLivre());
            pst.setDate(3, date);

            pst.executeUpdate();
            System.out.println("Livre ajouté au panier!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Livre> getPanier(Client c) {
        List<Livre> myList = new ArrayList<Livre>();
        try {
            String requete = "select livre.titre, livre.prix, livre.idLivre, panier.dateAjout from livre join panier on panier.idLivre=livre.idLivre where panier.idClient = " + c.getIdClient();

            Statement st = cnx
                    .createStatement();

            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                String titre = (rs.getString(1));
                Float prix = (rs.getFloat(2));
                int id = (rs.getInt(3));
               
                DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
                String dateAjout = dateFormat.format(rs.getDate(4));
                
                Livre l = new Livre(titre, prix, id, dateAjout);
                myList.add(l);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(myList);
        return myList;
    }

    public void getPanierDates(int id)
    {
        try {
            String requete = "select dateAjout from panier where idClient ="+id;
            // String requetePrixT = "select sum(prix) from panier where idClient = "+c.getIdClient();

            Statement st = cnx
                    .createStatement();

            ResultSet rs = st.executeQuery(requete);
            java.util.Date currDate = new java.util.Date();
            boolean notify = false;
            while (rs.next() && !notify) {
            java.util.Date dateAjout = new java.util.Date(rs.getDate(1).getTime());
            long diff = currDate.getTime() - dateAjout.getTime();
            long result = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (result >= 2)
                ds.desktop.notify.DesktopNotify.showDesktopMessage(
                        "LEGO Bookstore",
                        "You added books to your cart a while ago but you haven't bought them yet!",
                        DesktopNotify.WARNING );
                        break;
                }

            }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }


}
