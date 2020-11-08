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
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Jaula {
    private ElemJaula plato;
    private ElemJaula rueda;
    private ElemJaula hamaca;

    public Jaula() {
        plato = new ElemJaula("Plato");
        rueda = new ElemJaula("Rueda");
        hamaca = new ElemJaula("Hamaca");
    }
    
    public boolean hamsterFeliz(){
        boolean estaFeliz = false;
        boolean usoPlato = false, usoRueda = false, usoHamaca = false;
        while(!estaFeliz){
            if(!usoPlato)
                usoPlato = plato.preguntarParaUsar();
            if(!usoRueda)
                usoRueda = rueda.preguntarParaUsar();
            if(!usoHamaca)
                usoHamaca = hamaca.preguntarParaUsar();
            if(usoPlato && usoRueda && usoHamaca)
                estaFeliz = true;
            else{ 
                try {
                    //Si no pudo usar uno de los objetos, lo duerme asi no hace una espera activa
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jaula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }
        return estaFeliz;  
    }
}
