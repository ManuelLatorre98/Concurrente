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
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViajeTaxi {
    Semaphore semTaxi;
    Semaphore semTaxista;
    Semaphore semPasajero;

    public ViajeTaxi() {
        semTaxi = new Semaphore(1);
        semTaxista = new Semaphore(0);
        semPasajero = new Semaphore(0);
    }
    
    public void esperaPasajero() throws InterruptedException{
        semTaxista.acquire();//El taxista no tiene permiso en el semaforo,espera
    }
    
    public void terminoDeLlevar(){
            System.out.println("Taxista llego al destino y le avisa al cliente");
            semPasajero.release();//Le avisa al pasajero que llego
    }
    
    
    public void solicitaSerAtendido() throws InterruptedException{
        semTaxi.acquire();
        System.out.println(Thread.currentThread().getName() + " solicita ser atendido al taxista");
        semTaxista.release();
    }
    
    public void esperaLlegar() throws InterruptedException{
        semPasajero.acquire();//Simula que esta esperando hasta que el taxita le diga que llegaron a su destino
        System.out.println(Thread.currentThread().getName() + " fue avisado que llego a su destino");
    }
    
    public void liberarTaxi(){
        try{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " paga y se baja del taxi");
            semPasajero.release();//Libera el taxi
            semTaxi.release();
        }catch(InterruptedException ex){
            Logger.getLogger(Cliente.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
