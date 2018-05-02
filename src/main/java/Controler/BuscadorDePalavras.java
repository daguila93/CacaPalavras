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
    String palavraASerLocalizada = "a";
    String result = null;
    String[] array = null;

    public BuscadorDePalavras() {
        matriz = new Matriz();
        executorDeMétodos();
    }

    private void encontrarEsquerdaParaDireita() {
        for (int i = 0; i < matriz.getTamanho(); i++) {
            List<LocalizacaoLetra> linha = matriz.getLinha(i);
            result = converteArrayDeStringEmUmaUnicaString(linha);
            
            int index = -1;
            do { //indexof quando nao encontra retorna -1
                index = result.indexOf(palavraASerLocalizada, index + 1); // +1 pois quando localiza a letra, ele precisa testar na mesma string se tem mais resultados
                if (index != -1) {
                    LocalizacaoLetra localizacaoLetra = linha.get(index);
                    System.out.println(String.format("%s = [%s][%s]", palavraASerLocalizada, localizacaoLetra.getLinha(), localizacaoLetra.getColuna()));
                }
            } while (index != -1);
        }
    }

    public String encontrarDireitaParaEsquerda() {
        for (int i = 0; i < matriz.getTamanho(); i++) {
            matriz.getLinha(i);
        }
        return null;
    }

    public String encontrarCimaParaBaixo() {
        return null;
    }

    public String encontrarBaixoParaCima() {
        return null;
    }

    public String encontrarEsquerdaSuperiorParaDireitaInferior() {
        return null;
    }

    public String encontrarDireitaInferiorParaEsquerdaSuperior() {
        return null;
    }

    public String encontrarEsquerdaInferiorParaDireitaSuperior() {
        return null;
    }

    public String encontrarDireitaSuperiorParaEsquerdaInferior() {
        return null;
    }

    private void executorDeMétodos() {
        encontrarEsquerdaParaDireita();
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
