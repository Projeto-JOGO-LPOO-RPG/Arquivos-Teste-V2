package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entidades.Jogador;



public class PainelDoJogo extends JPanel implements Runnable{

    //CONFIGURAÇÕES DE TELA
    final int TamanhoTileOriginal = 16; //16x16 pixels espaço
    final int escala = 3;   //Tamanho 48 pixels para a tela

    public final int TamanhoTile = TamanhoTileOriginal*escala; //48x48 pixels
    final int ColMaxTela = 16;
    final int LinhMaxTela = 12;
    final int LarguraTela = TamanhoTile*ColMaxTela; //768 pixels
    final int ALturaTela = TamanhoTile*LinhMaxTela; //576 pixels
    final int FPS = 60;

    KeyHandler inputTeclado = new KeyHandler();
    Thread tempoDoJogo;
    
    Jogador jogador = new Jogador(this, inputTeclado, getName(), ALturaTela, ALturaTela, ALturaTela, ALturaTela, ALturaTela);

    int jogadorX0 = 100;
    int jogadorY0 = 100;
    int passoJogador = 4;

    public PainelDoJogo() {
        this.setPreferredSize(new Dimension(LarguraTela, ALturaTela));
        this.setBackground(Color.white);    //Fundo de cor preta
        this.setDoubleBuffered(true);
        this.addKeyListener(inputTeclado);
        this.setFocusable(true);

    }

    public void InicioContaTempoJogo() {

        tempoDoJogo = new Thread(this); //This chamando a classe PainelDoJOgo
        tempoDoJogo.start();
    }

    @Override
    public void run() {


        double intervalo = 1000000000/FPS;
        double deltaIntervalo = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int contador = 0;

        while(tempoDoJogo != null) {


            currentTime = System.nanoTime();
            deltaIntervalo += (currentTime - lastTime)/ intervalo;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(deltaIntervalo >= 1) {
                atualizaTela();
                repaint();
                deltaIntervalo--;
                contador++;

            }

            if(timer >= 1000000000){
                System.out.println("FPS: "+ contador);
                contador = 0;
                timer = 0;
            }
        }
    }


    public void atualizaTela() {

        jogador.atualizaTela();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        jogador.imprime(g2);
        
        
        g2.dispose();
    }
}
