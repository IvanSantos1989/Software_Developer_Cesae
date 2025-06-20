package Ex1;

public class Eletronico extends Produto{
    public Eletronico(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Isto é um produto eletrónico: " + super.descricao);
    }
}