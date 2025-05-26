package ProjetoIMDV;

import java.util.Scanner;

public class ClientMenu {
    public static void printClientMenu()  {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("MENU CLIENTE");
            System.out.println("Selecione uma opção de Menu:");
            System.out.println("1. Novo Registo:");
            System.out.println("2. Ver catálogo de filmes.");
            System.out.println("3. Ver catálogos gráficos.");
            System.out.println("4. Ver o melhor estúdio.");
            System.out.println("5. Ver o pior estúdio.");
            System.out.println("6. Crítica mais recente.");
            System.out.println("7. Quiz de Cinema.");
            System.out.println("8. Pesquisar por estúdio.");
            System.out.println("9. Voltar ao menu principal");

            System.out.print("Qual a sua opção? ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Registar novo utilizador:");
                    Scanner inputRegisto = new Scanner(System.in);
                    System.out.print("Digite o seu nome: ");
                    String nome = inputRegisto.nextLine();
                    System.out.print("Digite o seu telefone: ");
                    String telefone = inputRegisto.nextLine();
                    System.out.print("Digite o seu email: ");
                    String email = inputRegisto.nextLine();
                    System.out.print("Utilizador inserido com sucesso!");
                    System.out.println("Bem-vindo, " + nome + " | Telefone: " + telefone + " | Email: " + email);


                    break;

                case 2:
                    System.out.println("Ver catálogo de filmes:");
                    break;

                case 3:
                    System.out.println("Ver catálogos gráficos:");
                    break;

                case 4:
                    System.out.println("Ver o melhor estúdio:");

                    break;
                case 5:
                    System.out.println("Ver o pior estúdio:");

                    break;
                case 6:
                    System.out.println("Crítica mais recente:");

                    break;
                case 7:
                    System.out.println("Quiz de Cinema:");

                    break;
                case 8:
                    System.out.println("Pesquisar por estúdio:");

                    break;
                case 9:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Selecione uma opção válida.");
                    break;
            }
        } while (opcao != 9);
    }

}