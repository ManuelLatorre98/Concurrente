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
public class Tren {
    private int cantSillasDispo;
    private Semaphore semPasajes;
    private Semaphore semVendedor;
    private Semaphore semPasajero;
    private Semaphore semControlTren;
    
    public Tren(int cantSillas){
        cantSillasDispo = cantSillas;
        semPasajes= new Semaphore(cantSillas);
        semVendedor = new Semaphore(0);
        semPasajero = new Semaphore(0);
        semControlTren = new Semaphore(0);
    }

    public synchronized boolean pedirPasaje() {
        boolean compro = semPasajes.tryAcquire();
        notifyAll();
        return compro;
    }
        
    public void esperarParaVender() throws InterruptedException{
        semVendedor.acquire();
    }

    public synchronized void vendendiendo() {
        int i=0;
        while(semPasajes.availablePermits()!=0){
            try {
                wait();
                i++;
                System.out.println("Vendedor vendio "+i+" pasajes");
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void esperarTrenLleno() throws InterruptedException {
        semControlTren.acquire();
    }

    public void avisarVendioTodo() {
        semControlTren.release();
    }

    public synchronized void avisarQueTerminoViaje() throws InterruptedException {
        semPasajero.release(this.cantSillasDispo);
        Thread.sleep(2000);// Solo duerme para que los carteles de pasajeros bajandose aparezcan antes
        semVendedor.release();
    }

    void mirarParaAfuera() throws InterruptedException {
        semPasajero.acquire();
    }

    void esperarQueVuelva() throws InterruptedException{
        semVendedor.acquire();
        semPasajes.release(this.cantSillasDispo);
    }

    
}
