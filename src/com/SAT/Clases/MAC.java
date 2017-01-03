/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.Clases;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonovarela
 */
public class MAC implements ISistemaOperativo {

    @Override
    public void CerrarSesion() {
        System.out.println("Cerrando sesion en MAC");
//        Runtime runtime = Runtime.getRuntime();
//        String[] args = { "osascript", "-e", "tell application \"loginwindow\" to  «event aevtrlgo»" };
//        try {
//             runtime.exec(args);
//        } catch (IOException ex) {
//            Logger.getLogger(MAC.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public String getNameIcon() {
        return "APPLE";
    }
    
}
