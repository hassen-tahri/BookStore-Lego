/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hassen TAHRI
 */
public class MyConnection {
     public String url="jdbc:mysql://localhost:3306/bookstore";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnection instance;

    MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    public Connection getCnx(){
        return cnx;
    }

    public static MyConnection getInstance() {
        if(instance == null)
        {instance = new MyConnection();}
        return instance;
    }
    
    
}
