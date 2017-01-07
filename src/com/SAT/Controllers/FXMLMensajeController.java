/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author tonovarela
 */
public class FXMLMensajeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label LblMensaje;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LblMensaje.textProperty().setValue(Contexto.getInstance().getAzureServiceBusClient().getUltimoMensaje());
    }

    @FXML
    private void CerrarBtnAction(ActionEvent event) throws IOException {
        Contexto.getInstance().CerrarStage(event);
    }

}
