/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp4;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author repetto.francisco
 */

public class VerificarCuenta implements Runnable {
   
    private CuentaBanco cb = new CuentaBanco();
    

    
    
    
public void run() {
    for (int i = 0; i <= 3; i++) {
        try {
            cb.HacerRetiro(10);
            Thread.sleep(1000);
            if(cb.getBalance() < 0){
                System.out.println("La cuenta está sobregirada.");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(VerificarCuenta.class.getName()).
            log(Level.SEVERE, null, ex); 
        }
   }
}
    
    
}
