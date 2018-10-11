/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural.model;

import java.util.Random;

/**
 *
 * @author aflemes
 */
public class Neuronio {
    private Double entrada;
    private Double saida;
    private Double peso;
    private Double erro;

    public Neuronio(){
        Random numero = new Random();
        
        this.setEntrada(0.0);
        this.setSaida(0.0);
        this.setPeso(numero.nextDouble());
        this.setErro(0.0);
    }
    
    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getSaida() {
        return saida;
    }

    public void setSaida(Double saida) {
        this.saida = saida;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }    

    public Double getErro() {
        return erro;
    }

    public void setErro(Double erro) {
        this.erro = erro;
    }
}
