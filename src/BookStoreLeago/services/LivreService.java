/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.DetailStat;
import BookStoreLeago.entities.Livre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassen TAHRI
 */
public class LivreService {

    Connection cnx;

    public LivreService() {
        cnx = MyConnection.getInstance().getCnx();
    }
//ajout livre
   public void ajouterLivre(Livre l) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String requete
                = "INSERT INTO livre ( titre ,auteur,langue,catégorie, description,type,prix, "
                + "chemin, dateDepo, taille, imageLivre, duree,nbrPage, idClient)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cnx = MyConnection.getInstance().getCnx();
            pst = cnx.prepareStatement(requete);

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
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }
    }

    

    public List<DetailStat> getNbrLivresByMonth() {
        List<DetailStat> myList = new ArrayList<DetailStat>();
        DetailStat detail1 = new DetailStat("janvier", 0);
        DetailStat detail2 = new DetailStat("février", 0);
        DetailStat detail3 = new DetailStat("mars", 0);
        DetailStat detail4 = new DetailStat("avril", 0);
        DetailStat detail5 = new DetailStat("mai", 0);
        DetailStat detail6 = new DetailStat("juin", 0);
        DetailStat detail7 = new DetailStat("juillet", 0);
        DetailStat detail8 = new DetailStat("août", 0);
        DetailStat detail9 = new DetailStat("septembre", 0);
        DetailStat detail10 = new DetailStat("octobre", 0);
        DetailStat detail11 = new DetailStat("novembre", 0);
        DetailStat detail12 = new DetailStat("décembre", 0);
        myList.add(detail1);
        myList.add(detail2);
        myList.add(detail3);
        myList.add(detail4);
        myList.add(detail5);
        myList.add(detail6);
        myList.add(detail7);
        myList.add(detail8);
        myList.add(detail9);
        myList.add(detail10);
        myList.add(detail11);
        myList.add(detail12);
        try {

            String requete = "SELECT extract(month FROM dateDepo), COUNT(*) FROM livre GROUP BY extract(month FROM dateDepo)";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                DetailStat detail = new DetailStat();
                int indexMonth = rs.getInt(1);
                switch (indexMonth) {
                    case 1:
                        detail.setMois("janvier");
                        break;
                    case 2:
                        detail.setMois("février");
                        break;
                    case 3:
                        detail.setMois("mars");
                        break;
                    case 4:
                        detail.setMois("avril");
                        break;
                    case 5:
                        detail.setMois("mai");
                        break;
                    case 6:
                        detail.setMois("juin");
                        break;
                    case 7:
                        detail.setMois("juillet");
                        break;
                    case 8:
                        detail.setMois("août");
                        break;
                    case 9:
                        detail.setMois("septembre");
                        break;
                    case 10:
                        detail.setMois("octobre");
                        break;
                    case 11:
                        detail.setMois("novembre");
                        break;
                    case 12:
                        detail.setMois("décembre");
                        break;
                    default:
                }
                detail.setNbr(rs.getInt(2));
                for(int i = 0 ; i < myList.size(); i++)
                {if(myList.get(i).getMois()==detail.getMois())
                    myList.set(i, detail);
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }

    //listerlivre
    public List<Livre> listerLivre() {
        List<Livre> myList = new ArrayList<Livre>();
        Connection cnx = null;
        Statement st = null;

        try {
            String requete = "SELECT * FROM livre";
            st = cnx.createStatement();
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

    
    //supp livre 
     public boolean supprimerLivre(Livre l) {
        Connection cnx = null;
        PreparedStatement pst = null;
        boolean etat = false;
        String requete = "DELETE FROM livre where idLivre=?";

        try {
            cnx = MyConnection.getInstance().getCnx();
            pst = cnx.prepareStatement(requete);
            pst.setInt(1, l.getIdLivre());
            pst.executeUpdate();
            System.out.println("Livre supprimé ! ");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    ; // ignore it
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (Exception e) {
                    ; // ...
                }
            }
        }
        return etat;
    }
     
     
     //update livre
     public void updateLivre(Livre l, int idLivre) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String requete = "UPDATE livre SET description=? , prix=? , imageLivre=? , WHERE idLivre=?";
        try {
            cnx = MyConnection.getInstance().getCnx();
            pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getDescription());
            pst.setFloat(2, l.getPrix());
            pst.setString(11, l.getImageLivre());
            pst.setInt(1, l.getIdLivre());
            pst.executeUpdate();
            System.out.println("update ok!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

     
     //listerlivre
     public List<Livre> getAllLivreByClientId(int id) {
        List<Livre> myList = new ArrayList<Livre>();
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM livre WHERE idClient='" + id + "'";

        try {
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();
            rs = st.executeQuery(requete);
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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    ;// ignore it
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    ; // ...
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (Exception e) {
                    ; // ...
                }
            }
        }
        return myList;
    }
     
     
     //rechercher
      public void rechercheLivre(String titre) {
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;
        String requete = " Select * FROM livre WHERE titre='" + titre + "'";
        try {
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();

            rs = st.executeQuery(requete);
            rs.last(); // move cursor to the first row in the Result Set
            int nbrRow = rs.getRow();
            if (nbrRow >= 1) {
                System.out.println("livre trouvé!");
                // ,String chemin,float taille, String imageLivre, String duree , int idClient ) {

                Livre livre = new Livre(
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("langue"),
                        rs.getString("catégorie"),
                        rs.getString("description"),
                        rs.getString("type"),
                        rs.getFloat("prix"),
                        rs.getString("chemin"),
                        rs.getFloat("taille"),
                        rs.getString("imageLivre"),
                        rs.getString("nbrPage"),
                        rs.getInt("idClient")
                );
                livre.setDuree(rs.getString("duree"));
                livre.setIdClient(rs.getInt("IdClient"));
                livre.setDateDepo(rs.getDate("dateDepo"));
                System.out.println(livre.toString());
            } else {
                System.out.println("livre non trouvé!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ;// ignore it
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    ; // ...
                }
            }
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException e) {
                    ; // ...
                }
            }
        }

    }

    
    
    
    
}
