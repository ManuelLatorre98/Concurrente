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
public class Avion implements Runnable {
    private TorreControl torre;
    private int accion;//Si es 0 el avion quiere aterrizar y si es 1 el avion quiere despegar

    public Avion(TorreControl unTorre,int unAccion) {
        this.torre = unTorre;
        this.accion = unAccion;
    }
 
    public void run() {
        try {
            if (this.accion == 0) {
                intentarAterrizar();
            } else {
                intentarDespegar();
            }
        } catch (InterruptedException ex) {
            System.out.println("Hubo un error");
        }
    }

    private void intentarAterrizar() throws InterruptedException {
        boolean aterrizo = false;
        while (!aterrizo) {
            if(torre.preguntarAterrizar(0)){
               aterrizo = true; 
            }else{
                System.out.println(Thread.currentThread().getName()+": no pudo aterrizar, sigue volando");
                Thread.sleep(10000);
            }
        }
    }

    private void intentarDespegar() throws InterruptedException {
        boolean despego = false;
        while (!despego) {
            if (torre.preguntarDespego(1)) {
                despego = true;
            } else {
                System.out.println(Thread.currentThread().getName() + ": no pudo despegar");
                Thread.sleep(10000);
            }
        }
    }



    
    
}
