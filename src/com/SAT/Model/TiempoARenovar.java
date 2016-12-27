
package com.SAT.Model;

/**
 *
 * @author tonovarela
 */
public class TiempoARenovar  {
       int _tiempo;
    
       public TiempoARenovar(int tiempo){
           this._tiempo=tiempo;
       }       
       public int getTiempo() {
        return _tiempo;
       } 
      public String ToString(){
          return "+"+_tiempo+" minutos";
      }

                  
    
}
