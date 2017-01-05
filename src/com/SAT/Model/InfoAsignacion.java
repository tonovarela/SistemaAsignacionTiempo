package com.SAT.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tonovarela
 */
public class InfoAsignacion {

    private final StringProperty _usuario;
    private final StringProperty _nombre;
    private final StringProperty _lugarEquipoAsignado;
    private final IntegerProperty _tiempoAsignado;
    private final IntegerProperty _tiempoServicio;
    private final IntegerProperty _tiempoMaxServicio;

    public InfoAsignacion() {
        this._nombre = new SimpleStringProperty();
        this._lugarEquipoAsignado = new SimpleStringProperty();
        this._tiempoAsignado = new SimpleIntegerProperty();
        this._tiempoServicio = new SimpleIntegerProperty();
        this._tiempoMaxServicio = new SimpleIntegerProperty();
        this._usuario = new SimpleStringProperty();
    }


    public StringProperty Usuario() {
        return this._usuario;
    }

    public IntegerProperty TiempoMaximoServicio() {
        return this._tiempoMaxServicio;
    }

    public StringProperty Nombre() {
        return this._nombre;
    }

    public StringProperty LugarEquipoAsignado() {
        return this._lugarEquipoAsignado;
    }

    public IntegerProperty TiempoAsignado() {
        return this._tiempoAsignado;
    }

    public IntegerProperty TiempoServicio() {
        return this._tiempoServicio;
    }

}
