/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.rendezvous;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class EmpleadoConfiteria implements Runnable {

    private Confiteria confiteria;

    public EmpleadoConfiteria(Confiteria confi) {
        confiteria = confi;
    }

    public void run() {
        boolean yaComio = false;
        while (!yaComio) {
            if (confiteria.verificarEspacioLibre()) {// Pregunta si el lugar para comer esta disponible 
                try {
                    //Como esta disponible, se sienta a comer
                    confiteria.solicitarAtencion();//Le notifica al mozo que esta sentado para que le sirvan
                    confiteria.esperarComida();//Espera que el mozo le avise que tiene la comida
                    comiendo();//El empleado come
                    confiteria.avisarQueTermine();//Le notifica al mozo que termino de comer
                    yaComio = true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(EmpleadoConfiteria.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    //Si no encuentra lugar, sigue trabajando y pregunta despues
                    System.out.println("No esta libre el lugar, empleado sigue trabajando");
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EmpleadoConfiteria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " ya comio asique sigue trabajando");
    }

    private void comiendo() {
        //Metodo para simular al empleado comiendo
        try {
            System.out.println(Thread.currentThread().getName() + " esta comiendo");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " termino de comer");
        } catch (InterruptedException ex) {
            Logger.getLogger(EmpleadoConfiteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
