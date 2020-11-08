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
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Letra implements Runnable {
    private char letra;
    private Turno turno;
    private int cantVeces;
    private Semaphore semAnterior;
    private Semaphore semEstaLetra;
    private Semaphore semSiguiente;
    
    
    public Letra( char unLetra, Turno unTurno,int unCantidad,Semaphore semaforoAnterior,Semaphore semaforoLetra,Semaphore semaforoSig){
        this.letra = unLetra;
        this.turno = unTurno;
        this.cantVeces = unCantidad;
        this.semAnterior = semaforoAnterior;
        this.semEstaLetra = semaforoLetra;
        this.semSiguiente = semaforoSig;
    }  

     
    public void run() {
        while(true) {
            try{
		//Pide imprimir
                turno.listoParaImprimir(semEstaLetra, semAnterior);
                for (int i = 0; i < cantVeces; i++) {
                    System.out.print(letra);
                }
                turno.terminarTurno(semEstaLetra, semSiguiente);
            }catch(InterruptedException ex){
                Logger.getLogger(Letra.class.getName()).
                log(Level.SEVERE, null, ex);  
            }
        }
    }
    
}
