/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlerecorrido;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class BusquedaAmplitud {

    public static Nodo buscarSolucion(Nodo inicio, int[][] pfinal) {
        //buscamos operaciones necesrias
        int cont = 0;
        //alogritmo para encntrar la solucion
        // expandidos guarda todos los nodos que se van genrerando a lo largo del arbol
        ArrayList<Nodo> expandidos = new ArrayList<Nodo>();
        ArrayList<Nodo> visitados = new ArrayList<Nodo>();
        expandidos.add(inicio);

        //busca en todos los puntos expandidos hasta que sea cero
        while (expandidos.size() != 0) {
            //luego de revisado sale del ciclo
            Nodo revisar = expandidos.remove(0);
            visitados.add(revisar);
            imprimirEstado(revisar.getEstado());
            System.out.println("Iteracion N:" + (++cont));
            if (Arrays.deepEquals(revisar.getEstado(), pfinal)) {
                System.out.println("**solucion encontrada");
                return revisar;
            }
            //logica del algotirmo
            agregarhijos(revisar, expandidos, visitados);//esta line hace todo crea hijos, tratamiento de hijos, le asigna padre y agrega los hijos a la lista de abiertos o extendidos
            
            
        }//FINAL WHILE
        return null;

    }

    /*  //pasamos nodo inicio y creamos int pfinal
    public static Nodo buscarSolucion(Nodo inicio, int[][] pfinal) {
       
    }*/
    public static ArrayList<Nodo> crearhijos(Nodo Padre) {
        ArrayList<Nodo> hijoscreados = new ArrayList<Nodo>();
        Problema p = new Problema();
        hijoscreados.add(p.move_abajo(Padre));
        hijoscreados.add(p.move_arriba(Padre));
        hijoscreados.add(p.move_derecha(Padre));
        hijoscreados.add(p.move_izquierda(Padre));
        
       

        return hijoscreados;
    }

    public static void agregarhijos(Nodo Padre, ArrayList<Nodo> abiertos, ArrayList<Nodo> visitados) {
        ArrayList<Nodo> posibleshijos = new ArrayList<>(crearhijos(Padre));
        for (Nodo hijo : posibleshijos) {
            if (estaVisitados(visitados, hijo)) {
                //si esta en visitados no lo agregue
            } else {//si no esta en visitados agreguelo

                abiertos.add(hijo);
                hijo.setPadre(Padre);//acada hijo se le da su padre solo si es aceptado en la lsita de abiertos
            }
        }

    }

    private static boolean estaVisitados(ArrayList<Nodo> visitados, Nodo hijoposible) {
        for (Nodo v : visitados) {

            if (Arrays.deepEquals(v.getEstado(), hijoposible.getEstado())) {

                return true;

            }
        }
        return false;
    }

    public static void imprimirEstado(int[][] estado) {

        System.out.println("Nodo");
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {

                System.out.print("[" + estado[i][j] + "]");
            }
            System.out.println("");
        }

    }

}//fin busquedaAmplitud

