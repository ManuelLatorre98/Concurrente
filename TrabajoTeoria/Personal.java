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
public class Personal implements Runnable {

    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    private int numEmp;

    Personal(Saludo s, String n) {
        esJefe = false;
        nombre = n;
        saludo = s;
    }

    Personal(Saludo s, String n, int x) {
        esJefe = true;
        nombre = n;
        saludo = s;
        numEmp = x;
    }

    public void run() {
        System.out.println("(" + nombre + " llega)");
        if (esJefe) {
            try {
                System.out.println("(Esperando...)");
                saludo.esperarEmpleados(numEmp);
                saludo.saludoJefe();
            } catch (InterruptedException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            saludo.avisarAJefe();
            saludo.esperarJefe(nombre);
            saludo.avisarMain();
        }
    }
}
