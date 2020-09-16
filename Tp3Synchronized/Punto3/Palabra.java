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
public class Palabra {
    
    private String texto="";
    private int turno=1;
    private int cantidadHilos;
    
    public Palabra(int unCantidad){
        cantidadHilos=unCantidad;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public synchronized boolean gestorTurnos(Letra unLetra){
        boolean suTurno=false;
        /*Verifica si el turno del hilo es igual al turno del texto*/
        if(unLetra.getTurno()==turno){
            System.out.println("Es turno de hilo: "+ unLetra.getLetra());
            for (int i = 0; i < turno; i++) {
                /*Como las repeticiones de una letra en una oracion coincide con el 
                turno que le toca entoces lo repite las veces del turno*/
                suTurno=true;
                sumarLetras(unLetra.getLetra());//Suma la letra del hilo al texto
                System.out.println("Estado del texto: "+texto);
            }
            turno++;
            if(turno>cantidadHilos){ 
                //Si el turno nuevo sobrepaso la cantidad de hilos, lo reincia para una repiticion
               turno=1; 
            }
        }else{
            System.out.println("No es turno de hilo: "+unLetra.getLetra());
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                
            }
        }
        return suTurno;
    }
    
    private void sumarLetras(char letra){
            texto=texto+letra;
            
    }
    
}
