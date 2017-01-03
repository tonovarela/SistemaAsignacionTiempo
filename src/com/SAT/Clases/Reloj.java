package com.SAT.Clases;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

/**
 *
 * @author tonovarela
 */
public class Reloj {

    public StringProperty TiempoLabel;    
    public DoubleProperty TiempoRestantePorcentaje;
    private int _segundosTotal;
    private int _segundos;
    private int _minutos;
    private final Timeline  _timeline;
    private int _segundosRestantes;
    

    public Reloj() {
        _timeline = new Timeline();
        TiempoLabel = new SimpleStringProperty();        
        TiempoRestantePorcentaje = new SimpleDoubleProperty();
        KeyFrame k = new KeyFrame(Duration.seconds(1), (e) -> {
            cuentaRegresiva();
        });
        _timeline.getKeyFrames().add(k);
        _timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void setTiempo(int segundosTotal) {
        this._segundosTotal = segundosTotal;
        this._segundosRestantes=segundosTotal;
        this._minutos = segundosTotal / 60;
        this._segundos = segundosTotal % 60;
        _timeline.play();

    }
      public int getTiempoRestante() {
        return _segundosRestantes;
    }

      public void cuentaRegresiva() {
        if (this._segundosRestantes==0) {
            this._timeline.stop();            
        } else {
            if (this._segundos == 0) {
                this._segundos = 59;
                this._minutos--;
            } else {
                this._segundos--;
            }
            _segundosRestantes = (_minutos * 60 + this._segundos);            
            TiempoLabel.set(String.format("%02d:%02d", this._minutos, this._segundos));
            TiempoRestantePorcentaje.setValue(((_segundosRestantes * 100) / this._segundosTotal));
        }

    }
     
  

}
