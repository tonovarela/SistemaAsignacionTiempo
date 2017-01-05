/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import com.SAT.Model.InfoAsignacion;
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
public class FXMLInfoUsuarioController implements Initializable {

    private Contexto contexto;
    @FXML
    private Label LabelNombreUsuario;
    @FXML
    private Label LabelUsuario;
    @FXML
    private Label LabelMinutosServicio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String minutosServicio;
        contexto = Contexto.getInstance();
        InfoAsignacion infoAsignacion = contexto.getInfoAsignacion();
        minutosServicio = String.format("Te quedan %d minutos de servicio", infoAsignacion.TiempoServicio().getValue());

        LabelUsuario.textProperty().bind(infoAsignacion.Usuario());
        LabelNombreUsuario.textProperty().bind(infoAsignacion.Nombre());
        LabelMinutosServicio.textProperty().set(minutosServicio);

    }

    @FXML
    private void CerrarBtnAction(ActionEvent event) {
        contexto.CerrarStage(event);
    }

}
