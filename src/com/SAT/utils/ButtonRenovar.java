package com.SAT.utils;

import javafx.scene.control.Button;

/**
 *
 * @author tonovarela
 */
public class ButtonRenovar extends Button {

    private int _tiempoRepresentado;

    public ButtonRenovar() {
        super();
    }

    public void SetTiempoMaximoServicio(int tiempoMaximo, int tiempoRepresentado) {
        this._tiempoRepresentado = tiempoRepresentado;
        if (tiempoMaximo >= tiempoRepresentado) {
            this.setDisable(false);
        } else {
            this.setDisable(true);
        }
        this.setOnAction(new EventoRenovarTiempo());
    }

    public int getTiempoRepresentado() {
        return _tiempoRepresentado;
    }

}
