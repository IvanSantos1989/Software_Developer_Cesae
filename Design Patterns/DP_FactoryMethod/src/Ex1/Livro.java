package Ex1;

public class Livro extends Produto {

    public Livro(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Isto é um livro: " + super.descricao);
    }
}