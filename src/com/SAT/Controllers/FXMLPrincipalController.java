
package com.SAT.Controllers;

import com.SAT.Clases.Reloj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author tonovarela
 */
public class FXMLPrincipalController implements Initializable {
    
    @FXML
    private Label label;
    
    private Reloj reloj;
          
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
      
        System.out.println("You clicked me!");
        reloj.detenerReloj();
   
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reloj= new Reloj(150);          
        label.textProperty().bind(reloj.TiempoLabel);
        reloj.iniciarReloj();
      
        
        
        
    }    
    
}
