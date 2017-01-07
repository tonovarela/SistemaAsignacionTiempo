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
    
    
    private Contexto contexto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
     contexto=Contexto.getInstance();
     contexto.setRenovandoTiempo(true);
     

     int tiempoPermitido=contexto.getInfoAsignacion().getMaxRenovacionPermitido();
                  
          
     btn10minutos.SetTiempoMaximoServicio(tiempoPermitido, 10);
     btn30minutos.SetTiempoMaximoServicio(tiempoPermitido, 30);
     btn60minutos.SetTiempoMaximoServicio(tiempoPermitido, 60);
     btn90minutos.SetTiempoMaximoServicio(tiempoPermitido, 90); 
   
       
    }
    
    @FXML
    private void CancelarBtnAction(ActionEvent event) {
        contexto.setRenovandoTiempo(false);
        contexto.CerrarStage(event);             
    }
    
    
    
}

 
