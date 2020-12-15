/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import BookStoreLeago.entities.Client;
import BookStoreLeago.entities.Livre;
import BookStoreLeago.entities.Reclamation;

/**
 *
 * @author Hassen TAHRI
 */
public interface MyListener {
    public void onClickListener(Reclamation reclamation);
    public void onClickListener(Livre livre);
    public void onClickListener(Client client);
    
}
