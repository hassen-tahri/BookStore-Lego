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

    public void ajouterLivre(Livre l) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String requete
                = "INSERT INTO livre ( titre ,auteur,langue,catégorie, description,type,prix, "
                + "chemin, dateDepo, taille, imageLivre, duree,nbrPage, idClient)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cnx = ConnexionDB.getInstance().getCnx();
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

    public boolean supprimerLivre(Livre l) {
        Connection cnx = null;
        PreparedStatement pst = null;
        boolean etat = false;
        String requete = "DELETE FROM livre where idLivre=?";

        try {
            cnx = ConnexionDB.getInstance().getCnx();
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

    public void updateLivre(Livre l, int idLivre) {
        Connection cnx = null;
        PreparedStatement pst = null;
        String requete = "UPDATE livre SET description=? , prix=? , imageLivre=? WHERE idLivre=?";
        try {
            cnx = ConnexionDB.getInstance().getCnx();
            pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getDescription());
            pst.setFloat(2, l.getPrix());
            pst.setString(3, l.getImageLivre());
            pst.setInt(4, l.getIdLivre());
            pst.executeUpdate();
            System.out.println("update ok!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
                // we close db connection
                if (pst != null) try {
                        pst.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                if (cnx != null) try {
                        cnx.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
            }
    }

    // update book description
    public void updateLivreDescription(int livreId, String description) {
            Connection cnx = null;
            PreparedStatement pst = null;
            String requete = "UPDATE livre SET description=? WHERE idLivre=?";
            try {
                cnx = ConnexionDB.getInstance().getCnx();
                pst = cnx.prepareStatement(requete);
                pst.setString(1, description);
                pst.setInt(1, livreId);
                pst.executeUpdate();
                System.out.println("livre description updated");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } finally {
                // we close db connection
                if (pst != null) try {
                        pst.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                if (cnx != null) try {
                        cnx.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
            }
            
    }


    // update prix
    public void updateLivrePrix(int livreId, float prix) {
            Connection cnx = null;
            PreparedStatement pst = null;
            String requete = "UPDATE livre SET prix=? WHERE idLivre=?";
            try {
                cnx = ConnexionDB.getInstance().getCnx();
                pst = cnx.prepareStatement(requete);
                pst.setFloat(1, prix);
                pst.setInt(2, livreId);
                pst.executeUpdate();
                System.out.println("livre prix updated");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } finally {
                // we close db connection
                if (pst != null) try {
                        pst.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
                if (cnx != null) try {
                        cnx.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                    }
            }
            
    }
    
    // update livre cover
    public void updateImageLivre(int livreId, String imageLivre) {
            Connection cnx = null;
            PreparedStatement pst = null;
            String requete = "UPDATE livre SET imageLivre=? WHERE idLivre=?";
            try {
                cnx = ConnexionDB.getInstance().getCnx();
                pst = cnx.prepareStatement(requete);
                pst.setString(1, imageLivre);
                pst.setInt(2, livreId);
                pst.executeUpdate();
                System.out.println("livre image updated");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            } finally {
                // we close db connection
                if (pst != null) try {
                        pst.close();
                    } catch (SQLException ex) {
                       System.err.println(ex.getMessage());
                    }
                if (cnx != null) try {
                        cnx.close();
                    } catch (SQLException ex) {
                       System.err.println(ex.getMessage());
                    }
            }
            
    }
    
    
    public List<Livre> getAllLivreByClientId(int id) {
        List<Livre> myList = new ArrayList<Livre>();
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;
        String requete = "SELECT * FROM livre WHERE idClient='" + id + "'";

        try {
            cnx = ConnexionDB.getInstance().getCnx();
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

    public void rechercheLivre(String titre) {
        Connection cnx = null;
        Statement st = null;
        ResultSet rs = null;
        String requete = " Select * FROM livre WHERE titre='" + titre + "'";
        try {
            cnx = ConnexionDB.getInstance().getCnx();
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
