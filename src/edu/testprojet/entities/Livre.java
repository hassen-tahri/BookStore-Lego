/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testprojet.entities;


import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;



public class Livre {
     protected int idLivre, idClient, nbrPage;
    protected String titre, description, auteur, langue, catégorie, chemin, duree, type;
    protected float prix, taille;
    protected String imageLivre;
    protected Date dateDepo;
    
    public  Livre(String titre,String description) {
        this.titre = titre;
        this.description = description;
    }
    
    public Livre(
            int idLivre,
            int idClient,
            int nbrPage,
            String titre,
            String description,
            String auteur,
            String langue,
            String catégorie,
            String chemin,
            String type,
            float prix,
            float taille,
            String imageLivre,
            Date dateDepo) {
        this.idLivre = idLivre;
        this.idClient = idClient;
        this.nbrPage = nbrPage;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.chemin = chemin;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.imageLivre = imageLivre;
        this.dateDepo = dateDepo;
    }

    public Livre(
            int idLivre,
            int idClient,
            int nbrPage,
            String titre,
            String description,
            String auteur,
            String langue,
            String catégorie,
            String chemin,
            String duree,
            String type,
            float prix,
            float taille,
            String imageLivre,
            Date dateDepo) {
        this.idLivre = idLivre;
        this.idClient = idClient;
        this.nbrPage = nbrPage;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.chemin = chemin;
        this.duree = duree;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.imageLivre = imageLivre;
        this.dateDepo = dateDepo;
    }
     public Livre(String titre ,String auteur, String langue, String catégorie, String description, String type, float prix, String chemin, float taille,String imageLivre, String  duree, int nbrPage, int idClient){
     
     this.idClient = idClient;
        this.nbrPage = nbrPage;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.chemin = chemin;
        this.duree = duree;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.imageLivre = imageLivre;     
     }

    public Livre() {
    }

    public Livre( String titre, String auteur, String langue, String catégorie, String description,String type,float prix,String chemin,float taille, String imageLivre, int nbrPage,  int idClient ) {
        
        this.nbrPage = nbrPage;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.chemin = chemin;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.imageLivre = imageLivre;
        this.idClient=idClient;
      
    }

    public Livre(String description, float prix, String imageLivre) {
        this.description = description;
        this.prix = prix;
        this.imageLivre = imageLivre;
    }
   
     
    public Livre( String titre, String auteur, String langue, String catégorie, String description,String type,float prix,String chemin,float taille, String imageLivre, String duree , int idClient ) {
        
        this.duree = duree;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.langue = langue;
        this.catégorie = catégorie;
        this.chemin = chemin;
        this.type = type;
        this.prix = prix;
        this.taille = taille;
        this.imageLivre = imageLivre;
        this.idClient=idClient;
      
    }
   
  

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public String getImageLivre() {
        return imageLivre;
    }

    public void setImageLivre(String imageLivre) {
        this.imageLivre = imageLivre;
    }

    public Date getDateDepo() {
        return dateDepo;
    }

    public void setDateDepo(Date dateDepo) {
        this.dateDepo = dateDepo;
    }

    @Override
    public String toString() {
        return "Livre{" + "idLivre=" + idLivre + ", idClient=" + idClient + ", titre=" + titre + ", description=" + description + ", auteur=" + auteur + ", langue=" + langue + ", cat\u00e9gorie=" + catégorie + ", chemin=" + chemin + ", duree=" + duree + ", type=" + type + ", prix=" + prix + ", taille=" + taille + ", imageLivre=" + imageLivre + ", dateDepo=" + dateDepo + '}';
    }

}
   
    
    

