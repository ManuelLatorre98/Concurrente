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

public class Confiteria {
    private Semaphore semLugar;
    private Semaphore semMozo;
    private Semaphore semEmpleado;
    private Semaphore semComida;
    
    public Confiteria(){
        semLugar = new Semaphore(1);
        semMozo = new Semaphore(0);
        semEmpleado = new Semaphore(0);
        semComida = new Semaphore(0);
    }

    void esperarParaServir() throws InterruptedException{
        System.out.println("MOZO esperando a que alguien le notifique para comer mientras hace su hobbie");
        semMozo.acquire();
    }
    
    boolean verificarEspacioLibre() {
        System.out.println(Thread.currentThread().getName()+" pregunta si esta disponble el lugar");
        return semLugar.tryAcquire();
    }

    void solicitarAtencion() {
        System.out.println(Thread.currentThread().getName()+" le avisa al mozo que le puede servir");
        semMozo.release();
    }

    void esperarComida() throws InterruptedException{
        semEmpleado.acquire();
    }

    void llevarLaComida() throws InterruptedException{
        System.out.println("MOZO le avisa que ya tiene la comida");
        semEmpleado.release();
        System.out.println("MOZO espera a que termine de comer");
        semComida.acquire();
    }

    void avisarQueTermine() {
        System.out.println(Thread.currentThread().getName()+" le avisa al mozo que termino y libera el lugar");
        semComida.release();
        semLugar.release();
    }
        
}
