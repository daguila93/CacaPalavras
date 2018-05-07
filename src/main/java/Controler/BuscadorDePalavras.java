/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.LocalizacaoLetra;
import java.util.List;

/**
 *
 * @author edil
 */
public class BuscadorDePalavras {

    Matriz matriz;
    String palavraASerLocalizada = "ma";
    String result = null;
    String[] array = null;

    public BuscadorDePalavras() {
        matriz = new Matriz();
        buscaPalavra();
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

    public void encontrarDireitaParaEsquerda() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarEsquerdaParaDireita(palavraReversa);
        
    }

    public void encontrarCimaParaBaixo(String palavraASerLocalizada) {
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

    public void encontrarBaixoParaCima() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarCimaParaBaixo(palavraReversa);
    }

    public void encontrarDiagonalPrincipal(String palavraASerLocalizada) {
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

    public void encontrarDiagonalPrincipalReversa() {
        StringBuilder stringBuilderReverso;
        String palavraReversa;
        
        StringBuilder sb = new StringBuilder(palavraASerLocalizada);
        stringBuilderReverso = sb.reverse();
        palavraReversa = stringBuilderReverso.toString();
        
        encontrarDiagonalPrincipal(palavraReversa);
        
    }

    public String encontrarEsquerdaInferiorParaDireitaSuperior() {
        return null;
    }

    public String encontrarDireitaSuperiorParaEsquerdaInferior() {
        return null;
    }

    private void buscaPalavra() {
        encontrarEsquerdaParaDireita(palavraASerLocalizada);
        encontrarDireitaParaEsquerda();
        encontrarCimaParaBaixo(palavraASerLocalizada);
        encontrarBaixoParaCima();
    }

    public void procuraAPalavraDoJsonNasPosicoesDaMatriz() {
//        if (result.contains(palavraASerLocalizada)) {
//            System.out.println(palavraASerLocalizada + " foi encontrada na Linha: "
//                    + matriz.getLinha(?) + " e Coluna: " + matriz.getColuna(?));
//        }
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