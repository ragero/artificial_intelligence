/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som_rgb;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author rafael
 */
public class GerarCores {
    
    public static void main(String[] args) {
        
        try{
            BufferedWriter arqOut = new BufferedWriter(new FileWriter("/home/rafael/Área de trabalho/UFMS/Disciplinas/SAD_2_2017/Bases/Análise de Agrupamento/Cores.csv"));
            arqOut.write("R;G;B\n");
            for(int r=0;r<256;r=r+64){
                for(int g=0;g<256;g=g+64){
                    for(int b=0;b<256;b=b+64){
                        arqOut.write(r + ";" + g + ";" + b + "\n");
                    }
                    arqOut.write(r + ";" + g + ";" + 255 + "\n");
                }
                arqOut.write(r + ";" + 255 + ";" + 255 + "\n");
            }
            arqOut.write(255 + ";" + 255 + ";" + 255 + "\n");
            arqOut.close();
        }catch(Exception e){
            System.err.println("Deu pau!");
            e.printStackTrace();
        }
           
        
    }
    
}
