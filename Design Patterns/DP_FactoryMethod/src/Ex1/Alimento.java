package Ex1;

public class Alimento extends Produto {

    public Alimento(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Isto é um alimento: " + super.descricao);
    }
}