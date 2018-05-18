/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

/**
 *
 * @author edil
 */
public class Ascii {

    public String caractereASCIIAleatorio() {
        return randomAlphabetic(1).toLowerCase();
    }
}
