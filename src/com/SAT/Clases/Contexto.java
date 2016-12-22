
package com.SAT.Clases;

import javafx.stage.Stage;

/**
 *
 * @author tonovarela
 */
public class Contexto {
    private static  Contexto contexto= new Contexto();
    private Stage _renovarTiempo;
    private Stage _mensajeChat;
    private Centinela _centinela;

  
    
    private final Reloj reloj;
    
    
    
    
    public static Contexto getInstance(){
        if (contexto==null){
            contexto= new Contexto();
        }        
        return contexto;
    }
    
    
    public Contexto(){
        reloj= new Reloj();
        this._centinela= new Centinela();
        this._renovarTiempo= new StageModal();
        this._mensajeChat= new StageModal();
        
    }
    
    public Reloj getReloj() {
        return reloj;
    }
      public Centinela getCentinela() {
        return _centinela;
    }
    
    
}
