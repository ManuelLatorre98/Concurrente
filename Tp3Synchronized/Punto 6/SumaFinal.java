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
public class SumaFinal {
    private int sumaFinal;
   

    public SumaFinal() {
        this.sumaFinal = 0;
    }
    
    public synchronized void sumarResultadoParcial(int resultadoParcial){
        System.out.println("ESTA SUMANDO AL RESULTADO FINAL LA SUMA: "+Thread.currentThread().getName()
        +" LE SUMA: "+resultadoParcial);
        this.sumaFinal = this.sumaFinal+resultadoParcial;
         try{
                Thread.sleep(2000);
            }catch(InterruptedException ex){
                System.out.println("Hubo un error");
            }
    }
    
    public synchronized int getSumaFinal(){
        return this.sumaFinal;
    }
    
}
