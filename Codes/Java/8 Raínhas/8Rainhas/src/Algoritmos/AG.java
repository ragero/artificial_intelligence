/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import pkg8rainhas.Estado;

/**
 *
 * @author rafael
 */
public class AG extends Busca{
    
    int tamanhoPopulacao = 2;
    double taxaMutacao = 0.1;
    
    public AG(int tamanho, int numMaxIteracoes){
        super(tamanho, numMaxIteracoes);
    }
    
    public void encontrarSolucao(){
        
        Estado melhorIndividuo = null;
        
        // Gerando populacao inicial
        ArrayList<Estado> populacao = new ArrayList<Estado>();
        for(int pop=0;pop<tamanhoPopulacao;pop++){
            Estado estado = new Estado(tamanho);
            estado.inicializaTabuleiro();
            estado.calculaHeuristica();
            estado.setValor(Math.pow(estado.getValor(), 2));
            populacao.add(estado);
            //estado.imprimeEstado();
        }
        
        boolean sair = false;
        int numIteracoes = 0;
        
        while(sair == false){
            double[] roleta = new double[tamanhoPopulacao];
            // Inserindo valores de fitness na roleta (já com o valor invertido
            for(int pop=0;pop<tamanhoPopulacao;pop++){
                roleta[pop] = 1.0/populacao.get(pop).getValor();
            }
            
            //Nomalizando => probabilidade de ocorrer um estado de acordo com a função de fitness
            double soma = 0;
            for(int ind=0;ind<tamanhoPopulacao;ind++){
                soma += roleta[ind];
            }
            
            System.out.println((numIteracoes + 1) + " - Fitness total da popucação: " + soma);
            //Normalizando os valores
            for(int ind=0;ind<tamanhoPopulacao;ind++){
                roleta[ind] /= soma;
            }
            
            
            //Lebrando que a probabilidade da roleta deve ser a probabilidade acumulada
            double acm = 0;
            for(int ind=0;ind<tamanhoPopulacao;ind++){
                roleta[ind] += acm;
                acm = roleta[ind];
            }
            
            //Com isso temos a roleta que guiará a escola dos indivíduos para a reprodução
            // Vamos chamar uma função para gerar a nova populacao;
            
            
            populacao = gerarNovaPopulacao(populacao, roleta);
            
            numIteracoes++;
            if(numIteracoes > numMaxIteracoes){
                sair = true;
            }
            
            //Verificando se foi obtida a melhor solução
            melhorIndividuo = populacao.get(0);
            for(int ind=1;ind<populacao.size();ind++){
                if(populacao.get(ind).getValor() < melhorIndividuo.getValor()){
                    melhorIndividuo = populacao.get(ind);
                }
            }
            melhorIndividuo.imprimeEstado();
            if(melhorIndividuo.getValor() == 0){
                sair = true;
            }
        }
        
        if(melhorIndividuo.getValor() > 0){
            System.out.println("Não foi encontrada solução ótima");
        }
        
    }
    
    public ArrayList<Estado> gerarNovaPopulacao(ArrayList<Estado> populacao, double[] roleta){
        ArrayList<Estado> novaPopulacao = new ArrayList<Estado>();// ArrayList para armazenar a nova população
        
        Random random = new Random();
        
        Scanner teclado = new Scanner(System.in);
        
        while(novaPopulacao.size() < tamanhoPopulacao){
            // Selecionando dois indivíduos para reprodução com base na função de fitness
            //Primeiro indivíduo
            int ind1 = 0;
            double aleatorio1 = Math.random();
            for(int ind=0;ind<roleta.length;ind++){
                if(aleatorio1 < roleta[ind]){
                    ind1 = ind;
                    break;
                }
            }
            
            int ind2 = 0;
            double aleatorio2 = Math.random();
            for(int ind=0;ind<roleta.length;ind++){
                if(aleatorio2 < roleta[ind]){
                    ind2 = ind;
                    break;
                }
            }
            
            Estado individuo1 = populacao.get(ind1);
            //System.out.println("Pai 1");
            //individuo1.imprimeEstado();
            int[] cromossomoInd1 = individuo1.retornaVetorEstado();
            Estado individuo2 = populacao.get(ind2);
            //System.out.println("Pai 2");
            //individuo2.imprimeEstado();
            int[] cromossomoInd2 = individuo2.retornaVetorEstado();

            //Gerando a posicao de crossover aleatoriamente e garantindo ue ela seja maior que 0 para que haja combinação entre dois pais
            int posicaoCrossover = random.nextInt(tamanho);
            if(posicaoCrossover == 0){
                posicaoCrossover++;
            }
            //System.out.println("Ponto de crossover: " + posicaoCrossover);
            
            //Mutando o cromossomo que vai gerar o indivíduo
            for(int g=0;g<tamanho;g++){
                double probMutacao = Math.random();
                if(probMutacao < taxaMutacao){
                    int novaPosicao = random.nextInt(tamanho);
                    cromossomoInd1[g] = novaPosicao;
                }    
            }
            
            for(int g=0;g<tamanho;g++){
                double probMutacao = Math.random();
                if(probMutacao < taxaMutacao){
                    int novaPosicao = random.nextInt(tamanho);
                    cromossomoInd2[g] = novaPosicao;
                }    
            }
            
            
            
            boolean[][] novoTabuleiro1 = new boolean[tamanho][tamanho];
            //Pegando a primeira parte do individuo1
            for(int ind=0;ind<posicaoCrossover;ind++){
                novoTabuleiro1[cromossomoInd1[ind]][ind] = true;
            }
            //Pegando a segunda parte do individuo2
            for(int ind=posicaoCrossover;ind<tamanho;ind++){
                novoTabuleiro1[cromossomoInd2[ind]][ind] = true;
            }
            
            
            Estado novoIndividuo1 = new Estado(novoTabuleiro1);
            novoIndividuo1.calculaHeuristica();
            //System.out.println("Novo Indivíduo1");
            //novoIndividuo1.imprimeEstado();
            //teclado.nextLine();
            novaPopulacao.add(novoIndividuo1);
            
            boolean[][] novoTabuleiro2 = new boolean[tamanho][tamanho];
            //Pegando a primeira parte do individuo2
            for(int ind=0;ind<posicaoCrossover;ind++){
                novoTabuleiro2[cromossomoInd2[ind]][ind] = true;
            }
            //Pegando a segunda parte do individuo1
            for(int ind=posicaoCrossover;ind<tamanho;ind++){
                novoTabuleiro2[cromossomoInd1[ind]][ind] = true;
            }
            
            Estado novoIndividuo2 = new Estado(novoTabuleiro2);
            novoIndividuo2.calculaHeuristica();
            //System.out.println("Novo Indivíduo1");
            //novoIndividuo2.imprimeEstado();
            //teclado.nextLine();
            
            novaPopulacao.add(novoIndividuo2);
        }
        
        return novaPopulacao;
    }
    
    public Estado gerarSucessor(Estado estadoAtual){
        Estado proximoEstado = estadoAtual;
        
        boolean[][] tabuleiro = estadoAtual.getTabuleiro();
        
        //Pegado a posição de cada rainha em cada coluna
        int[] posRainhaColuna = estadoAtual.retornaVetorEstado();
        
        boolean troca = false;
        //Alterando a posição de cada rainha em cada coluna, avaliando estados e gerando sucessores;
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
                    }       
                }
            }
        }
        
        
        
        if(troca == true){
            return proximoEstado;
        }else{
            return null;
        }
        
        
    }
    
}
