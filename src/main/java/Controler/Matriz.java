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
    
    private Integer tamanho = 50;
    LocalizacaoLetra[][] matrizLocalizacaoLetra;
    private String[] todosElementosDeUmaDalinhaDaMatriz;
    private String[] todosElementosDeUmaColunaDaMatriz;
    
    public Matriz() {
     matrizLocalizacaoLetra = preencherMatriz(new LocalizacaoLetra[tamanho][tamanho]);
    }
    
    private LocalizacaoLetra[][] preencherMatriz(LocalizacaoLetra[][] matriz) {
        Ascii objetoCaractere = new Ascii();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                LocalizacaoLetra localizacaoLetra = new LocalizacaoLetra();
                localizacaoLetra.setLinha(i);
                localizacaoLetra.setColuna(j);
                localizacaoLetra.setLetra(objetoCaractere.caracterASCIIAleatorio());
                
                matriz[i][j] = localizacaoLetra;
            }
        }
        return matriz;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < matrizLocalizacaoLetra.length; i++) {
            System.out.println();
            for (int j = 0; j < matrizLocalizacaoLetra[i].length; j++) {
                System.out.print(matrizLocalizacaoLetra[i][j].getLetra() + " ");
            }
        }
    }
    
    public String[] preencheOArrayDeLinhasDaMatriz(){
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho(); j++) {
                todosElementosDeUmaDalinhaDaMatriz[i] = matrizLocalizacaoLetra[i][j].getLetra();
            }
        }
        return todosElementosDeUmaDalinhaDaMatriz;
    }
    
    // getLinha(indice da linha)               Feito
    // getColuna(indice da coluna)             Fazer
    // getDiagonal(boolean diagonalReversa?)   Fazer

    
    public Integer getTamanho() {
        return tamanho;
    }
}
