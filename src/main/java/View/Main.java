/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BuscadorDePalavras;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edil
 */
public class Main {

    /**
     */
    public static String caminho;
    public static Integer tamanhoMatriz = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuscadorDePalavras buscadorDePalavras;

        System.out.println("Digite o nome do Arquivo: \nExemplo: paises.json");
        String arquivo = sc.next();

        try {
            new FileReader(arquivo);
            System.out.println("Arquivo JSON carregado com Sucesso!\n");
            Main.caminho = arquivo;
            System.out.println("Digite o tamanho da Matriz: ");
            tamanhoMatriz = sc.nextInt();
            buscadorDePalavras = new BuscadorDePalavras();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Tente: paises.json");
            e.getMessage();
        } catch (InputMismatchException e) {
            System.out.println("Digite somente números Inteiros!");
            e.getMessage();
        }
        System.out.println();
    }
}
