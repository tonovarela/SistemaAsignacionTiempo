
package com.SAT.Clases;
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
    private int _totalRestante;
    public StringProperty TiempoLabel;
    Timeline timeline;


    public Reloj() {
        
      timeline = new Timeline();
        KeyFrame k = new KeyFrame(Duration.seconds(1), (e) -> {
            cuentaRegresiva();
        });
        timeline.getKeyFrames().add(k);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    
    public void IniciaCuentaRegresiva(int totalSegundos) {
        TiempoLabel = new SimpleStringProperty();
        this._minutos = totalSegundos / 60;
        this._segundos = totalSegundos % 60;
        this._totalRestante = totalSegundos;
        timeline.play();
        
    }
    private void cuentaRegresiva() {

        if (this._minutos == 0 && this._segundos == 0) {
            this.timeline.stop();
            Platform.exit();
            System.exit(0);
        } else {
            if (this._segundos == 0) {
                this._segundos = 59;
                this._minutos--;
            } else {
                this._segundos--;
                this._totalRestante--;
            }
            TiempoLabel.setValue(String.format("%02d:%02d", this._minutos, this._segundos));                        
        }

    }

   
    public void detenerReloj() {
        timeline.stop();
    }

}
