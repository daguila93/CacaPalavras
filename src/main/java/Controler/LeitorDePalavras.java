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
public class LeitorDePalavras {

    Matriz matriz;
    String palavraASerLocalizada = "ad";
    String result = null;
    String[] array = null;
    
    public LeitorDePalavras() {
        matriz = new Matriz();
    }

    public String encontrarEsquerdaParaDireita() {
        for (int i = 0; i < matriz.tamanho; i++) {
            for (int j = 0; j < matriz.tamanho; j++) {
                if (matriz.getLinha() == i && matriz.getColuna() == j) {
                    array[j] = matriz.getLetra();
                }
            }
        }
        return result = converteArrayDeStringEmUmaUnicaString(array);
    }
    
    public String encontrarDireitaParaEsquerda(){
        return null;
    }
    
    public String encontrarCimaParaBaixo(){
        return null;
    }
    
    public String encontrarBaixoParaCima(){
        return null;
    }
    
    public String encontrarEsquerdaSuperiorParaDireitaInferior(){
        return null;
    }
    
    public String encontrarDireitaInferiorParaEsquerdaSuperior(){
        return null;
    }
    
    public String encontrarEsquerdaInferiorParaDireitaSuperior(){
        return null;
    }
  
    public String encontrarDireitaSuperiorParaEsquerdaInferior() {
        return null;
    }

    private String converteArrayDeStringEmUmaUnicaString(String[] array){
        for (int i = 0; i < array.length; i++) {
            result += array;
        }
        return result;
    }
     
    public void procuraAPalavraDoJsonNasPosicoesDaMatriz(){
        if (result.contains(palavraASerLocalizada)) {
            System.out.println(palavraASerLocalizada + " foi encontrada na Linha: "
                    + matriz.getLinha() + " e Coluna: " + matriz.getColuna());
        }
    }

    public void mostrarMatriz() {
        matriz.mostrarMatriz();
    }
}
