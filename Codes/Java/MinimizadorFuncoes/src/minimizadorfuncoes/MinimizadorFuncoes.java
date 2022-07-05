/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimizadorfuncoes;

/**
 *
 * @author rafael
 */
public class MinimizadorFuncoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double resultadoReal = 8;
        
        double x = 0;
        
        double taxaCorrecaoErro = 0.1;
        
        int numMaxIteracoes = 200;
        int numIteracoes = 0;
        
        boolean sair = false;
        while(sair == false){
            double erro = calculaErro(x,resultadoReal);
            System.out.println("Erro: " + erro);
            
            if(erro == 0){
                sair = true;
            }else{
                x = x - erro * taxaCorrecaoErro;   
                System.out.println("X: " + x);
            }
            

            numIteracoes++;
            if(numIteracoes > numMaxIteracoes){
                sair = true;
            }
        }
        
        System.out.println("O valor de x é: " + x);
    }
    
    public static double funcao(double x){
        double resultado = 2 * x + x*x;
        return resultado;
    }
    
    public static double calculaErro(double x,double resultadoReal){
        double erro = funcao(x) - resultadoReal;
        return erro;        
    }
    
}
