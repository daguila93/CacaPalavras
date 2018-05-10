/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.LocalizacaoLetra;
import Service.JsonService;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edil
 */
public class BuscadorDePalavras {
    JsonService jsonService;
    Matriz matriz;
    String palavraASerLocalizada;
    String result = null;
    String[] array = null;

    public BuscadorDePalavras() {
        matriz = new Matriz();
        jsonService = new JsonService();
        mostrarMatriz();
        System.out.println();
        palavraAtual();
    }
    
    private void palavraAtual(){
        List<String> palavra = new ArrayList<>();
             palavra = jsonService.getPaises();
        for (int i = 0; i < palavra.size(); i++) {
            palavraASerLocalizada = palavra.get(i);
            buscaPalavra(palavraASerLocalizada.toLowerCase());
        }               
    }

    private void encontrarEsquerdaParaDireita(String palavraASerLocalizada) {
        for (int i = 0; i < matriz.getTamanho(); i++) {
            List<LocalizacaoLetra> linha = matriz.getLinha(i);
            result = converteArrayDeStringEmUmaUnicaString(linha);
            
            int index = -1;
            do { //indexof quando nao encontra retorna -1
                index = result.indexOf(palavraASerLocalizada, index + 1); // +1 pois quando localiza a letra, ele precisa testar na mesma string se tem mais resultados
                if (index != -1) {
                    LocalizacaoLetra localizacaoLetra = linha.get(index);
                    System.out.println(String.format("%s = [%s][%s]", this.palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
                }
            } while (index != -1);
        }
    }

    private void encontrarDireitaParaEsquerda() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarEsquerdaParaDireita(palavraReversa);
        
    }

    private void encontrarCimaParaBaixo(String palavraASerLocalizada) {
        for (int j = 0; j < matriz.getTamanho(); j++) {
            List<LocalizacaoLetra> coluna = matriz.getColuna(j);
            result = converteArrayDeStringEmUmaUnicaString(coluna);
            
            int index = -1;
            do {                
                index = result.indexOf(palavraASerLocalizada, index + 1);
                if (index != -1) {
                    LocalizacaoLetra localizacaoLetra = coluna.get(index);
                    System.out.println(String.format("%s = [%s][%s]", this.palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
                }
            } while (index != -1);
        }
    }

    private void encontrarBaixoParaCima() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarCimaParaBaixo(palavraReversa);
    }

    private void encontrarDiagonalPrincipal(String palavraASerLocalizada) {
        List<LocalizacaoLetra> diagonalPricipal = matriz.getDiagonalPrincipal();
        result = converteArrayDeStringEmUmaUnicaString(diagonalPricipal);
        
        int index = -1;
        do {            
            index = result.indexOf(palavraASerLocalizada, index + 1);
            if (index != -1) {
                LocalizacaoLetra localizacaoLetra = diagonalPricipal.get(index);
                System.out.println(String.format("%s = [%s][%s]", this.palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
            }
        } while (index != -1);
    }

    private void encontrarDiagonalPrincipalReversa() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarDiagonalPrincipal(palavraReversa);
        
    }

    private void encontrarDiagonalSecundaria(String palavraASerLocalizada) {
        List<LocalizacaoLetra> diagonalSecundaria = matriz.getDiagonalSecundaria();
        result = converteArrayDeStringEmUmaUnicaString(diagonalSecundaria);
        
        int index = -1;
        do {            
            index = result.indexOf(palavraASerLocalizada, index +1);
            if (index != -1) {
                LocalizacaoLetra localizacaoLetra = diagonalSecundaria.get(index);
                System.out.println(String.format("%s = [%s][%s]", this.palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
            }
        } while (true);
    }

    private void encontrarDiagonalSecundariaReversa() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarDiagonalSecundaria(palavraReversa);
    }

    public void buscaPalavra(String palavraASerLocalizada) {
        encontrarEsquerdaParaDireita(palavraASerLocalizada);
        encontrarDireitaParaEsquerda();
        encontrarCimaParaBaixo(palavraASerLocalizada);
        encontrarBaixoParaCima();
        encontrarDiagonalPrincipal(palavraASerLocalizada);
        encontrarDiagonalPrincipalReversa();
        encontrarDiagonalSecundaria(palavraASerLocalizada);
        encontrarDiagonalSecundariaReversa();
    }

    public void mostrarMatriz() {
        matriz.mostrarMatriz();
    }

    private String converteArrayDeStringEmUmaUnicaString(List<LocalizacaoLetra> letras) {
        StringBuilder sb = new StringBuilder();
        for (LocalizacaoLetra letra : letras) {
            sb.append(letra.getLetra());
        }
        return sb.toString();
    }
}