package Ex1;

public class Roupa extends Produto {

    public Roupa(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Isto é uma roupa: " + super.descricao);
    }
}