/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural.model;

import java.util.ArrayList;

/**
 *
 * @author aflemes
 */
public class Perceptron {
    private int classe;
    private ArrayList<Double> neuronioEntrada;
    private ArrayList<Double> neuronioOculto;
    private ArrayList<Double> neuronioSaida;

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public ArrayList<Double> getNeuronioEntrada() {
        return neuronioEntrada;
    }

    public void setNeuronioEntrada(ArrayList<Double> neuronioEntrada) {
        this.neuronioEntrada = neuronioEntrada;
    }

    public ArrayList<Double> getNeuronioOculto() {
        return neuronioOculto;
    }

    public void setNeuronioOculto(ArrayList<Double> neuronioOculto) {
        this.neuronioOculto = neuronioOculto;
    }

    public ArrayList<Double> getNeuronioSaida() {
        return neuronioSaida;
    }

    public void setNeuronioSaida(ArrayList<Double> neuronioSaida) {
        this.neuronioSaida = neuronioSaida;
    }
    
    public void processar(){
        
    }
    
    
    
}
