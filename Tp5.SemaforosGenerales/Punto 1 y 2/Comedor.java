/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import Repetto_FAI2548.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class Comedor {

    private int comederosSanos;
    private char turno; // Marca el turno de la especie que esta comiendo 
    private Semaphore cantComieron; // Cantidad de animales que comieron dentro del turno
    private Semaphore comiendoActualmente;// Marca la cantidad de animales que estan comiendo en el comedor 

    public Comedor(int cantComedores, char empiezaEspecie) {
        this.comederosSanos = cantComedores;
        this.cantComieron = new Semaphore(0);
        this.cantComieron.release(cantComedores); // Libera los permisos de cantidad maxima de animales que comen en un turno 
        this.turno = empiezaEspecie;
        this.comiendoActualmente= new Semaphore(cantComedores);
    }

    public synchronized boolean puedoAccederComer(char especie) {
        boolean pudoAcceder = false;
        if (turno == especie && cantComieron.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + ": accedio al comedor");
            pudoAcceder = true;
            pedirComedor();
        }
        return pudoAcceder;
    }
    
    private void pedirComedor() {
        try {
            if (turno == 'p') {
                comiendoActualmente.acquire(2);
            } else {
                comiendoActualmente.acquire();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminoDeComer() {
        System.out.println(Thread.currentThread().getName() + ": se va del comedor");
        if (turno == 'p') {
            comiendoActualmente.release(2);
        } else {
            comiendoActualmente.release();
        }
    }


    public synchronized void intentarCambiarTurno(){
        if (this.comiendoActualmente.availablePermits()== this.comederosSanos) {
        //Si no hay mas animales de esta especie comiendo, cambia de turno
            cambiarTurno();
        }
    }
    
    private void cambiarTurno() {
        if (turno == 'p') {
            System.out.println("-------- CAMBIO TURNO A GATOS --------");
            turno = 'g';
        } else {
            System.out.println("-------- CAMBIO TURNO A PERROS --------");
            turno = 'p';
        }
        this.cantComieron.release(comederosSanos);
    }

}
