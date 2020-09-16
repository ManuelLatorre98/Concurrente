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
public class Main4 {
    
    public static void main(String[] args) {
        int i=2;
        Palabra texto=new Palabra(3);
        
        Letra a=new Letra('A',1,i,texto);
        Letra b=new Letra('B',2,i,texto);
        Letra c=new Letra('C',3,i,texto);
        
        Thread h1=new Thread(a);
        Thread h2=new Thread(b);
        Thread h3=new Thread(c);
        
        h1.start();
        h2.start();
        h3.start();
    }
    
}
