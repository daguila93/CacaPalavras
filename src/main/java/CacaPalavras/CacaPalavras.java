/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacaPalavras;

import Controler.LeitorDePalavras;
import Service.JsonService;
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
        LeitorDePalavras leitorDePalavras = new LeitorDePalavras();
        
        System.out.println("Digite o nome do Arquivo: ");
        String arquivo = sc.next();
        
        jsonService.lerArquivoJson(arquivo);
        System.out.println("\n");
        
        //jsonService.printarJson();        
        leitorDePalavras.mostrarMatriz();
    }
}
    
