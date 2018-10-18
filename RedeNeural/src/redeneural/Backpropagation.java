/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redeneural;

import java.util.Random;

/**
 *
 * @author skyli
 */
public class Backpropagation {
    private final Integer numOfInput;
    private final Integer numOfHidden;
    private final Integer numOfOutput;

    private final Double learningRate;


    private Double[] X;//entrada
    private Double[] Y;//intermediaria
    private Double[] Z;//saida

    private Double[][] w1;//pesos da camada entrada->intermediaria
    private Double[][] w2;//pessos da camada intermediaria->saida

    private Double[] sigmaForY;
    private Double[] sigmaForZ;

    private Double[][] deltaw1;
    private Double[][] deltaw2;

    private Double[][] inputTraining;
    private Double[][] expectedOutput;
   
    public Backpropagation() {
        this.numOfInput   = 16;
        this.numOfHidden  = 13;
        this.numOfOutput  = 10;
        this.learningRate = 0.5;
        this.init();
    }

    public void zerarRede(){
        this.init();
    }
    /**
     * Inicializa os arrays e define pesos aleatorios
     */
    private void init() {
        this.X = new Double[numOfInput + 1];
        this.Y = new Double[numOfHidden + 1];
        this.Z = new Double[numOfOutput];
        this.X[numOfInput] = 1.0;//bias at last index
        this.Y[numOfHidden] = 1.0;//bias at last index

        this.sigmaForY = new Double[numOfHidden + 1];
        this.sigmaForZ = new Double[numOfOutput];

        this.w1 = new Double[numOfInput + 1][numOfHidden]; 
        this.w2 = new Double[numOfHidden + 1][numOfOutput];
        this.deltaw1 = new Double[numOfInput + 1][numOfHidden];
        this.deltaw2 = new Double[numOfHidden + 1][numOfOutput];

        Random r = new Random();

        for (int i = 0; i < this.numOfInput + 1; i++) { // percorre todos neuronios da camada da entrada
            for (int j = 0; j < this.numOfHidden; j++) { //percorre todos neuronios da camada intermediaria
                this.w1[i][j] = -1 + (1 - (-1)) * r.nextDouble();//-1:1 define pesosa aleatorios para a camada de entrada -> intermediaria
            }
        }
        for (int i = 0; i < numOfHidden + 1; i++) { // percorre todos neuronios da camada intermediaria 
            for (int j = 0; j < numOfOutput; j++) { // percorre todos neuronios da camada de saida
                this.w2[i][j] = -1 + (1 - (-1)) * r.nextDouble();//-1:1 define pesos aleatorios para a camada intermediaria -> saida
            }
        }
    }

    /**
     * Seta os dados de treinamento.
     *
     * @param inputTraining seta os dados para treinamento.
     * @param expectedOutput seta o resultado esperado.
     */
    public void setTrainingData(Double[][] inputTraining, Double[][] expectedOutput) {
        this.inputTraining = inputTraining;
        this.expectedOutput = expectedOutput;
    }

    /**
     * Treina ate que a taxa com os dados de entrada times vezes
     */
    public Double train(int times) {
        Double[] eO = new Double[numOfOutput];
        Double erro = 0.0;
        if (this.inputTraining != null && this.expectedOutput != null) {
            Double err = 0.0;
            long tempoInicial = System.currentTimeMillis();
            
            while (times > 0) {
                System.arraycopy(this.inputTraining[0] , 0, X, 0, this.inputTraining[0].length); // copiamos os dados de entrada para X
                System.arraycopy(this.expectedOutput[0], 0, eO, 0, this.expectedOutput[0].length); //copiamos os dados de resultado esperado para eO
                    
                for (int i = 0; i < this.inputTraining.length; i++) {
                    this.feedForward();
                    this.backPropagation(eO);
                }
                err = this.caclERR();
                //System.out.println("Taxa de erro: " + err);
                times--;
                erro = err;
            } 
            long tempoFinal = System.currentTimeMillis();
            
            //System.out.println("o metodo executou em " + (tempoFinal - tempoInicial));
            
        } else {
            System.out.println("Sem dados para treinar");
        }
        return erro;
    }

    /**
     * Calculate error average for all pattern.
     *
     * @return error average.
     */
    private Double caclERR() {
        Double[] eO = new Double[numOfOutput];
        Double err = 0.0;
        Double errTotal = 0.0;

        System.arraycopy(this.inputTraining[0], 0, X, 0, this.inputTraining[0].length);
        System.arraycopy(this.expectedOutput[0], 0, eO, 0, this.expectedOutput[0].length);
            
        for (int i = 0; i < this.inputTraining.length; i++) {
            //this.feedForward();
            for (int a = 0; a < this.numOfOutput; a++) {
                err += Math.pow((eO[a] - this.Z[a]), 2);
            }
            err /= numOfOutput;
            errTotal += err;
        }
        errTotal /= this.inputTraining.length;
        return errTotal;
    }
    /**
     * Feed-forward.
     */
    private void feedForward() {
        this.setOutputY();
        this.setOutputZ();
    }

    /**
     * Calcula cada saida do neurônio escondido.
     */
    private void setOutputY() {
        for (int a = 0; a < numOfHidden; a++) {
            this.sigmaForY[a] = 0.0;
        }
        
        for (int j = 0; j < this.numOfHidden; j++) {
            for (int i = 0; i < this.numOfInput; i++) {
                try {
                    this.sigmaForY[j] = this.sigmaForY[j] + this.X[i] * this.w1[i][j];
                } catch (Exception e) {
                    System.out.println("erro, indice " + i + " " + this.X[i]);
                }

            }
        }
        
        for (int j = 0; j < numOfHidden; j++) {
            /*SIGMOID*/
            this.Y[j] = this.sigmoid(this.sigmaForY[j]);
        }
    }

    /**
     * Calcula cada saida do neurônio de saída.
     */
    private void setOutputZ() {
        for (int a = 0; a < numOfOutput; a++) {
            this.sigmaForZ[a] = 0.0;
        }
        for (int k = 0; k < this.numOfOutput; k++) {
            for (int j = 0; j < this.numOfHidden + 1; j++) {
                this.sigmaForZ[k] = this.sigmaForZ[k] + this.Y[j] * this.w2[j][k];
            }
        }
        for (int k = 0; k < this.numOfOutput; k++) {
            /*SIGMOID*/
            this.Z[k] = this.sigmoid(this.sigmaForZ[k]);
        }        
    }

    /**
     * Backpropagation.
     *
     * @param expectedOutput entra o resultado esperado
     */
    private void backPropagation(Double[] expectedOutput) {
        Double[] fO = new Double[this.numOfOutput];

        for (int k = 0; k < numOfOutput; k++) {
            /*SIGMOID*/
            fO[k] = (expectedOutput[k] - this.Z[k]) * this.sigmoidDerivative(this.sigmaForZ[k]);
        }
        for (int j = 0; j < this.numOfHidden; j++) {//+bias weight
            for (int k = 0; k < this.numOfOutput; k++) {
                this.deltaw2[j][k] = this.learningRate * fO[k] * this.Y[j];
            }
        }
        Double[] fHNet = new Double[this.numOfHidden];
        for (int j = 0; j < this.numOfHidden; j++) {
            fHNet[j] = 0.0;
            for (int k = 0; k < this.numOfOutput; k++) {
                fHNet[j] = fHNet[j] + (fO[k] * this.w2[j][k]);
            }
        }
        Double[] fH = new Double[this.numOfHidden];
        for (int j = 0; j < this.numOfHidden; j++) {
            /*SIGMOID*/
            fH[j] = fHNet[j] * this.sigmoidDerivative(this.sigmaForY[j]);
        }
        for (int i = 0; i < this.numOfInput; i++) {
            for (int j = 0; j < numOfHidden; j++) {
                this.deltaw1[i][j] = this.learningRate * fH[j] * this.X[i];
            }
        }
        this.changeWeight();
    }

    /**
     * Atualiza todos pesos
     */
    private void changeWeight() {
        for (int j = 0; j < numOfHidden; j++) {
            for (int k = 0; k < numOfOutput; k++) {
                this.w2[j][k] = this.w2[j][k] + this.deltaw2[j][k];
            }
        }
        for (int i = 0; i < numOfInput; i++) {
            for (int j = 0; j < numOfHidden; j++) {
                this.w1[i][j] = this.w1[i][j] + this.deltaw1[i][j];
            }
        }
    }

    /**
     * Função Sigmoidal
     * <br/>f(x) = 1 / (1 + exp(-x))
     *
     * @param x um valor.
     * @return o resultado da função sigmoidal
     */
    private Double sigmoid(Double x) {
        return 1 / (1 + (double) Math.exp(-x));
    }
    private Double sigmoidDerivative(Double x) {
        return this.sigmoid(x) * (1 - this.sigmoid(x));
    }

    /**
     * Méotod para retornar os valores do neurônio de saída
     *
     * @return os valores do neurônio de saída.
     */
    public Double[] getOutput() {
        return this.Z;
    }
}
