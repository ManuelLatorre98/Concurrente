/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import Repetto_FAI2548.*;

/**
 *
 * @author repetto.francisco
 */
public class MainComedor {

    public static void main(String[] args) {
        int cantComedores = 5;
        
        Comedor comedor = new Comedor(cantComedores, 'p');

        Animal[] gatos = new Animal[3];
        Animal[] perros = new Animal[6];

        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = new Animal('g', comedor);
        }

        for (int i = 0; i < perros.length; i++) {
            perros[i] = new Animal('p', comedor);
        }

        Thread[] hilosGatos = new Thread[gatos.length];
        Thread[] hilosPerros = new Thread[perros.length];

        for (int i = 0; i < gatos.length; i++) {
            hilosGatos[i] = new Thread(gatos[i], "Gato" + i);
        }

        for (int i = 0; i < perros.length; i++) {
            hilosPerros[i] = new Thread(perros[i], "Perro" + i);
        }

        for (int i = 0; i < gatos.length; i++) {
            hilosGatos[i].start();
        }
        
        for (int i = 0; i < perros.length; i++) {
            hilosPerros[i].start();
        }
    }

}
