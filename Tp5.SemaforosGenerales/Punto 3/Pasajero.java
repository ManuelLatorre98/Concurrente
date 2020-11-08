/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class Pasajero implements Runnable {
    private Tren tren;

    public Pasajero(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        boolean pudoSubirse = false;
        try {
            llegandoAlTren();
            while (!pudoSubirse) {
                if (tren.pedirPasaje()) {
                    tren.mirarParaAfuera();
                    System.out.println(Thread.currentThread().getName() + ": se baja del tren");
                    pudoSubirse = true;
                } else {
                    System.out.println(Thread.currentThread().getName() + ": no pudo entrar al tren asi que espera");
                    Thread.sleep(15000);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llegandoAlTren() throws InterruptedException{
        //Metodo que simula al pasajero llegar al tren
        Thread.sleep((long)((Math.random()*20)*1000));
    }


    
    
}
