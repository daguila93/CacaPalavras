/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.LocalizacaoLetra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edil
 */
public class Matriz {
    
    private Integer tamanho = 50;
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
    
    public List<LocalizacaoLetra> getLinha(Integer posicaoDaLinha){
        List<LocalizacaoLetra> linha = new ArrayList<>();        
        for (int j = 0; j < getTamanho(); j++) {
            linha.add(matrizLocalizacaoLetra[posicaoDaLinha][j]);
        }        
        return linha;
        //retorna a linha da matriz com os elementos dentro.
    }
    
    public LocalizacaoLetra[] getColuna(Integer posicaoDaColuna){
        LocalizacaoLetra[] colunas = new LocalizacaoLetra[getTamanho()];
        for (int i = 0; i < getTamanho(); i++) {
            colunas[i] = matrizLocalizacaoLetra[i][posicaoDaColuna];
        }        
        return colunas;
        //retorna a coluna da matriz com os elementos dentro.
    }
    
    public LocalizacaoLetra[] getDiagonalPrincipal(){
        LocalizacaoLetra[] diagonalPrincipal = new LocalizacaoLetra[getTamanho()];
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho(); j++) {
                if (i == j) {
                    diagonalPrincipal[j] = matrizLocalizacaoLetra[i][j];
                }            
            }
        }
        return diagonalPrincipal;
    }
    
    public LocalizacaoLetra[] getDiagonalSecundaria(){
        LocalizacaoLetra[] diagonalSecundaria = new LocalizacaoLetra[getTamanho()];
        for (int i = 0; i < getTamanho(); i++) {
            for (int j = 0; j < getTamanho(); j++) {
               //Implementar lógica da Diagonal Secundária
            }
        }
        return diagonalSecundaria;
    }
    
    // getLinha(indice da linha)               Feito
    // getColuna(indice da coluna)             Feito
    // getDiagonal(boolean diagonalReversa?)   Fazer
    
    public Integer getTamanho() {
        return tamanho;
    }
}