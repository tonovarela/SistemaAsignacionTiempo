package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLCancelarTiempoController implements Initializable {

    private Contexto contexto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contexto = Contexto.getInstance();
        contexto.setCancelandoTiempo(true);
    }

    @FXML
    private void CancelarBtnAction(ActionEvent e) {
        contexto.setCancelandoTiempo(false);
        Contexto.getInstance().CerrarStage(e);
    }

    @FXML
    private void AceptarBtnAction(ActionEvent e) {        
        Contexto.getInstance().CerrarStage(e);
        Contexto.getInstance().getReloj().setTiempo(3);

    }

}
