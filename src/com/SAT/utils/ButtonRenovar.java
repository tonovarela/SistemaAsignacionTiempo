package com.SAT.utils;

import javafx.scene.control.Button;

/**
 *
 * @author tonovarela
 */
public class ButtonRenovar extends Button {

    private int _tiempo;

    public ButtonRenovar() {
        super();

    }

    public void SetTiempoPermitido(int tiempoPermitido, int tiempo) {
        this._tiempo = tiempo;
        if (tiempoPermitido >= tiempo) {
            this.setDisable(false);
        } else {
            this.setDisable(true);
        }
        this.setOnAction(new EventHandlerImpl());
    }

    public int getTiempo() {
        return _tiempo;
    }

}
