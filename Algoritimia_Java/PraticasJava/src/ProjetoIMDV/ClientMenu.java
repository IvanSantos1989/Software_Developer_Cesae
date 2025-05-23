package ProjetoIMDV;

import java.util.Scanner;

public class ClientMenu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("MENU CLIENTE");
            System.out.println("Selecione uma opção de Menu:");
            System.out.println("1. Avaliar um filme");
            System.out.println("2. Ver o total de ratings");
            System.out.println("3. Ver todos os estúdios avaliados");
            System.out.println("4. Voltar ao menu principal");
            System.out.println("5. Sair do plataforma IMDV");
            System.out.println("__________________________________________");

            System.out.print("Qual a sua opção? ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    // Implementar a lógica para avaliar um filme
                    break;

                case 2:
                    // Implementar a lógica para ver o total de ratings
                    break;

                case 3:
                    // Implementar a lógica para ver todos os estúdios avaliados
                    break;

                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;

                case 5:
                    System.out.println("Saindo do plataforma IMDV...");
                    break;

                default:
                    System.out.println("Opção inválida! Selecione 1, 2, 3, 4 ou 5.");
                    break;
            }
        } while (opcao != 5);
    }
}
