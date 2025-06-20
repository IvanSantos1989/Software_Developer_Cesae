package Ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Produto> stock = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n\n***** Programa de Gestão de Produtos *****");
            System.out.println("1. Novo Produto");
            System.out.println("2. Visualizar Produtos");

            System.out.print("Insira a opção: ");
            opcao = input.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nNovo Produto");

                    // TIPO PRODUTO
                    System.out.print("Tipo Produto ( Livro | Eletronico | Roupa | Alimento ): ");
                    input.nextLine();
                    String tipoProdutoInput = input.nextLine();

                    // DESCRICAO
                    System.out.print("Descrição: ");
                    String descricaoProdutoInput = input.nextLine();

                    // PREÇO
                    System.out.print("Preço: ");
                    double precoProdutoInput = input.nextDouble();

                    // Criar o produto
                    Produto produtoNovo = FabricaProdutos.criarProduto(tipoProdutoInput, descricaoProdutoInput, precoProdutoInput);

                    // Adicionar ao Array
                    stock.add(produtoNovo);

                    break;

                case 2:
                    System.out.println("\nVisualizar Produto");

                    for (Produto produtoAtual : stock) {
                        produtoAtual.exibirInformacoes();
                    }

                    break;

                default:
                    System.out.println("\nOpção Inválida");
            }

        } while (opcao != 0);
    }
}