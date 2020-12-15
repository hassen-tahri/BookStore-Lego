/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.entities;

/**
 *
 * @author Hassen TAHRI
 */
public class DetailStat {
    private String mois;
    private int nbr;

    public DetailStat(String mois, int nbr) {
        this.mois = mois;
        this.nbr = nbr;
    }

    public DetailStat() {

    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
    
    
    
}
