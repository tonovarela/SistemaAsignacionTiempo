
package com.SAT.utils;

import com.SAT.Clases.Contexto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author tonovarela
 */
public class EventoRenovarTiempo implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
              
               int tiempo=((ButtonRenovar) (event.getSource())).getTiempoRepresentado();               
               Contexto.getInstance().getReloj().setTiempo(tiempo*60);
               Contexto.getInstance().CerrarStage(event);
               Contexto.getInstance().setRenovandoTiempo(false);
    }
    
}
