/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp6.EjerciciosTeoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author repetto.francisco
 */
public class Saludo {
    private Semaphore semJefe = new Semaphore(0);
    private Semaphore semMain = new Semaphore(0);

    synchronized void esperarJefe(String empleado) {
        try {
            wait();
            System.out.println(empleado + "> Buenos dias jefe!");
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    synchronized void saludoJefe() {
        System.out.println("JEFE> Buenos dias!");
        notifyAll();
    }
    
    void esperarEmpleados(int x) throws InterruptedException{
        semJefe.acquire(x);
    }

    void avisarAJefe() {
        semJefe.release();
    }
    
    void esperarMain(int x) throws InterruptedException{
        semMain.acquire(x);
    }

    void avisarMain() {
        semMain.release();
    }

}
