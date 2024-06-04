package entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.KeyHandler;
import main.PainelDoJogo;



public class Jogador extends Entidade{
    public Jogador(String nome, int nivel, int vida, int forca, int defesa, int magia){
        super(nome, nivel, vida, forca, defesa, magia);
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.magia = magia;
    }

    private PainelDoJogo pj;
    private KeyHandler inputTeclado;
    private BufferedImage spriteCima1;
    private BufferedImage spriteBaixo1;
    private BufferedImage spriteEsq1;
    private BufferedImage spriteDir1;

    private BufferedImage spriteCima2;
    private BufferedImage spriteBaixo2;
    private BufferedImage spriteEsq2;
    private BufferedImage spriteDir2;






    public Jogador(PainelDoJogo pj, KeyHandler inputTeclado, String nome, int nivel, int vida, int forca, int defesa, int magia) {
        super(nome, nivel, vida, forca, defesa, magia); // Chama o construtor da classe base Entidade
        this.pj = pj;
        this.inputTeclado = inputTeclado;

        setValorPadrao();
        getSpriteJogador();
        
    }


    public void setValorPadrao() {
        coordX = 100;
        coordY = 100;
        velocidade = 4;
        direcao = "any";

    }

    public String getNome(){
        return nome;
    }

    public void setNome(){
        nome = "Edward";
    }

    
    

    

    public void getSpriteJogador(){

        try {

            spriteCima1 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraCima1.png"));
            spriteCima2 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraCima2.png"));

            spriteBaixo1 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraBaixo1.png"));
            spriteBaixo2 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraBaixo2.png"));

            spriteEsq1 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraEsq1.png"));
            spriteEsq2 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraEsq2.png"));

            spriteDir1 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraDir1.png"));
            spriteDir2 = ImageIO.read(new File("/Users/edwar/Google Drive/UPE/Oriented Objects Programming/TheKingdomOfDyks/res/playerSprites/Barbaro/paraDir2.png"));


        } catch(IOException e){
            e.printStackTrace();
        }

    }
  

    



    public void atualizaTela() {

        if(inputTeclado.paraCima == true || inputTeclado.paraBaixo == true || 
            inputTeclado.paraDireita == true || inputTeclado.paraEsqrd == true){

                if(inputTeclado.paraCima == true) {
                    coordY -= velocidade;
                    direcao = "cima";
                }
                if(inputTeclado.paraBaixo == true) {
                    coordY += velocidade;
                    direcao = "baixo";
                }
                if(inputTeclado.paraEsqrd == true) {
                    coordX -= velocidade;
                    direcao = "esquerda";
                }
                if(inputTeclado.paraDireita == true) {
                    coordX += velocidade;
                    direcao = "direita";
                }
        
                contadorSprites++;
                if(contadorSprites > 8) {
                    if(numeroSprite == 1) {
                        numeroSprite = 2;
                    }
                    else if(numeroSprite == 2) {
                        numeroSprite = 1;
                    }
                   contadorSprites = 0;
                }

        }
        
    }

    public void imprime(Graphics2D g2) {

        BufferedImage image = null;
        //g2.setColor(Color.white);
        //g2.fillRect(coordX, coordY, pj.TamanhoTile, pj.TamanhoTile);
        //g2.drawImage(spriteBaixo, coordX, coordY, pj.TamanhoTile, pj.TamanhoTile, null);
        

        
        switch(direcao){
        case "cima":
        if(numeroSprite == 1){
            image = spriteCima1;
        }
        if(numeroSprite == 2){
            image = spriteCima2;
        }
            break;
        case "baixo":
        if(numeroSprite == 1){
            image = spriteBaixo1;
        }
        if(numeroSprite == 2){
            image = spriteBaixo2;
        }
            break;
        case "esquerda":
        if(numeroSprite == 1){
            image = spriteEsq1;
        }
        if(numeroSprite == 2){
            image = spriteEsq2;
        }
            break;
        case "direita":
        if(numeroSprite == 1){
            image = spriteDir1;
        }
        if(numeroSprite == 2){
            image = spriteDir2;
        }
            break;
        }

        g2.drawImage(image, coordX, coordY, pj.TamanhoTile, pj.TamanhoTile, null);

    }
    
}
