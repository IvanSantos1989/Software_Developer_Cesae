package Ex1;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
    private int cc;

    public Pessoa(String nome, int idade, double altura, int cc) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.cc = cc;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public double getAltura() {
        return altura;
    }

    public int getCc() {
        return cc;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}