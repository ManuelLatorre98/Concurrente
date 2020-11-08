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
public class Pasajero implements Runnable {

    private ViajeTaxi viaje;

    public Pasajero(ViajeTaxi viaje) {
        this.viaje = viaje;
    }

    public void run() {
        try {
            buscandoTaxi();
            viaje.solicitaSerAtendido();
            viaje.esperaLlegar();
            viaje.liberarTaxi();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscandoTaxi(){
        try {
            System.out.println(Thread.currentThread().getName()+" esta buscando taxi");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    

}
