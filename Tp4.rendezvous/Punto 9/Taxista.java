/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.rendezvous;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class Taxista implements Runnable {
    private ViajeTaxi viaje;

    public Taxista(ViajeTaxi viaje) {
        this.viaje = viaje;
    }
    
    public void run(){
        boolean termino=false;
        while(!termino){
            try{
                viaje.esperaPasajero();
                llevaPasajero();
                viaje.terminoDeLlevar();
            }catch(InterruptedException ex){
                Logger.getLogger(Taxista.class.getName()).
                log(Level.SEVERE, null, ex);                
            }
        }
    }
    
    public void llevaPasajero(){
        try{
            System.out.println("El taxista lleva a pasajero al destino");
            Thread.sleep(7000);//Sleep para simular el viaje;
        }catch(InterruptedException ex){
            Logger.getLogger(Taxista.class.getName()).
                log(Level.SEVERE, null, ex);                
        }
    }
    
}
