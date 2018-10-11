/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural.model;

import static java.lang.Math.exp;
import java.util.ArrayList;

/**
 *
 * @author aflemes
 */
public class Perceptron {
    private int classe;
    private ArrayList<Neuronio> neuronioEntrada;
    private ArrayList<Neuronio> neuronioOculto;
    private ArrayList<Neuronio> neuronioSaida;
    private Double erroAceitavel;
    private double taxaAprendizagem;

    public int getClasse() {
        return classe;
    }
    
    public Perceptron(){
        setErroAceitavel(0.15);
        initPerceptron();
        initNeuronioOculto();
        initNeuronioSaida();
    }

    private void initPerceptron(){
        this.setErroAceitavel(0.15);
        this.setTaxaAprendizagem(0.5);
    }
    
    public void setClasse(int classe) {
        this.classe = classe;
    }

    public ArrayList<Neuronio> getNeuronioEntrada() {
        return neuronioEntrada;
    }

    public void setNeuronioEntrada(ArrayList<Neuronio> neuronioEntrada) {
        this.neuronioEntrada = neuronioEntrada;
    }

    public ArrayList<Neuronio> getNeuronioOculto() {
        return neuronioOculto;
    }

    public void setNeuronioOculto(ArrayList<Neuronio> neuronioOculto) {
        this.neuronioOculto = neuronioOculto;
    }

    public ArrayList<Neuronio> getNeuronioSaida() {
        return neuronioSaida;
    }

    public void setNeuronioSaida(ArrayList<Neuronio> neuronioSaida) {
        this.neuronioSaida = neuronioSaida;
    }

    public Double getErroAceitavel() {
        return erroAceitavel;
    }

    public void setErroAceitavel(Double erroAceitavel) {
        this.erroAceitavel = erroAceitavel;
    }

    public double getTaxaAprendizagem() {
        return taxaAprendizagem;
    }

    public void setTaxaAprendizagem(double taxaAprendizagem) {
        this.taxaAprendizagem = taxaAprendizagem;
    }
    
    private void initNeuronioOculto(){
        neuronioOculto = new ArrayList<>();
        
        for(int i=0;i <13;i++){
            neuronioOculto.add(new Neuronio());
        }
    }
    
    private void initNeuronioSaida(){
        neuronioSaida = new ArrayList<>();
        
        for(int i=0;i <10;i++){
            neuronioSaida.add(new Neuronio());
        }
    }
    
    public void processar(){
        Double novoValor = 0.0;
        Double saida = 0.0;
        Double novoFatorErro = 0.0;
        Double novoPeso = 0.0;
        Double maiorValor = 0.0;
        int indice = 0;
        
        /* PASSO 1*/
        for (int i=0;i < neuronioEntrada.size(); i++){
            neuronioEntrada.get(i).setSaida(neuronioEntrada.get(i).getEntrada());
        }
        
        /* PASSO 2*/
        //calcula para o neuronio oculto
        //somatorio de N3 = (N1.Saida * Peso da conexao de N1 para N3) + (N2.Saida * Peso da conexao de N2 para N3) 
        for (int i=0;i < neuronioOculto.size();i++){
            novoValor = 0.0;
            for (int j=0; j < neuronioEntrada.size();j++){
                novoValor += (neuronioEntrada.get(j).getSaida() * neuronioEntrada.get(i).getPeso());              
            }
            neuronioOculto.get(i).setSaida(novoValor);
        }
        
        //calcula para o neuronio de saida
        //somatorio de N3 = (N1.Saida * Peso da conexao de N1 para N3) + (N2.Saida * Peso da conexao de N2 para N3) 
        for (int i=0;i < neuronioSaida.size();i++){
            novoValor = 0.0;
            for (int j=0; j < neuronioOculto.size();j++){
                novoValor += (neuronioOculto.get(j).getSaida() * neuronioSaida.get(i).getPeso());                
            }
            //funcao sigmoidal
            novoValor = 1 / 1 + exp(-novoValor);
            neuronioSaida.get(i).setSaida(novoValor);
        }
        
        /* PASSO 3*/
        //CALCULA O ERRO PARA O NEURONIO DE SAIDA
        for (int j=0; j < neuronioSaida.size();j++){            
            if (j == this.getClasse()){
                neuronioSaida.get(j).setErro(1 - neuronioSaida.get(j).getSaida());
            }
            else{
                neuronioSaida.get(j).setErro(0 - neuronioSaida.get(j).getSaida());                
            }
        }
        
        //CALCULA O ERRO PARA O NEURONIO OCULTO
        for (int i=0; i < neuronioOculto.size();i++){
            novoFatorErro = 0.0;
            for (int j=0; j < neuronioSaida.size();j++){
                //erro do neuronio de saida * o peso do neuronio oculto
                novoFatorErro += neuronioSaida.get(j).getErro() * neuronioSaida.get(j).getPeso();
            }
            neuronioOculto.get(i).setErro(novoFatorErro);
        }                
        
        /* PASSO 4 */
        //ATUALIZA OS PESOS
        for (int i=0;i < neuronioOculto.size();i++){
            novoPeso = 0.0;
            for (int j=0; j < neuronioEntrada.size();j++){
                novoPeso += neuronioOculto.get(i).getPeso() + getTaxaAprendizagem() * 
                            neuronioEntrada.get(i).getSaida() * neuronioEntrada.get(i).getErro();
            }
            neuronioOculto.get(i).setPeso(novoPeso);            
        }
        
        for (int i=0;i < neuronioSaida.size();i++){
            novoPeso = 0.0;
            for (int j=0; j < neuronioOculto.size();j++){
                novoPeso += neuronioSaida.get(i).getPeso() + getTaxaAprendizagem() * 
                            neuronioOculto.get(i).getSaida() * neuronioOculto.get(i).getErro();
            }
            neuronioSaida.get(i).setPeso(novoPeso);            
        }

        //formatacao DUMMY
        maiorValor = neuronioSaida.get(0).getSaida();
        indice     = 0;
        for (int i = 0; i < neuronioSaida.size(); i++) {
            if (neuronioSaida.get(i).getSaida() > maiorValor){
                maiorValor = neuronioSaida.get(i).getSaida();
                indice = i;
            }            
        }
        
        System.out.println("Indice " + indice + " valor -> " + maiorValor);
    }
    
    
    
}
