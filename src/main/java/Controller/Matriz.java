/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LocalizacaoLetra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edil
 */
public class Matriz {

    private Integer tamanho = 500;
    LocalizacaoLetra[][] matrizLocalizacaoLetra;

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

    public List<LocalizacaoLetra> getLinha(Integer posicaoDaLinha) {
        List<LocalizacaoLetra> linha = new ArrayList<>();
        for (int j = 0; j < getTamanho(); j++) {
            linha.add(matrizLocalizacaoLetra[posicaoDaLinha][j]);
        }
        return linha;
        //retorna a linha da matriz com os elementos dentro.
    }

    public List<LocalizacaoLetra> getColuna(Integer posicaoDaColuna) {
        List<LocalizacaoLetra> coluna = new ArrayList<>();
        for (int i = 0; i < getTamanho(); i++) {
            coluna.add(matrizLocalizacaoLetra[i][posicaoDaColuna]);
        }
        return coluna;
        //retorna a coluna da matriz com os elementos dentro.
    }

    public List<LocalizacaoLetra> getDiagonalPrincipal() {
        List<LocalizacaoLetra> diagonalPrincipal = new ArrayList<>();
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho(); j++) {
                if (i == j) {
                    diagonalPrincipal.add(matrizLocalizacaoLetra[i][j]);
                }
            }
        }
        return diagonalPrincipal;
    }

    public List<LocalizacaoLetra> getDiagonalSecundaria() {
        List<LocalizacaoLetra> diagonalSecundaria = new ArrayList<>();
        int coluna = getTamanho() - 1;
        for (int linha = 0; linha < getTamanho(); linha++) {
            diagonalSecundaria.add(matrizLocalizacaoLetra[linha][coluna]);
            if (coluna == 0) {
                break;
            }
            coluna--;
        }

        return diagonalSecundaria;
    }

    public Integer getTamanho() {
        return tamanho;
    }
}
