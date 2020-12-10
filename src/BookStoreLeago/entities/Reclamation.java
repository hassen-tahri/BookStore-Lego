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
public class Reclamation {

    private int idReclamation;
    private String contenuReclamation;
    private Date dateReclamation;
    private int idClient;

    public Reclamation(String contenuReclamation, int idClient) {
        this.contenuReclamation = contenuReclamation;
        this.idClient = idClient;
    }

    public Reclamation(int idReclamation, String contenuReclamation, Date dateReclamation, int idClient) {
        this.idReclamation = idReclamation;
        this.contenuReclamation = contenuReclamation;
        this.dateReclamation = dateReclamation;
        this.idClient = idClient;
    }

    public Reclamation(int idReclamation, String contenuReclamation, Date dateReclamation) {
        this.idReclamation = idReclamation;
        this.contenuReclamation = contenuReclamation;
        this.dateReclamation = dateReclamation;
    }

    public Reclamation(String contenuReclamation, Date dateReclamation, int idClient) {
        this.contenuReclamation = contenuReclamation;
        this.dateReclamation = dateReclamation;
        this.idClient = idClient;
    }

    public Reclamation() {
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getContenuReclamation() {
        return contenuReclamation;
    }

    public void setContenuReclamation(String contenuReclamation) {
        this.contenuReclamation = contenuReclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idReclamation=" + idReclamation + ", contenuReclamation=" + contenuReclamation + ", dateReclamation=" + dateReclamation + ", idClient=" + idClient + '}';
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

}
