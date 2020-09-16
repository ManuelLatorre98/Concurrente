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
public class SumaArreglo implements Runnable{
    private int id;
    private int[] arreglo;
    private int comienzo;
    private int terminacion;
    private SumaFinal resultadoFinal;

    public SumaArreglo(int unId,int[] unArreglo,int comienzo, int terminacion,SumaFinal unResultadoFinal) {
        int id=unId;
        this.comienzo = comienzo;
        this.terminacion = terminacion;
        this.arreglo=unArreglo;
        this.resultadoFinal = unResultadoFinal;
    }
    
    
    
    public void run(){
        int sumaParcial=0,j;
        for (int i = comienzo; i <= terminacion; i++) {
            j=arreglo[i];
            System.out.println("SumaParcial "+this.id+"se esta sumando:"+j);
            sumaParcial=sumaParcial+j;
            try{
                Thread.sleep(2000);
            }catch(InterruptedException ex){
                System.out.println("Hubo un error");
            }
            
        }
        resultadoFinal.sumarResultadoParcial(sumaParcial);
    }
    
    
}
