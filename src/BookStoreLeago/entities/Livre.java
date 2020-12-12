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
public class Livre {

    protected int idLivre;
    protected String nom, description, auteur, langue, catégorie;
    protected float prix;
//    private CLOB couverture;

    public Livre(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }
    

    public Livre(int idLivre, String nom, String description, String auteur, String langue, String catégorie, float prix) {
        this.idLivre = idLivre;
        this.nom = nom;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.prix = prix;
    }

    public Livre() {
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Livre{" + "idLivre=" + idLivre + ", nom=" + nom + ", description=" + description + ", auteur=" + auteur + ", Langue=" + langue + ", cat\u00e9gorie=" + catégorie + ", prix=" + prix + '}';
    }

}
