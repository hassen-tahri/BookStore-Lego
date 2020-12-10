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
public class LivreNumerique extends Livre {

    private String chemin;

    public LivreNumerique(int idLivre, String nom, String description, String auteur, String Langue, String catégorie, float prix) {
        super(idLivre, nom, description, auteur, Langue, catégorie, prix);
    }

    public LivreNumerique() {
    }

}
