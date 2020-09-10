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
public class ProbandoCajera { 
    public static void main(String[] args) {
        ClienteSupermecado cliente1 = new ClienteSupermecado("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        ClienteSupermecado cliente2 = new ClienteSupermecado("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
        Cajera cajera1 = new Cajera("Cajera 1");
        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajera1.procesarCompra(cliente1, initialTime);
        cajera1.procesarCompra(cliente2, initialTime);
    }
}
   

