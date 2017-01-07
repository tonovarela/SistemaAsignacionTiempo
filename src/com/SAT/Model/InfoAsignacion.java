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
    private final IntegerProperty _tiempoServicioRestante;
    private final IntegerProperty _maxRenovacionServicio;

    public InfoAsignacion() {
        this._nombre = new SimpleStringProperty();
        this._lugarEquipoAsignado = new SimpleStringProperty();
        this._tiempoAsignado = new SimpleIntegerProperty();
        this._tiempoServicioRestante = new SimpleIntegerProperty();
        this._maxRenovacionServicio = new SimpleIntegerProperty();
        this._usuario = new SimpleStringProperty();
    }

    public StringProperty Usuario() {
        return this._usuario;
    }

    public void setMaxRenovacionPermitido(int value) {
        this._maxRenovacionServicio.setValue(value);
    }

    public int getMaxRenovacionPermitido() {
        int max = 90;//Maximo 90 minutos de servicio permitido 
        int a = this._maxRenovacionServicio.get();
        int b = this._tiempoServicioRestante.get();

        if (a <= max  && b>=a ) 
            return a;        
        else
            return b;                      
    }

    public IntegerProperty TiempoServicioRestante() {
        return this._tiempoServicioRestante;
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

}
