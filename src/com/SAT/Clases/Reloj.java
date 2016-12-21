package com.SAT.Clases;

import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class Reloj {

    private int _segundos;
    private int _minutos;
    private int _tiempoRestante;

  
    public StringProperty TiempoLabel;
    private Timeline _timeline;

    public Reloj() {
        _timeline = new Timeline();
        TiempoLabel = new SimpleStringProperty();
        KeyFrame k = new KeyFrame(Duration.seconds(1), (e) -> {
            cuentaRegresiva();
        });
        _timeline.getKeyFrames().add(k);
        _timeline.setCycleCount(Animation.INDEFINITE);
    }
    
      public int getTiempoRestante() {
        return _tiempoRestante;
    }

    public void cuentaRegresiva() {
        if (this._minutos == 0 && this._segundos == 0) {
            this._timeline.stop();
            Platform.exit();
            System.exit(0);
        } else {
            if (this._segundos == 0) {
                this._segundos = 59;
                this._minutos--;
            } else {
                this._segundos--;
                this._tiempoRestante--;
            }
            TiempoLabel.setValue(String.format("%02d:%02d", this._minutos, this._segundos));
        }

    }

    public void setTiempo(int totalSegundos) {
        this._minutos = totalSegundos / 60;
        this._segundos = totalSegundos % 60;
        this._tiempoRestante = totalSegundos;
        _timeline.play();

    }

    public void detenerReloj() {
        _timeline.stop();
    }

}
