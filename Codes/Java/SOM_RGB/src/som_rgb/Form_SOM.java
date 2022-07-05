/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som_rgb;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author rafael
 */
public class Form_SOM extends javax.swing.JInternalFrame {

    private Configuration_SOM config;
    
    private Cor[][] neuronios;
    private ArrayList<Cor> data;
    private JPanel[][] paineis;
    
    private Icon iconPlay;
    private Icon iconPause;
    
    private Thread learn;
    private boolean play;
    
    public Form_SOM(Configuration_SOM config) {
        this.config = config;
        play = false;
        
        initComponents();
        
        iconPlay = new ImageIcon("play.png");
        iconPause = new ImageIcon("pause-icon.png");
        bPlayPause.setIcon(iconPlay);
        
        neuronios = new Cor[config.getNumNeuroniosVertical()][config.getNumNeuroniosHorizontal()];
        paineis = new JPanel[config.getNumNeuroniosVertical()][config.getNumNeuroniosHorizontal()];
        Random random = new Random();
        
        pMapaSOM.setLayout(new GridLayout(config.getNumNeuroniosVertical(),config.getNumNeuroniosHorizontal(),1,1));
        for(int i=0;i<config.getNumNeuroniosVertical();i++){
            for(int j=0;j<config.getNumNeuroniosHorizontal();j++){
                neuronios[i][j] = new Cor(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                JPanel painel = new JPanel();
                paineis[i][j] = painel;
                painel.setBackground(new Color(neuronios[i][j].getR(),neuronios[i][j].getG(),neuronios[i][j].getB()));
                pMapaSOM.add(painel);
            }
        }
        
        readData();
        
        this.setVisible(true);
    }

    public void readData(){
        
        data = new ArrayList<Cor>();
        try{
            BufferedReader arqIn = new BufferedReader(new FileReader(config.getCaminhoBase()));
            
            String linha = "";
            linha = arqIn.readLine();
            
            while( (linha = arqIn.readLine()) != null ){
                String[] partes = linha.split(";");
                data.add(new Cor(Integer.parseInt(partes[0]),Integer.parseInt(partes[1]),Integer.parseInt(partes[2])));
            }
            
        }catch(Exception e){
            System.err.println("Deu pau!");
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMapaSOM = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lCorExemplo = new javax.swing.JLabel();
        bPlayPause = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tMilisegundos = new javax.swing.JTextField();

        setIconifiable(true);
        setResizable(true);
        setTitle("Rede SOM");

        pMapaSOM.setBorder(javax.swing.BorderFactory.createTitledBorder("Rede SOM"));

        javax.swing.GroupLayout pMapaSOMLayout = new javax.swing.GroupLayout(pMapaSOM);
        pMapaSOM.setLayout(pMapaSOMLayout);
        pMapaSOMLayout.setHorizontalGroup(
            pMapaSOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pMapaSOMLayout.setVerticalGroup(
            pMapaSOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Controle de Execução"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exemplo Selecionado"));

        lCorExemplo.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lCorExemplo, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lCorExemplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bPlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/som_rgb/pause-icon.png"))); // NOI18N
        bPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlayPauseActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Velocidade (milisegundos)"));

        tMilisegundos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tMilisegundos.setText("200");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tMilisegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tMilisegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(bPlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bPlayPause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pMapaSOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pMapaSOM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlayPauseActionPerformed
        
        if(play == false){
            if(learn == null){
                learn = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        

                        double sigma = config.getSigma();
                        double alpha = config.getAlpha();

                        ArrayList<Cor> data2 = new ArrayList<Cor>();
                        Random rand = new Random();

                        int numIt = 1;

                        boolean sair = false;
                        while(sair == false){

                            while(data.size() > 0){

                                //Escolhendo um exemplo

                                int indice = -1;
                                if(config.amostragemAleatoria){
                                    indice = rand.nextInt(data.size());
                                }else{
                                    indice = 0;
                                }

                                Cor exemplo = data.get(indice);
                                lCorExemplo.setBackground(new Color(exemplo.getR(),exemplo.getG(),exemplo.getB()));
                                data2.add(exemplo);
                                data.remove(indice);

                                //Obtendo o neurônico vencedor (com seus índices e tudo)
                                double minDist = Double.MAX_VALUE;
                                int posVertical = -1;
                                int posHorizontal = -1;
                                Cor vencedor = null;

                                for(int i=0;i<config.getNumNeuroniosVertical();i++){
                                    for(int j=0;j<config.getNumNeuroniosHorizontal();j++){
                                        double dist = calculaEuclideana(exemplo, neuronios[i][j]);
                                        if(dist < minDist){
                                            minDist = dist;
                                            vencedor = neuronios[i][j];
                                            posVertical = i;
                                            posHorizontal = j;
                                        }
                                    }
                                }

                                //Border borda = BorderFactory.createLineBorder(Color.red);
                                Border borda = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red);
                                paineis[posVertical][posHorizontal].setBorder(borda);
                                try {
                                    long time = Long.parseLong(tMilisegundos.getText());
                                    Thread.sleep(time);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Form_SOM.class.getName()).log(Level.SEVERE, null, ex);
                                }


                                //Atualizando os pesos de todos os neurônios
                                for(int i=0;i<config.getNumNeuroniosVertical();i++){
                                    for(int j=0;j<config.getNumNeuroniosHorizontal();j++){
                                        double pesoVizinho = calculaPesoVizinho(i,j,posVertical,posHorizontal,sigma);
                                        int novoR = (int)Math.round(neuronios[i][j].getR() + pesoVizinho * alpha*(exemplo.getR() - neuronios[i][j].getR()));
                                        int novoG = (int)Math.round(neuronios[i][j].getG() + pesoVizinho * alpha*(exemplo.getG() - neuronios[i][j].getG()));
                                        int novoB = (int)Math.round(neuronios[i][j].getB() + pesoVizinho * alpha*(exemplo.getB() - neuronios[i][j].getB()));
                                        neuronios[i][j].setR(novoR);
                                        neuronios[i][j].setG(novoG);
                                        neuronios[i][j].setB(novoB);
                                        paineis[i][j].setBackground(new Color(novoR,novoG,novoB));
                                    }
                                }

                                borda = BorderFactory.createEmptyBorder();
                                paineis[posVertical][posHorizontal].setBorder(borda);

                            }

                            alpha = config.getAlpha() * Math.exp(-numIt / config.getTauAlpha());
                            if(alpha < 0.01){//Detalhe de implementação apresentado no livro de Simon Haykin: Neural Networks - A Comprehensive Foundation
                                alpha = 0.01;
                            }
                            sigma = config.getSigma() * Math.exp(-numIt / config.getTauSigma());

                            data = data2;
                            data2 = new ArrayList<Cor>();

                            System.out.println("Iteracao " + numIt + " completa.");
                            numIt++;

                            if(numIt >= config.getNumMaxIteracoes()){
                                sair = true;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Processo de Aprendizado Concluído com Sucesso");
                        bPlayPause.setIcon(iconPlay);        
                    }
                });

                learn.start();
            }else{
                learn.resume();
            }
            play = true;
            bPlayPause.setIcon(iconPause);
        }else{
            learn.suspend();
            play = false;
            bPlayPause.setIcon(iconPlay);
        }
                
            
    }//GEN-LAST:event_bPlayPauseActionPerformed

    public double calculaPesoVizinho(int posNeuronioVertical, int posNeuronioHorizontal, int posVencedorVertical, int posVencedorHorizontal, double sigma){
        double peso = 0;
        //Usando a distância suprema
        /*int difVertical = Math.abs(posNeuronioVertical - posVencedorVertical);
        int difHorizontal = Math.abs(posNeuronioHorizontal - posVencedorHorizontal);
        peso = Math.max(difVertical, difHorizontal);
        */
        //Usando a distância Euclidiana
        double difVertical = Math.pow(posNeuronioVertical - posVencedorVertical,2);
        double difHorizontal = Math.pow(posNeuronioHorizontal - posVencedorHorizontal,2);
        peso = Math.sqrt(difVertical + difHorizontal);
        //Usando a distância Manhatam
        //int difVertical = Math.abs(posNeuronioVertical - posVencedorVertical);
        //int difHorizontal = Math.abs(posNeuronioHorizontal - posVencedorHorizontal);
        peso = difVertical + difHorizontal;
        
        if(config.vizinhancaEuclideana){
            peso = 1 / Math.pow(1 + peso,3);
        }else{
            peso = Math.exp(- Math.pow(peso, 2)/(2*Math.pow(sigma, 2)));
        }
        
        return peso;
    }
    
    public double calculaEuclideana(Cor exemplo, Cor neuronio){
        double dist = 0;
        
        dist += Math.pow(exemplo.getR() - neuronio.getR(),2);
        dist += Math.pow(exemplo.getG() - neuronio.getG(),2);
        dist += Math.pow(exemplo.getB() - neuronio.getB(),2);
        
        dist = Math.sqrt(dist);
        
        return dist;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bPlayPause;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lCorExemplo;
    private javax.swing.JPanel pMapaSOM;
    private javax.swing.JTextField tMilisegundos;
    // End of variables declaration//GEN-END:variables
}
