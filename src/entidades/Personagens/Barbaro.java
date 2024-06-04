package entidades.Personagens;

import entidades.Entidade;

public class Barbaro extends Entidade {
    public Barbaro(String nome, int nivel, int vida, int forca, int defesa, int magia) {
        super(nome, nivel, vida, forca, defesa, magia);
        this.nome = nome;
        this.nivel= 1;
        this.forca = 15;
        this.vida = 9;
        this.defesa = 10;
        this.magia = 2;
    }


    @Override
    public void atacar() {
        System.out.println(nome + " ataca com força bruta!");
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}

