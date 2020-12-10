/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hassen TAHRI
 */
public class Panier {

    private int prixTotal;

    private int idClient;
    private static int idFacture;
    List<Livre> listLivres = new ArrayList();

    public Panier(Client c) {

        this.idClient = c.getIdClient();
    }

    public Panier() {
    }

    public int getPrixTotal() {

        for (int i = 0; i < listLivres.size(); i++) {
            prixTotal += listLivres.get(i).getPrix();
        }
        return prixTotal;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public List<Livre> getListLivres() {
        return listLivres;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public void setListLivres(List<Livre> listLivres) {
        this.listLivres = listLivres;
    }

    public void ajoutreLivreAuPanier(Livre e) {
        listLivres.add(e);
        System.out.println("Livre ajouté au panier!");
    }

    public void supprimerLivreDuPanier(Livre e) {
        listLivres.remove(e);
        System.out.println("Livre supprimé du panier!");
    }

    public void viderPanier() {
        listLivres.clear();
        System.out.println("Panier vidé!");
    }

}
