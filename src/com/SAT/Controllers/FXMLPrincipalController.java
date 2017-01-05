package com.SAT.Controllers;

import com.SAT.Clases.Centinela;
import com.SAT.Clases.Contexto;
import com.SAT.Clases.Reloj;
import com.SAT.Model.InfoAsignacion;
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
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class FXMLPrincipalController implements Initializable {

    private Contexto contexto;

    @FXML
    private MaterialDesignIcon statusNet;
    @FXML
    private FontAwesomeIcon iconOS;
    @FXML
    private GaugeControl gauge;
    @FXML
    private Label lblLugarEquipo;
//    @FXML
//    private Label lblTiempo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contexto = Contexto.getInstance();

        Reloj reloj = contexto.getReloj();
        InfoAsignacion infoAsignacion = contexto.getInfoAsignacion();

        reloj.setTiempo(infoAsignacion.TiempoAsignado().getValue());

        Centinela centinela = contexto.getCentinela();

        /*Bindings------------------------------------ */
        iconOS.setGlyphName(contexto.GetOSIconName());
        lblLugarEquipo.textProperty().bind(infoAsignacion.LugarEquipoAsignado());
//        lblTiempo.textProperty().bind(reloj.TiempoLabel);
        gauge.LabelProperty().bind(reloj.TiempoLabel);
        gauge.ValueProperty().bind(reloj.TiempoRestantePorcentaje);
        /*------------------------------------ */

        Timeline _timeline;
        _timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), (ActionEvent e) -> {
                    if (centinela.estaConectado()) {
                        statusNet.setGlyphName("WIFI");
                        statusNet.setFill(Color.BLACK);
                        if (reloj.getTiempoRestante() == 30 && !contexto.isCancelandoTiempo()) {

                            if (!(infoAsignacion.TiempoMaximoServicio().getValue() <= 10)) {
                                contexto.getStage("RenovarTiempo").show();
                            }
                        }

                    } else {
                        statusNet.setGlyphName("WIFI_OFF");
                        statusNet.setFill(Color.RED);
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

    @FXML
    private void CancelarBtnAction(ActionEvent event) {
        if (!contexto.isCancelandoTiempo() && !contexto.isRenovandoTiempo()) {
            contexto.getStage("CancelarTiempo").show();
        }
    }

    @FXML
    private void InfoUsuarioBtnAction(ActionEvent event) {
           contexto.getStage("InfoUsuario").show();
    }

}
