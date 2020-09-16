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
import java.util.Random;

public class Main6 {
    
    public static void main(String[] args) {
        String resultado="[";
        int[] arreglo = new int[20];
        int j;
        for (int i = 0; i < 20; i++) {
            j=(int)(Math.random()*10);
            arreglo[i]=j;
            resultado+=j+",";
        }
        resultado+="]";
        System.out.println("El arreglo quedo: "+resultado);
        SumaFinal sumFinal = new SumaFinal();
        SumaArreglo sum1= new SumaArreglo(1,arreglo,0,4,sumFinal);
        SumaArreglo sum2= new SumaArreglo(2,arreglo,5,9,sumFinal);
        SumaArreglo sum3= new SumaArreglo(3,arreglo,10,14,sumFinal);
        SumaArreglo sum4= new SumaArreglo(4,arreglo,15,19,sumFinal);
        
        Thread suma1=new Thread(sum1);
        Thread suma2=new Thread(sum2);
        Thread suma3=new Thread(sum3);
        Thread suma4=new Thread(sum4);
        
        suma1.start();
        suma2.start();
        suma3.start();
        suma4.start();
        
        System.out.println("El resultado final es: "+sumFinal.getSumaFinal());
        
    }
    
    
}
