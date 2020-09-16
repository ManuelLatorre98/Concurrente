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
public class Orco extends Personaje  implements Runnable {


    public Orco(Vida unVida) {
        super(unVida);

    }

    public void run(){
        try{
            vid.operar(-3);
        }catch(InterruptedException e){
            System.out.println("Hubo un error");
        }
    }
    
}
