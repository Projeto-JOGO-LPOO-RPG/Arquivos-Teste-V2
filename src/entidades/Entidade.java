package entidades;

import java.awt.image.BufferedImage;

public class Entidade {

    public int coordX;
    public int coordY;
    public int velocidade;
    protected String nome;
    public int nivel = 1;
    protected int vida;
    protected int forca;
    protected int defesa;
    protected int magia;


    public Entidade (String nome, int nivel, int vida, int forca, int defesa, int magia){
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.magia = magia;
    }
        

    public BufferedImage spriteCima, spriteBaixo, spriteEsq, spriteDir;
    public String direcao;

    public int contadorSprites = 0;
    public int numeroSprite = 1;



    public void atacar() {
        // Método genérico de ataque
    }

    public void defender() {
        // Método genérico de defesa
    }


}
    

