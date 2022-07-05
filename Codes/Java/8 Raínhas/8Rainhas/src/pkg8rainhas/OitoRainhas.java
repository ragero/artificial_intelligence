/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

import Algoritmos.AG;
import Algoritmos.HillClimbing;
import Algoritmos.SimmulatedAnnealing;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public class OitoRainhas {

    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite o tamanho do tabuleiro: ");
        int tamanho = Integer.parseInt(teclado.nextLine());
        
        System.out.print("Digite o número máximo de iteracoes: ");
        int numMaxIteracoes = Integer.parseInt(teclado.nextLine());
        
        System.out.print("Selecione o algoritmo: ");
        String algoritmo = teclado.nextLine();
        
        if(algoritmo.equals("Hill Climbing")){
            while(true){
                HillClimbing hillClimbing = new HillClimbing(tamanho,numMaxIteracoes);
                hillClimbing.encontrarSolucao();
                teclado.nextLine();
            }
            
        }else if(algoritmo.equals("Simmulated Annealing")){
            while(true){
                SimmulatedAnnealing simAnnealing = new SimmulatedAnnealing(tamanho,numMaxIteracoes);
                simAnnealing.encontrarSolucao();
                teclado.nextLine();
            }
        }else if(algoritmo.equals("Algoritmo Genético")){
            while(true){
                AG ag = new AG(tamanho,numMaxIteracoes);
                ag.encontrarSolucao();
                teclado.nextLine();
            }
        }
        
        
        
        
    }
    
   
    
}
