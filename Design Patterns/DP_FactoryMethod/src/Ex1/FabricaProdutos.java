package Ex1;

public class FabricaProdutos {

    public static Produto criarProduto(String tipoProduto, String descricao, double preco) {

        switch (tipoProduto) {
            case "livro":
                return new Livro(descricao, preco);
            case "eletronico":
                return new Eletronico(descricao, preco);
            case "roupa":
                return new Roupa(descricao, preco);
            case "alimento":
                return new Alimento(descricao, preco);
            default:
                throw new IllegalArgumentException("Tipo de Produto não reconhecido");
        }
    }
}