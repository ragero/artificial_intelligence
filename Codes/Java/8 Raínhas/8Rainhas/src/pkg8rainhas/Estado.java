/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rafael
 */
public class Estado {
    
    boolean[][] tabuleiro;
    double valor;
    int tamanho;

    public Estado(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new boolean[tamanho][tamanho];
    }

    public Estado(boolean[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.tamanho = tabuleiro.length;
    }
    
    
    public boolean[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(boolean[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public void inicializaTabuleiro(){
        Random random = new Random();
        for(int coluna=0;coluna<tamanho;coluna++){
            tabuleiro[random.nextInt(tamanho)][coluna] = true;
        }
        calculaHeuristica();
    }
    
    
    public boolean[][] copiaTabuleiroAtual(){
        boolean[][] copia = new boolean[tamanho][tamanho];
        for(int linha=0;linha<tamanho;linha++){
            for(int coluna=0;coluna<tamanho;coluna++){
                copia[linha][coluna] = tabuleiro[linha][coluna];
            }
        }
        return copia;
    }
    
    public void calculaHeuristica(){
        double acumulador = 0;
        //Numero de pares de rainhas se atacando
        //Numero de ataque nas linhas
        for(int linha=0;linha<tamanho;linha++){
            for(int coluna1=0;coluna1<tamanho;coluna1++){
                for(int coluna2=coluna1+1;coluna2<tamanho;coluna2++){
                    if(tabuleiro[linha][coluna1] == true && (tabuleiro[linha][coluna2] == true)){
                        acumulador++;
                    }
                }
            }
        }
        
        //Numero de ataque nas colunas
        for(int coluna=0;coluna<tamanho;coluna++){
            for(int linha1=0;linha1<tamanho;linha1++){
                for(int linha2=linha1+1;linha2<tamanho;linha2++){
                    if(tabuleiro[linha1][coluna] == true && (tabuleiro[linha2][coluna] == true)){
                        acumulador++;
                    }    
                }
            }
        }
        
        //Numero de ataques na diagonal (da esquerda para a direita)
        for(int linha=0;linha<tamanho;linha++){
            for(int coluna=0;coluna<tamanho;coluna++){
                for(int cont=1;cont<tamanho;cont++){
                    if(((linha + cont) >= tamanho) || ((coluna + cont) >= tamanho)){
                        break;
                    }else{
                        if((tabuleiro[linha][coluna] == true) && (tabuleiro[linha+cont][coluna+cont] == true)){
                            acumulador++;
                        }
                    }
                }
            }
        }
        
        //Numero de ataques na diagonal (da direita para a esquerda)
        for(int linha=0;linha<tamanho;linha++){
            for(int coluna=0;coluna<tamanho;coluna++){
                for(int cont=1;cont<tamanho;cont++){
                    if(((linha + cont) >= tamanho) || ((coluna - cont) < 0)){
                        continue;
                    }else{
                        if((tabuleiro[linha][coluna] == true) && (tabuleiro[linha+cont][coluna-cont] == true)){
                            acumulador++;
                        }
                    }
                }
            }
        }
        
        this.valor = acumulador;
    }
    
    public int[] retornaVetorEstado(){
        int[] posRainhaColuna = new int[tamanho];
        for(int coluna=0;coluna<tamanho;coluna++){
            for(int linha=0;linha<tamanho;linha++){
                if(tabuleiro[linha][coluna] == true){
                    posRainhaColuna[coluna] = linha;
                    break;
                }
            }
        }
        return posRainhaColuna;
    }
    
    public void imprimeEstado(){
        for(int linha=0;linha<tamanho;linha++){
            for(int coluna=0;coluna<tamanho;coluna++){
                if(tabuleiro[linha][coluna] == true){
                    System.out.print("■");
                }else{
                    System.out.print("□");
                }
            }
            System.out.println();
        }
        
        System.out.println("\n\nFunção de Avaliação: " + valor);
    }
    
}
