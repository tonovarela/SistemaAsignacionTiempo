package com.SAT.Controllers;

import com.SAT.Clases.Contexto;
import com.SAT.utils.ConverterStringTiempo;
import com.SAT.Model.TiempoARenovar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class FXMLRenovarTiempoController implements Initializable {
    
    @FXML
    private ComboBox<TiempoARenovar> combo;
    @FXML
    private Button ButtonAceptar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<TiempoARenovar> _tiempos = FXCollections.observableArrayList();
        _tiempos.add(new TiempoARenovar(30));
        _tiempos.add(new TiempoARenovar(60));
        _tiempos.add(new TiempoARenovar(90));
        combo.getItems().addAll(_tiempos);
        combo.setConverter(new ConverterStringTiempo());
        
    }
    
    @FXML
    private void CancelarBtnAction(ActionEvent event) {
        Contexto.getInstance().CerrarStage(event);
    }
    
    @FXML
    private void AgregarTiempoBtnAction(ActionEvent event) {
        int tiempoAgregar = combo.getValue().getTiempo();
        Contexto.getInstance().getReloj().setTiempo(tiempoAgregar);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void HabilitarBtnAgregarTiempo(ActionEvent event) {
       ButtonAceptar.setDisable(false);
    }
    
}
