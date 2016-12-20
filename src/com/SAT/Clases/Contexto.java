
package com.SAT.Clases;

/**
 *
 * @author tonovarela
 */
public class Contexto {
    private static  Contexto contexto= new Contexto();
    
    private final Reloj reloj;
    
    
    public static Contexto getInstance(){
        if (contexto==null){
            contexto= new Contexto();
        }        
        return contexto;
    }
    
    
    public Contexto(){
        reloj= new Reloj();
    }
    
    public Reloj getReloj() {
        return reloj;
    }
    
}
