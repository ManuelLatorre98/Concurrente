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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atleta implements Runnable {
    private Testigo palo;

    public Atleta(Testigo palo) {
        this.palo = palo;
    }
    
    public void run(){
        try{
            palo.tomarTestigo();//El atleta espera recibir el testigo
            correAtleta();
            palo.soltarTestigo();//Termino de correr, se lo pasa al siguiente atleta y termina
        }catch(InterruptedException ex){
            Logger.getLogger(Atleta.class.getName()).
                log(Level.SEVERE, null, ex);  
        }
    }
    
    private void correAtleta(){
        long tiempoCorriendo;
        try{
            double tiempoActual=System.currentTimeMillis();
            tiempoCorriendo = (long)((Math.random()*(11-9+1)+9))*1000;
            Thread.sleep(tiempoCorriendo);
            tiempoActual = (System.currentTimeMillis() - tiempoActual)/1000;
            System.out.println(Thread.currentThread().getName()+" tardo: "+tiempoActual+" s");
        }catch(InterruptedException ex){
            Logger.getLogger(Testigo.class.getName()).
                log(Level.SEVERE, null, ex);
        }
    }
            
        
}
