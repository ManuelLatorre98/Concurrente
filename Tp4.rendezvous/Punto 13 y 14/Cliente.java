/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4.rendezvous;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class Cliente implements Runnable {
    private Sillon sillon;

    public Cliente(Sillon unSillon) {
        this.sillon = unSillon;
    }
    
    public void run(){
        yendoPeluqueria();
        if(sillon.verificarSillon()){
            try{
                //Si el sillon estaba libre entonces
                yendoPeluqueria();
                sillon.solicitarAtencionBarbero();
                sillon.simularCorte();
                sillon.liberarSillon();
            }catch(InterruptedException ex){
                Logger.getLogger(Cliente.class.getName()).
                log(Level.SEVERE, null, ex);
            }
        }else
            System.out.println(Thread.currentThread().getName()+" se fue");
    }
    
    private void yendoPeluqueria(){
        System.out.println(Thread.currentThread().getName()+" esta yendo a la peluqueria");
        try{
            Thread.sleep(2000);//Sleep para que el cliente no llegue antes que el barbero
        }catch(InterruptedException ex){
            Logger.getLogger(Cliente.class.getName()).
            log(Level.SEVERE, null, ex);
        }
    }
}
