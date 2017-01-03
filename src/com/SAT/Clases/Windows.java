package com.SAT.Clases;

import java.io.IOException;

/**
 *
 * @author tonovarela
 */
public class Windows implements ISistemaOperativo {

    
    @Override
    public void CerrarSesion() {
        System.out.println("Cerrar Sesión");
//        try {
//            System.out.println("Cerrando sesion en Windows");            
//            Runtime.getRuntime().exec("shutdown -l -f");
//        } catch (IOException ex) {
//            System.out.println("No se pudo cerra sesión");
//        }
        
    }
    @Override
    public String getNameIcon() {
        return "WINDOWS";
    }

}
