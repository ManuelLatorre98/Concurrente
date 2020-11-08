/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp5.SemaforosGenelares;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repetto.francisco
 */
public class VendedorTicket implements Runnable {
    private Tren tren;

    public VendedorTicket(Tren tren) {
        this.tren = tren;
    }

    public synchronized void run() {
        while (true) {
            try {
                System.out.println("VENDEDOR: esperando para vender");
                tren.vendendiendo();
                System.out.println("VENDEDOR: vendio todos los pasajes");
                tren.avisarVendioTodo();
                tren.esperarQueVuelva();
            } catch (InterruptedException ex) {
                Logger.getLogger(VendedorTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
