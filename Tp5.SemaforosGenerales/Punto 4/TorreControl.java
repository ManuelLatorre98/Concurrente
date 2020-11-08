/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class TorreControl {

    private Semaphore pista;
    private Semaphore semAterrizajesMax;
    private int prioridadActual;//Si es 0 los aterrizajes tienen prioridad y si es 1 los despegues tienen prioridad
    private int esperandoAterrizar;
    private int esperandoDespegar;

    public TorreControl(int unPrioridad) {
        pista = new Semaphore(1);
        this.semAterrizajesMax = new Semaphore(10);
        this.prioridadActual = unPrioridad;
    }

    public boolean preguntarAterrizar(int unPrioridad) {
        boolean aterriza = false;
        if (semAterrizajesMax.tryAcquire()) { //Intenta a entrar entre los diez permitidos de prioridad
            if (prioridadActual == unPrioridad) {
                System.out.println(Thread.currentThread().getName() + " va a poder aterrizar");
                try {
                    pista.acquire();
                    aterrizar(); // Simula la accion aterrizar
                    aterriza = true;
                    actualizarPrioridad();
                    pista.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return aterriza;
    }

    private void aterrizar() {
        try {
            System.out.println(Thread.currentThread().getName() + ": esta ATERRIZANDO");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": termino de ATERRIZAR");
        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean preguntarDespego(int unPrioridad) throws InterruptedException {
        boolean despegar = false;
        if (prioridadActual == unPrioridad && pista.tryAcquire()) {
            despegar();// Simula la accion de despegar
            despegar = true;
            actualizarPrioridad();
            pista.release();
        }
        return despegar;
    }

    private void despegar() {
        try {
            System.out.println(Thread.currentThread().getName() + ": esta DESPEGANDO");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": termino de DESPEGAR");
            esperandoDespegar--;
        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarPrioridad() {
        if (prioridadActual != 1 && !pista.hasQueuedThreads()) {
            System.out.println("-----------------Prioridad Despegue-----------------");
            prioridadActual = 1;
            semAterrizajesMax.release(10);
        } else {
            if (prioridadActual != 0 && semAterrizajesMax.availablePermits() != 10) {
                System.out.println("-----------------Prioridad Aterrizaje-----------------");
                prioridadActual = 0;
            }
        }
    }

}
