/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.util.Random;

/**
 *
 * @author edil
 */
public class Ascii {

    public final char caracterASCIIAleatorio() {
        
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        char[] vetor = new char[26];
        for (int i = 1; i < alphabet.length(); i++) {
            vetor[i] = (char) i;
        }
        return alphabet.charAt(random.nextInt(alphabet.length()));
    }
}
