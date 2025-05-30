package Ex8;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeStock = 0;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void adquirirStock(int quantidadeAdquirida) {
        this.quantidadeStock += quantidadeAdquirida;
        System.out.println("Stock de " + this.nome + " adquirido: " + quantidadeAdquirida);
    }

    public void venderStock(int quantidadeVendida) {

        if (this.quantidadeStock >= quantidadeVendida) { // Temos stock para a venda
            this.quantidadeStock -= quantidadeVendida;
            double totalCompra = this.preco * quantidadeVendida;
            System.out.println("Venda de " + this.nome + ": " + quantidadeVendida + " unidades. Total: " + totalCompra + " €");
        } else { // Não temos stock
            System.out.println("Não temos stock de " + this.nome + " suficiente...");
        }

    }

    public void exibirDetalhes() {
        System.out.println(this.nome + " | Preço: " + this.preco + " € | Quant. Stock: " + this.quantidadeStock);
    }
}