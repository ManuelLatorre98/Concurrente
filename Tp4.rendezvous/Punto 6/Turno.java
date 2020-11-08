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

public class Turno {
    
   
    public Turno(char[] arreglo){
        
    }
	
    public void Imprimir(char letra, int cantVeces){
         for (int i = 0; i < cantVeces; i++) {
             System.out.print(letra);
            }
    }
    
    public void listoParaImprimir(Semaphore semEstaLetra,Semaphore semAnterior) throws InterruptedException{
        semAnterior.acquire();//Espera a que termine la letra anterior de imprimir
        semEstaLetra.acquire();//Espera hasta que tenga que su semaforo tenga permiso
    }
    
    public void terminarTurno(Semaphore semEstaLetra,Semaphore semSiguiente){
        semEstaLetra.release();//Termino de imprimir
        semSiguiente.release();//Libera el semaforo siguiente
    }
    
}
