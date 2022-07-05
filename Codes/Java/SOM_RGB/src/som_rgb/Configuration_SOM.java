/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som_rgb;

/**
 *
 * @author rafael
 */
public class Configuration_SOM {
    
    String caminhoBase;
    
    int numNeuroniosVertical;
    int numNeuroniosHorizontal;
    
    boolean amostragemAleatoria;
    
    double alpha;
    double tauAlpha;
    int numMaxIteracoes;

    public int getNumMaxIteracoes() {
        return numMaxIteracoes;
    }

    public void setNumMaxIteracoes(int numMaxIteracoes) {
        this.numMaxIteracoes = numMaxIteracoes;
    }
    
    boolean vizinhancaEuclideana;
    
    double sigma;
    double tauSigma;

    public Configuration_SOM() {
        super();
    }

    public Configuration_SOM(String caminhoBase, int numNeuroniosVertical, int numNeuroniosHorizontal, boolean amostragemAleatoria, double alpha, double tauAlpha, boolean vizinhancaEuclideana, double sigma, double tauSigma) {
        this.caminhoBase = caminhoBase;
        this.numNeuroniosVertical = numNeuroniosVertical;
        this.numNeuroniosHorizontal = numNeuroniosHorizontal;
        this.amostragemAleatoria = amostragemAleatoria;
        this.alpha = alpha;
        this.tauAlpha = tauAlpha;
        this.vizinhancaEuclideana = vizinhancaEuclideana;
        this.sigma = sigma;
        this.tauSigma = tauSigma;
    }

    public String getCaminhoBase() {
        return caminhoBase;
    }

    public void setCaminhoBase(String caminhoBase) {
        this.caminhoBase = caminhoBase;
    }

    public int getNumNeuroniosVertical() {
        return numNeuroniosVertical;
    }

    public void setNumNeuroniosVertical(int numNeuroniosVertical) {
        this.numNeuroniosVertical = numNeuroniosVertical;
    }

    public int getNumNeuroniosHorizontal() {
        return numNeuroniosHorizontal;
    }

    public void setNumNeuroniosHorizontal(int numNeuroniosHorizontal) {
        this.numNeuroniosHorizontal = numNeuroniosHorizontal;
    }

    public boolean isAmostragemAleatoria() {
        return amostragemAleatoria;
    }

    public void setAmostragemAleatoria(boolean amostragemAleatoria) {
        this.amostragemAleatoria = amostragemAleatoria;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getTauAlpha() {
        return tauAlpha;
    }

    public void setTauAlpha(double tauAlpha) {
        this.tauAlpha = tauAlpha;
    }

    public boolean isVizinhancaEuclideana() {
        return vizinhancaEuclideana;
    }

    public void setVizinhancaEuclideana(boolean vizinhancaEuclideana) {
        this.vizinhancaEuclideana = vizinhancaEuclideana;
    }

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double getTauSigma() {
        return tauSigma;
    }

    public void setTauSigma(double tauSigma) {
        this.tauSigma = tauSigma;
    }
    
    
    
}
