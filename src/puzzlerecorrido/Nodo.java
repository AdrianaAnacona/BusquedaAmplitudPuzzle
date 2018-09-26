/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlerecorrido;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Nodo {
   private int [][] estado;// es la matriz 3*3
   private Nodo padre;

    public Nodo(int[][] estado) {
        this.estado = estado;
        padre = null;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }


    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    
    
}
