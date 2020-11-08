/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import Repetto_FAI2548.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class Animal implements Runnable {

    private char especie;//Si es 'p' es especie perro y si es 'g' es especie gato
    private Comedor comedor;

    public Animal(char unEspecie, Comedor unComedor) {
        this.especie = unEspecie;
        this.comedor = unComedor;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " pregunta si puede acceder al comedor");
                Thread.sleep(2000);//Lo duerme para simular que esta esperando respuesta
                if (comedor.puedoAccederComer(especie)) {
                    //Si pudo acceder al comedor, entonces simula que esta comiendo
                    comiendo();
                    comedor.terminoDeComer();
                    comedor.intentarCambiarTurno();
                    Thread.sleep(20000);//Para simular el tiempo que el animal no quiera volver a comer
                } else {
                    //Si no apudo acceder espera afuera del comedor
                    System.out.println(Thread.currentThread().getName() + ": no pudo acceder al comedor, se queda esperando");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void comiendo() throws InterruptedException {
        //Metodo que simula al animal comiendo
        System.out.println(Thread.currentThread().getName() + ": esta comiendo");
        Thread.sleep(7000);
        System.out.println(Thread.currentThread().getName() + ": termino de comer");
    }

}
