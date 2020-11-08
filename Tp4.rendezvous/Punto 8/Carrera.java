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
public class Carrera {
    public static void main(String[] args) {
        
        Testigo palo = new Testigo();
        
        Atleta atle1 = new Atleta(palo);
        Atleta atle2 = new Atleta(palo);
        Atleta atle3 = new Atleta(palo);
        Atleta atle4 = new Atleta(palo);
        
        Thread atleta1 = new Thread(atle1,"ATLETA1");
        Thread atleta2 = new Thread(atle2,"ATLETA2");
        Thread atleta3 = new Thread(atle3,"ATLETA3");
        Thread atleta4 = new Thread(atle4,"ATLETA4");
        
        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
        
    }
    
    
    
}
