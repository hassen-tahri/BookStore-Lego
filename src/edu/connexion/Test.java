/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion;

import edu.testprojet.entities.Livre;
import edu.testprojet.service.LivreCRUD;

/**
 *
 * @author DELL
 */
public class Test {

    public static void main(String[] args) {

        ConnexionDB cnx = ConnexionDB.getInstance();
      Livre l = new Livre ("titre" ,"auteur","langue","catégorie", "description","type",10f, "chemin", 5.3f, "imageLivre", "duree",201, 10);
      Livre lp = new Livre ("Votre cerveau, comment le chouchouter" ,"Michel Cymes","Français","Etre et penser", "Cette prise de conscience peut s'opérer quels que soient votre âge et votre état de santé.","PDF",21.28f,
              "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book", 19f, "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book\\image",246,4);
      Livre lp1 = new Livre ("Le Bruit De La Soie" ,"Sonia Velton","Français","Romans", "itôt descendue de la diligence, Sarah, naïve campagnarde venue trouver du travail à Londres, se laisse embarquer par une mère maquerelle bien décidée à exploiter son joli minois. Esther, riche et pieuse femme de soyeux,...","PDF",20.00f,
              "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book", 19f, "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book\\image",350,8);
    
      Livre la = new Livre ("Tu seras un raté mon fils" ,"Frédéric Ferney","Français","Histoire", "’auteur répond à partir du cas de Winston Churchill, en explorant sa relation avec son père,","Audio",19.95f,
              "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book", 20f, "C:\\Users\\DELL\\Desktop\\ESPRIT\\bookstore\\book\\image","50.6 minutes",5);
    
      
   LivreCRUD lv = new LivreCRUD();
  // lv.ajouterLivre(l);
 //lv.ajouterLivre(lp);
 //lv.ajouterLivre(la);
 //lv.ajouterLivre(lp1);
//System.out.println( lv.getAllLivreByClientId(8));
        //lv.supprimerLivre(lp1);
       // System.out.println(lv.listerLivre());
//lv.updateLivre(l, 13)
//lv.supprimerLivre(l);
lv.rechercheLivre("La ferme des animaux");

    }

}
