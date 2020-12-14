/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.services.MyConnection;
import BookStoreLeago.services.PanierService;
import java.util.List;
import ds.desktop.notify.DesktopNotify;


/**
 *
 * @author Luoa
 */
public class test {
    public static void main(String[] args) {
        
        MyConnection mc = MyConnection.getInstance();

     
     Livre l = new Livre(1, "a", "b", "a", "a", "a", 25.2f);
     Livre l1 = new Livre(24, "a", "b", "a", "a", "a", 25.2f);
     Client c = new Client(2, "a", "a", "a", "a", "a", "a", true);
     

     
     PanierService ps = new PanierService();
     
//   ps.ajouterLivreAuPanier(c, l);
//   ps.ajouterLivreAuPanier(c, l1);
      //  System.out.println("ajout");

      
//      ps.getPanier(3);
//ps.supprimerLivreDuPanier(2, l);

   
    
    List<Livre> myList = ps.getPanier(c);
        System.out.println(myList);
      }
}
