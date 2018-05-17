/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CacaPalavras.CacaPalavras;
import Model.LocalizacaoLetra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edil
 */
public class Matriz {

    private final Integer tamanho = CacaPalavras.tamanhoMatriz;
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
        int linha = 0;
        int coluna = 0;

        //Printar o número da Coluna da Matriz
        for (int i = 0; i < CacaPalavras.tamanhoMatriz; i++) {

            if (i == 0) {
                System.out.print("      " + i);
            } else if (i > 0 && i < 9) {
                System.out.print("    " + i);
            } else if (i == 9) {
                System.out.print("    " + i + " ");
            } else if (i > 9 && i < 99) {
                System.out.print("   " + i);
            } else if (i == 99) {
                System.out.print("   " + i + " ");
            } else if (i > 99 && i < 999) {
                System.out.print("  " + i);
            }

        }

        for (LocalizacaoLetra[] matrizLocalizacaoLetra1 : matrizLocalizacaoLetra) {
            System.out.println();
            for (LocalizacaoLetra matrizLocalizacaoLetra11 : matrizLocalizacaoLetra1) {

                //Serve para alinhar a Matriz com espaços ao lado do número da linha
                if (coluna == 0 && linha < 10) {
                    System.out.print("  " + linha + " ");
                } else if (coluna == 0 && linha > 9 && linha < 100) {
                    System.out.print(" " + linha + " ");
                } else if (coluna == 0 && linha > 99) {
                    System.out.print(linha + " ");
                }

                coluna += 1;
                System.out.printf(String.format("|_%s_|", matrizLocalizacaoLetra11.getLetra()));
                //System.out.printf(String.format("%s[%s %s] ", matrizLocalizacaoLetra[i][j].getLetra(), matrizLocalizacaoLetra[i][j].getLinha(), matrizLocalizacaoLetra[i][j].getColuna()));
            }
            linha += 1;
            coluna = 0;
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
