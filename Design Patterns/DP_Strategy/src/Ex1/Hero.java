package Ex1;

public class Hero {
    private String nome;
    private int vida;
    private int forca;

    private AttackStrategy formaAtaque;

    public Hero(String nome, int vida, int forca, AttackStrategy formaAtaque) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.formaAtaque = formaAtaque;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public void setFormaAtaque(AttackStrategy formaAtaque) {
        this.formaAtaque = formaAtaque;
    }

    public void attack() {
        this.formaAtaque.attack();
    }
}