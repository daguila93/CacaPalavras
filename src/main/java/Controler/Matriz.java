/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.LocalizacaoLetra;

/**
 *
 * @author edil
 */
public class Matriz {
    
    LocalizacaoLetra[][] matriz = new LocalizacaoLetra[50][50];    
    private String letra;
    private Integer linha;
    private Integer coluna;
    
    public Matriz() {
     matriz = criarMatriz();
    }
    
    public LocalizacaoLetra[][] criarMatriz() {

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz[i].length; j++) {
                Ascii objetoCaractere = new Ascii();
                LocalizacaoLetra localizacaoLetra = new LocalizacaoLetra();
                localizacaoLetra.setLinha(i);
                localizacaoLetra.setColuna(j);
                localizacaoLetra.setLetra(objetoCaractere.CaractereASCIIString());
                
                matriz[i][j] = localizacaoLetra;                
                System.out.print(matriz[i][j].getLetra() + " ");// ou use matriz[i][j].toString()
            }
        }
        return matriz;
    }
    
//    public void mostrarMatriz(){
//        for (int i = 0; i < matriz.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print(matriz[i][j].getLetra() + " ");
//            }
//        }
//    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }
    
}
