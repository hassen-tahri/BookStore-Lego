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
public class LivreAudio extends Livre {

    private float durée;
//    private CLOB audio;

    public LivreAudio(int idLivre, String nom, String description, String auteur, String Langue, String catégorie, float prix, float durée) {
        super(idLivre, nom, description, auteur, Langue, catégorie, prix);
        this.durée = durée;
    }

}
