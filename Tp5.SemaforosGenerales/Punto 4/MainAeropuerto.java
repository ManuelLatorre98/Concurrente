/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;


/**
 *
 * @author repetto.francisco
 */

public class MainAeropuerto {

    public static void main(String[] args) {

        TorreControl torre = new TorreControl(0);

        Avion[] aterrizados = new Avion[11];
        Avion[] despegados = new Avion[0];

        for (int i = 0; i < aterrizados.length; i++) {
            aterrizados[i] = new Avion(torre, 0);
        }

        for (int i = 0; i < despegados.length; i++) {
            despegados[i] = new Avion(torre, 1);
        }

        Thread[] hilosAte = new Thread[aterrizados.length];
        Thread[] hilosDespe = new Thread[despegados.length];

        for (int i = 0; i < aterrizados.length; i++) {
            hilosAte[i] = new Thread(aterrizados[i], "Av.Aterrizar" + i);
        }

        for (int i = 0; i < despegados.length; i++) {
            hilosDespe[i] = new Thread(despegados[i], "Av.Despegue" + i);
        }

        for (int i = 0; i < aterrizados.length; i++) {
            hilosAte[i].start();
        }

        for (int i = 0; i < despegados.length; i++) {
            hilosDespe[i].start();
        }
    }
}

