package com.SAT.Controllers;

import com.SAT.Clases.AzureServiceBusClient;
import com.SAT.Clases.Centinela;
import com.SAT.Clases.Contexto;
import com.SAT.Clases.Reloj;
import com.SAT.Model.InfoAsignacion;
import com.SAT.utils.GaugeControl;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesign.MaterialDesignIcon;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
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
        AzureServiceBusClient azureServiceBusClient = contexto.getAzureServiceBusClient();
        Timer monitorMensajes = contexto.getMonitorMensajes();
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
                        if (reloj.getTiempoRestante() == 30 && !contexto.isCancelandoTiempo() && !(infoAsignacion.getMaxRenovacionPermitido() < 10)) {
                            contexto.getStage("RenovarTiempo").show();
                        }
                        if (!(azureServiceBusClient.hayMensajes())) {
                            contexto.getStage("Mensaje").show();
                        }

                    } else {
                        statusNet.setGlyphName("WIFI_OFF");
                        statusNet.setFill(Color.RED);
                    }

                    if (reloj.getTiempoRestante() == 0) {
                        azureServiceBusClient.BorrarSuscripcion();
                        monitorMensajes.cancel();
                        contexto.CerrarSesion();
                        Platform.exit();
                        System.exit(0);
                    }

                })
        );
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
        azureServiceBusClient.Conectarse("testvarela1",//Namespace
                "RootManageSharedAccessKey",//Politicas de acceso
                "xPc9YM9F5m344YYjoXdisFw/TeK4p8cTw2EJGZWlVEQ=",//Key
                "varela",//Topico
                "abel"//Suscriptor
        );
        monitorMensajes.scheduleAtFixedRate(azureServiceBusClient, 1, 1000);

    }

    @FXML
    private void CancelarBtnAction(ActionEvent event) {
        if (!contexto.isCancelandoTiempo() && !contexto.isRenovandoTiempo()) {
            contexto.getStage("CancelarTiempo").show();
        }
    }

    @FXML
    private void InfoUsuarioBtnAction(ActionEvent event) {
        if (!contexto.isCancelandoTiempo() && !contexto.isRenovandoTiempo() && !contexto.isMostrandoInfoUsuario()) {
            contexto.setMostrandoInfoUsuario(true);
            contexto.getStage("InfoUsuario").show();
        }
    }

}
