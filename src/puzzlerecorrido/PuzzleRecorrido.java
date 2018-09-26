/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlerecorrido;

import java.util.ArrayList;
import java.util.Arrays;
import static puzzlerecorrido.BusquedaAmplitud.imprimirEstado;

public class PuzzleRecorrido {

    public static void main(String[] args) {
        // TODO code application logic here
        int pasos = 0;
        int[][] pinicio = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};// Nodo problema
        int[][] pfinal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};// Nodo solucion
        //convetir arry a nodo
        Nodo inicial = new Nodo(pinicio);
        //llamo a metodo buscar solucion para comparar

        BusquedaAmplitud algoritmo = new BusquedaAmplitud();
        Nodo sol = algoritmo.buscarSolucion(inicial, pfinal);
        //recorro lista enlazada
        while (sol.getPadre() != null) {
            pasos++;
            imprimirEstado(sol.getEstado());
            System.out.println("---------------  numero de pasos : " + pasos);
            sol = sol.getPadre();

        }
    }

}
