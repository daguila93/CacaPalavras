/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LocalizacaoLetra;
import Service.JsonService;
import java.util.List;

/**
 *
 * @author edil
 */
public final class BuscadorDePalavras {

    JsonService jsonService;
    Matriz matriz;

    public BuscadorDePalavras() {
        matriz = new Matriz();
        jsonService = new JsonService();
        mostrarMatriz();
        System.out.println("\n");
        palavraASerLocalizada();
    }

    private void palavraASerLocalizada() {
        for (int i = 0; i < jsonService.getPaises().size(); i++) {
            String palavraASerLocalizada = jsonService.getPaises().get(i);
            buscaPalavra(palavraASerLocalizada.toLowerCase());
        }
    }

    public void buscaPalavra(String palavraASerLocalizada) {
        encontrarPalavraEsquerdaParaDireita(palavraASerLocalizada);
        encontrarPalavraDireitaParaEsquerda(palavraASerLocalizada);
        encontrarPalavraCimaParaBaixo(palavraASerLocalizada);
        encontrarPalavraBaixoParaCima(palavraASerLocalizada);
        encontrarPalavraDiagonalPrincipal(palavraASerLocalizada);
        encontrarPalavraDiagonalPrincipalReversa(palavraASerLocalizada);
        encontrarPalavraDiagonalSecundaria(palavraASerLocalizada);
        encontrarPalavraDiagonalSecundariaReversa(palavraASerLocalizada);
    }

    // REFAZER ISSO PARA REAPROVEITAR CÓDIGO!!!
    private void encontrarPalavraEsquerdaParaDireita(String palavraASerLocalizada) {
        for (int i = 0; i < matriz.getTamanho(); i++) {
            List<LocalizacaoLetra> linha = matriz.getLinha(i);
            String result = converteArrayDeStringEmUmaUnicaString(linha);

            int index = -1;
            do { //indexof quando nao encontra retorna -1
                index = result.indexOf(palavraASerLocalizada, index + 1); // +1 pois quando localiza a letra, ele precisa testar na mesma string se tem mais resultados
                if (index != -1) {
                    LocalizacaoLetra localizacaoLetra = linha.get(index);
                    printarPalavra(localizacaoLetra, palavraASerLocalizada);
                }
            } while (index != -1);
        }
    }

    private void encontrarPalavraDireitaParaEsquerda(String palavraASerLocalizada) {
        String palavraReversa = new StringBuilder(palavraASerLocalizada).reverse().toString();
        encontrarPalavraEsquerdaParaDireita(palavraReversa);
    }

    // REFAZER ISSO PARA REAPROVEITAR CÓDIGO!!!
    private void encontrarPalavraCimaParaBaixo(String palavraASerLocalizada) {
        for (int j = 0; j < matriz.getTamanho(); j++) {
            List<LocalizacaoLetra> coluna = matriz.getColuna(j);
            String result = converteArrayDeStringEmUmaUnicaString(coluna);

            int index = -1;
            do {
                index = result.indexOf(palavraASerLocalizada, index + 1);
                if (index != -1) {
                    LocalizacaoLetra localizacaoLetra = coluna.get(index);
                    printarPalavra(localizacaoLetra, palavraASerLocalizada);
                }
            } while (index != -1);
        }
    }

    private void encontrarPalavraBaixoParaCima(String palavraASerLocalizada) {
        encontrarPalavraCimaParaBaixo(new StringBuilder(palavraASerLocalizada).reverse().toString());
    }

    // REFAZER ISSO PARA REAPROVEITAR CÓDIGO!!!
    private void encontrarPalavraDiagonalPrincipal(String palavraASerLocalizada) {
        List<LocalizacaoLetra> diagonalPricipal = matriz.getDiagonalPrincipal();
        String result = converteArrayDeStringEmUmaUnicaString(diagonalPricipal);

        int index = -1;
        do {
            index = result.indexOf(palavraASerLocalizada, index + 1);
            if (index != -1) {
                LocalizacaoLetra localizacaoLetra = diagonalPricipal.get(index);
                printarPalavra(localizacaoLetra, palavraASerLocalizada);
            }
        } while (index != -1);
    }

    private void encontrarPalavraDiagonalPrincipalReversa(String palavraASerLocalizada) {
        encontrarPalavraDiagonalPrincipal(new StringBuilder(palavraASerLocalizada).reverse().toString());
    }

    // REFAZER ISSO PARA REAPROVEITAR CÓDIGO!!!
    private void encontrarPalavraDiagonalSecundaria(String palavraASerLocalizada) {
        List<LocalizacaoLetra> diagonalSecundaria = matriz.getDiagonalSecundaria();
        String result = converteArrayDeStringEmUmaUnicaString(diagonalSecundaria);

        int index = -1;
        do {
            index = result.indexOf(palavraASerLocalizada, index++);
            if (index != -1) {
                LocalizacaoLetra localizacaoLetra = diagonalSecundaria.get(index);
                printarPalavra(localizacaoLetra, palavraASerLocalizada);
            }
        } while (index != -1);
    }

    private void encontrarPalavraDiagonalSecundariaReversa(String palavraASerLocalizada) {
        encontrarPalavraDiagonalSecundaria(new StringBuilder(palavraASerLocalizada).reverse().toString());
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

    private void printarPalavra(LocalizacaoLetra localizacaoLetra, String palavraASerLocalizada) {
        System.out.println(String.format("%s = [%s][%s]\n", palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
    }
}