/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

/**
 *
 * @author tonovarela
 */
public class MAC implements ISistemaOperativo {

    @Override
    public void CerrarSesion() {
        System.out.println("Cerrando sesion en MAC");
    }

    @Override
    public String getNameIcon() {
        return "APPLE";
    }
    
}
