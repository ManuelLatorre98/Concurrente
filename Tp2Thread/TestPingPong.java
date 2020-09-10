/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp3;

/**
 *
 * @author repetto.francisco
 */
public class TestPingPong {
    public static void main(String[] args) {
        PingPong o1=new PingPong("PING",200);
        PingPong o2=new PingPong("PONG",200);
        PingPong o3=new PingPong("PANG",200);
        PingPong o4=new PingPong("PUNG",200);
        PingPong o5=new PingPong("PUNG",200);
        PingPong o6=new PingPong("PUNGULU",200);
        PingPong o7=new PingPong("PUNGULU",200);

        Thread t1=new Thread(o1);
        Thread t2=new Thread(o2);
        Thread t3=new Thread(o3);
        Thread t4=new Thread(o4);
        Thread t5=new Thread(o5);
        Thread t6=new Thread(o6);
        Thread t7=new Thread(o7);
        
        
        //ACTIVACION
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        
        //Espera unos segundos 
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            
        }
        
    }
    
  /*  public static void hacer(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Estoy en el main");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
        }
    }*/
}
