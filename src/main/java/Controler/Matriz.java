/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/**
 *
 * @author edil
 */
public class Matriz {

    Ascii ascii = new Ascii();

    public char[][] criarMatriz() {
        char matriz[][] = new char[50][50];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ascii.caracterASCIIAleatorio();
                System.out.print(matriz[i][j] + " ");
            }
        }
        return matriz;
    }
}
