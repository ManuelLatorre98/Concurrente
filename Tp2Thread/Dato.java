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
public class Dato {
    private int valor;

    public synchronized void contar() {
        valor = ++valor;
    }

    int obtener() {
        return valor;
    }


    
    public int getValor(){
        return this.valor;
    }


    
}
