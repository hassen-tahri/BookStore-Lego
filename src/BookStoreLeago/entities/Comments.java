/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.entities;

import java.sql.Date;

/**
 *
 * @author Hassen TAHRI
 */
public class Comments {

    private int id;
    private int id_livre;
    private String content;
    private int star;
    private int id_client;
    private String nom_client;
    private Date dateCom;

    public Comments(int id, String content, int star, int id_livre, int id_client, String nom_client) {
        this.id = id;
        this.content = content;
        this.star = star;
        this.id_livre = id_livre;
        this.id_client = id_client;
        this.nom_client = nom_client;
    }

    public Comments() {
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public int getId() {
        return id;
    }

    public int getId_livre() {
        return id_livre;
    }

    public String getContent() {
        return content;
    }

    public int getStar() {
        return star;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Comments{" + "id=" + id + ", id_livre=" + id_livre + ", content=" + content + ", star=" + star + ", id_client=" + id_client + ", nom_client=" + nom_client + ", dateCom=" + dateCom + '}';
    }

}
