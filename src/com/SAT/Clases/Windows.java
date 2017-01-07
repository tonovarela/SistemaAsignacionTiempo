package com.SAT.Clases;

/**
 *
 * @author tonovarela
 */
public class Windows implements ISistemaOperativo {

    
    @Override
    public void CerrarSesion() {
        System.out.println("Cerrar Sesión en windows");
//        try {
//            System.out.println("Cerrando sesion en Windows");            
//            Runtime.getRuntime().exec("shutdown -l -f");
//        } catch (IOException ex) {
//            System.out.println("No se pudo cerra sesión");
//        }
        
    }
    @Override
    public String getIconOS() {
        return "WINDOWS";
    }

}
