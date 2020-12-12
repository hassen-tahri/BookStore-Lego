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
public class Client {

    private int idClient;
    private String nom, prenom, pseudo, mdp, email, numTel;
    private boolean etatBan;

    public Client(int i) {
    idClient = i;    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public boolean isEtatBan() {
        return etatBan;
    }

    public void setEtatBan(boolean etatBan) {
        this.etatBan = etatBan;
    }

    public Client(int idClient, String nom, String prenom, String pseudo, String mdp, String email, String numTel, boolean etatBan) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.etatBan = etatBan;
    }

    public Client(String nom, String prenom, String pseudo, String mdp, String email, String numTel, boolean etatBan) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.etatBan = etatBan;
    }

    public Client() {
    }
}
