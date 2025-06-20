package Ex1;

public abstract class Produto {

    protected String descricao;
    protected double preco;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public abstract void exibirInformacoes();
}