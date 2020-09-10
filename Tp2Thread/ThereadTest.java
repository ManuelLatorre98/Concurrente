/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3;

/**
 *
 * @author repetto.francisco
 */
public class ThereadTest {
    public static void main(String[] args) {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        System.out.println("En el main");
    }
}
