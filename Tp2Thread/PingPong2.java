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
public class PingPong2 extends Thread {
    
    private int delay;            //info de las iteraciones
    private Dato miD;          // para mantener el total
    private int miCta = 0;    // para contar mis iteraciones

// constructor 1, que refina al constructor heredado de Thread
    public PingPong2(String cartel, int cantMs) {
        super(cartel);
        this.delay = cantMs;
    }

// constructor 2, que utiliza al constructor 1
    public PingPong2(String cartel, int cantMs, Dato dd) {
        this(cartel, cantMs);
        this.miD = dd;
    }

    public void run() {

        for (int i = 1; i < delay * 2; i++) {
// System.out.print(this.getName() + " ");
            miCta++;
            this.miD.contar();

        } // del for
        System.out.println(miCta + " veces " + this.getName());

    } // del run

    public static void main(String[] args) {

        Dato cuenta = new Dato();
        PingPong2 t1 = new PingPong2("PING", (int) (Math.random() * 2300), cuenta);
        PingPong2 t2 = new PingPong2("PONG", (int) (Math.random() * 2000), cuenta);

        t1.start();
        t2.start();


        System.out.println(Thread.currentThread() + " chau-chau.adios");
        System.out.println(" dato " + cuenta.obtener());

    }
}
