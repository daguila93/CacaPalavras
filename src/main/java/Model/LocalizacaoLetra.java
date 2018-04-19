/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controler.Matriz;

/**
 *
 * @author edil
 */
public class LocalizacaoLetra {
    
    Matriz matriz = new Matriz();
    
    private String letra = matriz.getLetra();
    private Integer linha = matriz.getLinha();
    private Integer coluna = matriz.getColuna();

    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    
    
}
