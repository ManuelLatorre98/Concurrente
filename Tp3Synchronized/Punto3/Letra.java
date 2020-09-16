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
public class Letra implements Runnable {
    
    private char letra;
    private int turno;
    private Palabra texto;
    private int repeticiones;
    
    public Letra(char unLetra, int unTurno,int unRepeticiones,Palabra unTexto){
        letra=unLetra;
        turno=unTurno;
        repeticiones=unRepeticiones;//Cantidad de repeticiones que tiene que hacer en el texto
        texto=unTexto;
    }
    
    public void run(){
        int i=1;
        boolean miTurno=false;
        while(i<=repeticiones){
            try{
                miTurno=texto.gestorTurnos(this);
                Thread.sleep(3000);
                if(miTurno)//Si pudo acceder al lock
                    i++;
            }catch(InterruptedException ex){
                System.out.println("Hubo error");
            }
            
        }
  
    }

    public char getLetra() {
        return letra;
    }

    public int getTurno() {
        return turno;
    }
    
    
    
    
}
