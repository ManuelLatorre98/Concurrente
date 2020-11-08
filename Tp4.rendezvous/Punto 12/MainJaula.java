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
public class MainJaula {
    
    public static void main(String[] args) {
    
    Jaula jaula = new Jaula();
    
    Hamster ham1 = new Hamster(jaula);
    Hamster ham2 = new Hamster(jaula);
    Hamster ham3 = new Hamster(jaula);
    Hamster ham4 = new Hamster(jaula);
    
    Thread hamster1 = new Thread(ham1 ,"hamster1");
    Thread hamster2 = new Thread(ham2,"hamster2");
    Thread hamster3 = new Thread(ham3,"hamster3");
    Thread hamster4 = new Thread(ham4,"hamster4");
    
    hamster1.start();
    hamster2.start();
    hamster3.start();
    hamster4.start();
    
    
    
    }
    
}
