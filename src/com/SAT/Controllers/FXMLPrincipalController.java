package com.SAT.Controllers;

import com.SAT.Clases.Centinela;
import com.SAT.Clases.Contexto;
import com.SAT.Clases.Reloj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Label Tiempo;

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
        _stageCancelarTiempo = Contexto.getInstance().getStageCancelarTiempo();
        Reloj reloj = contexto.getReloj();
        reloj.setTiempo(200);

        Tiempo.textProperty().bind(reloj.TiempoLabel);
        Centinela centinela = contexto.getCentinela();

        Timeline _timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), (e) -> {
                    if (centinela.estaConectado()) {                                                
                        if (reloj.getTiempoRestante() == 30 ) {                            
                            Contexto.getInstance().getStageRenovarTiempo().show();
                        }
                        System.out.println("Se monitorea el ServiceBusChat");
                    }
                })
        );
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();

    }

}
