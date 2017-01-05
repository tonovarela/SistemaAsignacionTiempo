
package com.SAT.Clases;

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
    public String getIconOS() {
        return "APPLE";
    }
    
}
