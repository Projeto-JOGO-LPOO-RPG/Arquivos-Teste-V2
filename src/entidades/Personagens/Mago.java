package entidades.Personagens;
import entidades.Entidade;

public class Mago extends Entidade {
    public Mago(String nome, int nivel, int vida, int forca, int defesa, int magia) {
        super(nome, nivel, vida, forca, defesa, magia);
        this.nome = nome;
        this.nivel= 1;
        this.forca = 8;
        this.vida = 10;
        this.defesa = 10;
        this.magia = 15;
    }


    @Override
    public void atacar() {
        System.out.println(nome + " lança uma bola de fogo!");
    }
}
