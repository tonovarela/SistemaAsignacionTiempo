package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import com.SAT.utils.ButtonRenovar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLRenovarTiempoController implements Initializable {
    

    @FXML 
    private ButtonRenovar btn90minutos;
    @FXML 
    private ButtonRenovar btn60minutos;
    @FXML 
    private ButtonRenovar btn30minutos;
    @FXML 
    private ButtonRenovar btn10minutos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
     int tiempoPermitido=20;         
     btn10minutos.SetTiempoPermitido(tiempoPermitido, 10);
     btn30minutos.SetTiempoPermitido(tiempoPermitido, 30);
     btn60minutos.SetTiempoPermitido(tiempoPermitido, 60);
     btn90minutos.SetTiempoPermitido(tiempoPermitido, 90); 
   
       
    }
    
    @FXML
    private void CancelarBtnAction(ActionEvent event) {
        Contexto.getInstance().CerrarStage(event);
    }
    
    
    
}

 
