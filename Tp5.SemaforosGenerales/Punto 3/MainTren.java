/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

/**
 *
 * @author repetto.francisco
 */
public class MainTren {
    
    public static void main(String[] args) {
        Tren tren = new Tren(6);
        
        ControlTren control = new ControlTren(tren);
        
        VendedorTicket vendedor = new VendedorTicket(tren);
        
        int cantPasajeros = 13;
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        
        
        for (int i = 0; i < cantPasajeros ; i++) {
            pasajeros[i] = new Pasajero(tren);
        }
        
        Thread controlTren = new Thread(control);
        Thread vendedorTickets = new Thread(vendedor);
        Thread[] pasajerosHilos = new Thread[cantPasajeros];
                
        for (int i = 0; i < cantPasajeros; i++) {
            pasajerosHilos[i] = new Thread(pasajeros[i],"PASAJERO "+i);
        }
        
        controlTren.start();
        vendedorTickets.start();
        for (int i = 0; i < cantPasajeros; i++) {
            pasajerosHilos[i].start();
        }
        
    }
    
    
}
