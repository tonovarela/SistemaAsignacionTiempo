package com.SAT.Controllers;

import com.SAT.Clases.Centinela;
import com.SAT.Clases.Contexto;
import com.SAT.Clases.Reloj;
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
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        System.out.println("You clicked me!");
        Contexto.getInstance().getReloj().setTiempo(40);
        //     reloj.detenerReloj();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Contexto contexto = Contexto.getInstance();
        Reloj reloj = contexto.getReloj();
        reloj.setTiempo(40);
        
        label.textProperty().bind(reloj.TiempoLabel);
        Centinela centinela = contexto.getCentinela();
        
        Timeline _timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), (e) -> {
                    
                    if (centinela.estaConectado()){
                        if (reloj.getTiempoRestante()==30){
                        System.out.println("Desea renovar su tiempo");
                    }                        
                        System.out.println("Se monitorea el ServiceBusChat");
                    }
                })
        );
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();

    }

}
