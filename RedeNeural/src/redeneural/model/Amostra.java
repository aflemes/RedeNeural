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
public class Amostra {
    private int classe;
    private ArrayList<Double> valorNormalizado;    

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public ArrayList<Double> getValorNormalizado() {
        return valorNormalizado;
    }

    public void setValorNormalizado(ArrayList<Double> valorNormalizado) {
        this.valorNormalizado = valorNormalizado;
    }
    
}
