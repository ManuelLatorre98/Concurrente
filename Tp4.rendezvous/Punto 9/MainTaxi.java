/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.rendezvous;

/**
 *
 * @author repetto.francisco
 */

public class MainTaxi {
    public static void main(String[] args) {
     
        ViajeTaxi unViaje = new ViajeTaxi();
     
        Taxista unTaxista = new Taxista(unViaje);
        
        Pasajero unPasajero = new Pasajero(unViaje);
        Pasajero unPasajero2 = new Pasajero(unViaje);
        
        Thread taxista = new Thread(unTaxista);
        Thread pasajero = new Thread(unPasajero, "Pasajero Fran");
        Thread pasajero2 = new Thread(unPasajero2, "Pasajero Juan");
        
        taxista.start();
        pasajero.start();
        pasajero2.start();
        
        
    
    }
    
}
