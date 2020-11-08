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
public class MainConfiteria {
    
    public static void main(String[] args) {
        
       Confiteria confiteria = new Confiteria();
       
       Mozo unMozo = new Mozo(confiteria);
       
       EmpleadoConfiteria unEmpleado1 = new EmpleadoConfiteria(confiteria);
       EmpleadoConfiteria unEmpleado2 = new EmpleadoConfiteria(confiteria);
       
       Thread mozo = new Thread(unMozo);
       Thread empleado1 = new Thread(unEmpleado1,"EMPLEADO1");
       Thread empleado2 = new Thread(unEmpleado2,"EMPLEADO2");
       
       mozo.start();
       empleado1.start();
       empleado2.start();
    }
    
    
}
