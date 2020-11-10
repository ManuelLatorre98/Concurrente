/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp6.EjerciciosTeoria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class TestSaludo {

    public static void main(String argv[]) {
        try {
            String[] nombresEmpleados = {"Pablo", "Luis", "Andrea",
                "Pedro", "Paula"};
            Saludo hola = new Saludo();
            Thread[] elPersonal = new Thread[6];
            elPersonal[0] = new Thread(new Personal(hola, "JEFE", 5));
            for (int i = 1; i < 6; i++) {
                elPersonal[i] = new Thread(new Personal(hola,
                        nombresEmpleados[i - 1]));
            }
            for (int i = 0; i < 6; i++) {
                elPersonal[i].start();
            }

            
            /*//SOLUCION 1
            for (int i = 0; i < 6; i++) {
                elPersonal[i].join();
            }
             System.out.println("LISTO, ahora que todos han saludado - a trabajar");
             */
            
            hola.esperarMain(elPersonal.length-1);
            System.out.println("LISTO, ahora que todos han saludado - a trabajar");
            
            /*//SOLUCION 2
            for (int i = 0; i < 6; i++) {
                elPersonal[i].join();
            }
             System.out.println("LISTO, ahora que todos han saludado - a trabajar");
             */
        } catch (InterruptedException ex) {
            Logger.getLogger(TestSaludo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
