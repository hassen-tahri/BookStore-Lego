/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testprojet.controlleur;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class Helpers {
    
    
    
    public static int getInputAsInt(TextField inputField) {
        if(!inputField.getText().isEmpty()) {
            return Integer.parseInt(inputField.getText());
        }
        else {
            return 0;
        }
    }
}
