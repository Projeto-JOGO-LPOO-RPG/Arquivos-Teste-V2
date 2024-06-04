package entidades.Personagens;
import entidades.Entidade;

public class Cavaleiro extends Entidade {
    public Cavaleiro(String nome, int nivel, int vida, int forca, int defesa, int magia) {
        super(nome, nivel, vida, forca, defesa, magia);
        this.nome = nome;
        this.nivel= 1;
        this.forca = 9;
        this.vida = 12;
        this.defesa = 10;
        this.magia = 5;
    }
}
