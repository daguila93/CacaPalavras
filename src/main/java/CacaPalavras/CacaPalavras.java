/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacaPalavras;

import Controler.BuscadorDePalavras;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author edil
 */
public class CacaPalavras {

    /**
     * @param args the command line arguments
     */
    public static String caminho;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuscadorDePalavras buscadorDePalavras;

        System.out.println("Digite o nome do Arquivo: ");
        String arquivo = sc.next();

        try {
            new FileReader(arquivo);
            System.out.println("Arquivo JSON carregado com Sucesso!");
            CacaPalavras.caminho = arquivo;
            buscadorDePalavras = new BuscadorDePalavras();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Tente: paises.json");
        }

        System.out.println();        
    }
}