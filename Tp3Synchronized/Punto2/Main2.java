/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4;

/**
 *
 * @author repetto.francisco
 */
public class Main2 {
    public static void main(String[] args) {
        Vida vid=new Vida();
        Orco or=new Orco(vid);
        Curandero curan=new Curandero(vid);
        Thread Orco=new Thread(or);
        Thread Curandero=new Thread(curan);
        Orco.start();
        Curandero.start();
    }
}
