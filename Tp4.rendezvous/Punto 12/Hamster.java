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
public class Hamster implements Runnable {
    private String name;
    private boolean feliz;
    private Jaula jaula;
    
    public Hamster(Jaula unJaula){
        this.jaula = unJaula;
        feliz = false;
    }
    
    public boolean getFeliz(){
        return feliz;
    }
    
    public void run(){
        feliz = jaula.hamsterFeliz();
        System.out.println("HAMSTER: "+Thread.currentThread().getName()+" ESTA FELIZ");    
    }
    
    
    
    
    
    
}
