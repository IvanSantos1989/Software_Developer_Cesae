package Ex5;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;
    private String email;
    private int telemovel;

    public Pessoa(String nome, int idade, String cidade, String email, int telemovel) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public String getCidade() {
        return cidade;
    }

    public void exibirDetalhes() {
        System.out.println(this.nome + " | Idade: " + this.idade + " | " + this.cidade + " | " + this.email + " | " + this.telemovel);
    }
}