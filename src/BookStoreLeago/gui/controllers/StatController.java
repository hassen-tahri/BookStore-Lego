/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreLeago.gui.controllers;

import BookStoreLeago.entities.DetailStat;
import BookStoreLeago.services.LivreService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Hassen TAHRI
 */
public class StatController implements Initializable {

    @FXML
    private NumberAxis livres;
    @FXML
    private CategoryAxis mois;
    @FXML
    private BarChart<?, ?> livresChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();
        LivreService service = new LivreService();
        List<DetailStat> myList = new ArrayList<>();
        myList = service.getNbrLivresByMonth();
        for(int i =0 ; i<myList.size() ; i++)
        {
        set1.getData().add(new XYChart.Data(myList.get(i).getMois(),myList.get(i).getNbr()));
        }
        livresChart.getData().addAll(set1);
        
    }    
    
}
