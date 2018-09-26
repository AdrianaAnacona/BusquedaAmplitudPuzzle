/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlerecorrido;

/**
 *
 * @author User
 */
public class Problema {

    //creacion de hijos
    public static Nodo move_arriba(Nodo padre) {
        
        
        int[] pCero = new int [2];pCero = ubicarPosicionCero(padre.getEstado());
        Nodo hijo = new Nodo(clonar(padre.getEstado()));
        if (pCero[0] != 0){
            int arriba = hijo.getEstado()[pCero[0] - 1][pCero[1]];
            hijo.getEstado()[pCero[0]][pCero[1]] = arriba;
            hijo.getEstado()[pCero[0] - 1][pCero[1]] = 0;

        }

        return hijo;
    }//final arriba

    public static Nodo move_abajo(Nodo padre) {
       int[] pCero = new int [2];pCero = ubicarPosicionCero(padre.getEstado());
        Nodo hijo = new Nodo(clonar(padre.getEstado()));
        if (pCero[0] != 2) {

            //modificado
            int abajo = hijo.getEstado()[pCero[0] + 1][pCero[1]];
            hijo.getEstado()[pCero[0]][pCero[1]] = abajo;
            hijo.getEstado()[pCero[0] + 1][pCero[1]] = 0;

        }//abajo
        return hijo;
    }//final abajo

    public static Nodo move_derecha(Nodo padre) {
        int[] pCero = new int [2];
        pCero = ubicarPosicionCero(padre.getEstado());
        Nodo hijo = new Nodo(clonar(padre.getEstado()));
        if (pCero[1] != 2) {

            //modificado
            int derecha = hijo.getEstado()[pCero[0]][pCero[1] + 1];
            hijo.getEstado()[pCero[0]][pCero[1]] = derecha;
            hijo.getEstado()[pCero[0]][pCero[1] + 1] = 0;

        }

        return hijo;
    }//final derecha

    public static Nodo move_izquierda(Nodo padre) {
        int[] pCero = new int [2];
        pCero = ubicarPosicionCero(padre.getEstado());
        Nodo hijo = new Nodo(clonar(padre.getEstado()));

        if (pCero[1] != 0) {

            int izquierda = hijo.getEstado()[pCero[0]][pCero[1] - 1];
            hijo.getEstado()[pCero[0]][pCero[1]] = izquierda;
            hijo.getEstado()[pCero[0]][pCero[1] - 1] = 0;

        }
        return hijo;
    }//final izquierda

    private static int[][] clonar(int[][] estado) {
        int[][] clon = new int[estado.length][estado.length];
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {

                clon[i][j] = estado[i][j];
            }

        }
        return clon;
    }//fin clon

    private static int[] ubicarPosicionCero(int[][] estado) {

        int[] posicion = new int[2]; //para guardar la poscion i j 
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado.length; j++) {

                if (estado[i][j] == 0) {
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }

        }
       // System.out.println("la poscion del espacio es: " + posicion[0] + "," + posicion[1]);
        return posicion; //devuelvo poscion como un array i j 
    }//fin ubicacion del cero

}// FIN CLASE PROBLEMA
