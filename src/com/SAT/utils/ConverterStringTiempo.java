/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.utils;

import com.SAT.Model.TiempoARenovar;
import javafx.util.StringConverter;

/**
 *
 * @author tonovarela
 */
public class ConverterStringTiempo extends StringConverter<TiempoARenovar> {

    @Override
    public String toString(TiempoARenovar object) {
        return object.ToString();
    }

    @Override
    public TiempoARenovar fromString(String string) {
        return null;
    }

}
