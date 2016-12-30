
package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLCancelarTiempoController implements Initializable {
    /**
     * Initializes the controller class.
     */           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML 
    private void CancelarBtnAction (ActionEvent e){        
             Contexto.getInstance().CerrarStage(e);
    }
    
    @FXML 
    private void AceptarBtnAction (ActionEvent e){             
             Contexto.getInstance().CerrarStage(e);
             Contexto.getInstance().setCancelandoTiempo(true);
             Contexto.getInstance().getReloj().setTiempo(3);
        
                
    }
    
}
