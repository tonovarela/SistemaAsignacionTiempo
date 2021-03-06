package com.SAT.Controllers;

import com.SAT.Clases.Centinela;
import com.SAT.Clases.Contexto;
import com.SAT.Clases.Reloj;
import com.SAT.utils.GaugeControl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesign.MaterialDesignIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class FXMLPrincipalController implements Initializable {

    
    @FXML
    private MaterialDesignIcon StatusNet;
    @FXML
    private GaugeControl gauge;
    @FXML
    private Label label;
    @FXML
    private FontAwesomeIcon iconOS;
    
    
    private Stage _stageCancelarTiempo;

    @FXML
    private void CancelarBtnAction(ActionEvent event) {

        if (!_stageCancelarTiempo.isShowing() && !Contexto.getInstance().isCancelandoTiempo()) {
            _stageCancelarTiempo.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Contexto contexto = Contexto.getInstance();

        _stageCancelarTiempo = contexto.getStageCancelarTiempo();
        Reloj reloj = contexto.getReloj();
        Centinela centinela = contexto.getCentinela();
        
        reloj.setTiempo(12000);
        iconOS.setGlyphName(contexto.GetOSIconName());
      
        gauge.LabelProperty().bind(reloj.TiempoLabel);
        gauge.ValueProperty().bind(reloj.TiempoRestantePorcentaje);
        label.textProperty().bind(reloj.TiempoLabel);
      
        

        Timeline _timeline;
        _timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), (ActionEvent e) -> {

                    if (centinela.estaConectado()) {
                        StatusNet.setGlyphName("ETHERNET_CABLE");
                        StatusNet.setFill(Color.BLACK);                        
                        if (reloj.getTiempoRestante() == 30 && !_stageCancelarTiempo.isShowing()) {
                            contexto.getStageRenovarTiempo().show();
                        }

                    } else {
                        StatusNet.setGlyphName("ETHERNET_CABLE_OFF");
                        StatusNet.setFill(Color.RED);                        
                    }
                    if (reloj.getTiempoRestante() == 0) {                       
                        contexto.CerrarSesion();
                        Platform.exit();
                        System.exit(0);
                    }
                    System.out.println("Se monitorea el ServiceBusChat");

                })
        );
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();

    }

}
