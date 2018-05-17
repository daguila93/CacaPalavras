/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import CacaPalavras.CacaPalavras;
import Controller.BuscadorDePalavras;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author edil
 */
public class JsonService {

    BuscadorDePalavras leitorDePalavras;
    private List<String> paises;

    public JsonService() {
        lerArquivoJson();
    }

    private List<String> lerArquivoJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            paises = objectMapper.readValue(new FileReader(CacaPalavras.caminho), new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
        }
        return paises;
    }

    public void printarJson() {
        System.out.println(paises);
    }

    public List<String> getPaises() {
        return paises;
    }

}
