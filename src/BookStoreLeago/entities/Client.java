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
public class Client {

        private int idClient;
    private String nom, prenom, pseudo, mdp, email, numTel, photo;
    private List<Integer> followers = new ArrayList();
    private boolean etatBan, isAdmin;

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

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

    public Client(int idClient, String nom, String prenom, String pseudo, String mdp, String email, String numTel, String photo, boolean etatBan) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.photo = photo;
        this.etatBan = etatBan; //default false
    }

    public Client(int idClient, String nom, String prenom, String pseudo, String mdp, String email, String numTel, String photo, boolean etatBan, boolean isAdmin) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.photo = photo;
        this.etatBan = etatBan;
        this.isAdmin = isAdmin;
    }

    public Client(String nom, String prenom, String pseudo, String mdp, String email, String numTel, String photo, boolean etatBan, boolean isAdmin) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.photo = photo;
        this.etatBan = etatBan;
        this.isAdmin = isAdmin;
    }

    public Client(String nom, String prenom, String pseudo, String mdp, String email, String numTel, String photo, boolean etatBan) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.photo = photo;
        this.etatBan = etatBan;

    }

    public Client(int idClient, String nom, String prenom, String pseudo, String mdp, String email, String numTel, String photo, boolean etatBan, boolean isAdmin, ArrayList<Integer> followers) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.numTel = numTel;
        this.photo = photo;
        this.etatBan = etatBan;
        this.isAdmin = isAdmin;
        followers= new ArrayList();
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", email=" + email + ", numTel=" + numTel + ", photo=" + photo + ", etatBan=" + etatBan + ", isAdmin=" + isAdmin + '}';
    }
}
