/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
        List<String> paises = null;
    
    public List<String> lerArquivoJson(String arquivo) {
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        paises = objectMapper.readValue(new FileReader(arquivo), new TypeReference<List<String>>() {});
            System.out.println("Json carregado com Sucesso!");
        } catch (IOException e) {
            System.out.println("Não foi possivel encontrar o arquivo. Tente: paises.json ");
        }
        return paises;
    }
    
    public void printarJson(){
        System.out.println(paises);
    }

}
