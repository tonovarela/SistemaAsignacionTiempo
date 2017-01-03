
package com.SAT.utils;

import com.SAT.Clases.Contexto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author tonovarela
 */
public class EventHandlerImpl implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
              int tiempo=((ButtonRenovar) (event.getSource())).getTiempo();
               System.out.println("Me has clickeado "+tiempo);
               Contexto.getInstance().getReloj().setTiempo(tiempo*60);
               Contexto.getInstance().CerrarStage(event);
    }
    
}
