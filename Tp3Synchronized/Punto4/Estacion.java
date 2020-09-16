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
public class Estacion {
    
    public synchronized void cargarNafta(Auto unAuto){
        unAuto.setKmRecorridos(0);
        System.out.println("ESTA CARGANDO NAFTA: "+unAuto.getPatente());
        try{
                Thread.sleep(2000);
            }catch(InterruptedException ex){
                System.out.println("Hubo error");
        }
    }
    
}
