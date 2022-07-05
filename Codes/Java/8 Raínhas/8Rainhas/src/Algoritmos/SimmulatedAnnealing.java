/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import pkg8rainhas.Estado;

/**
 *
 * @author rafael
 */
public class SimmulatedAnnealing extends Busca{
    
    private double prob = 1.0;
    private double decaimento = 0.05;
    
    public SimmulatedAnnealing(int tamanho, int numMaxIteracoes){
        super(tamanho, numMaxIteracoes);
    }
    
    public void encontrarSolucao(){
        Estado estadoAtual = new Estado(tamanho); // nesse ponto o estado atual corresponde ao estado inicial;
        estadoAtual.inicializaTabuleiro();
        
        boolean sair = false;
        int numIteracoes = 0;
        
        while(sair == false){
            
            Estado proximoEstado = gerarSucessor(estadoAtual);
            if(proximoEstado == null){
                sair = true;
            }else{
                estadoAtual = proximoEstado;
            }
            
            numIteracoes++;
            if(numIteracoes > numMaxIteracoes){
                sair = true;
            }
        }
        
        estadoAtual.imprimeEstado();
        System.out.println("\nNúmero de Iterações: " + numIteracoes +"\n\n");
    }
    
    public Estado gerarSucessor(Estado estadoAtual){
        Estado proximoEstado = estadoAtual;
        
        boolean[][] tabuleiro = estadoAtual.getTabuleiro();
        
        //Pegado a posição de cada rainha em cada coluna
        int[] posRainhaColuna = estadoAtual.retornaVetorEstado();
        
        //Alterando a posição de cada rainha em cada coluna, avaliando estados e gerando sucessores;
        boolean troca = false;
        for(int coluna=0;coluna<tamanho;coluna++){
            //boolean[][] novoTabuleiro = tabuleiro.clone();
            for(int linha=0;linha<tamanho;linha++){
                //Verificação para não gerar um mesmo estado
                if(linha != posRainhaColuna[coluna]){
                    boolean[][] novoTabuleiro = estadoAtual.copiaTabuleiroAtual();
                    novoTabuleiro[posRainhaColuna[coluna]][coluna] = false;
                    novoTabuleiro[linha][coluna] = true;
                    Estado novoEstado = new Estado(novoTabuleiro);
                    novoEstado.calculaHeuristica();
                    double valorCorrente = novoEstado.getValor();
                    if(valorCorrente < proximoEstado.getValor()){
                        proximoEstado = novoEstado;
                        troca = true;
                    }else{
                        double aleatorio = Math.random();
                        if(aleatorio < prob){
                            proximoEstado = novoEstado;
                            troca = true;
                        }
                    }         
                }
            }
        }
        
        prob = prob - decaimento;
        
        if(troca == true){
            return proximoEstado;
        }else{
            return null;
        }
        
    }
    
}
