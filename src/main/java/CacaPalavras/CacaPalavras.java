/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacaPalavras;

import Controler.BuscadorDePalavras;
import Service.JsonService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author edil
 */
public class CacaPalavras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JsonService jsonService = new JsonService();
        
        System.out.println("Digite o nome do Arquivo: ");
        String arquivo = sc.next();
        
        List<String> listaPaises = jsonService.lerArquivoJson(arquivo);
        System.out.println();
        
        BuscadorDePalavras leitorDePalavras = new BuscadorDePalavras();
        
        //jsonService.printarJson();
        leitorDePalavras.mostrarMatriz();
    }
}