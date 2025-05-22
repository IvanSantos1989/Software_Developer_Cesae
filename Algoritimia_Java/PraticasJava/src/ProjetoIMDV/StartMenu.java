package ProjetoIMDV;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("Bem-vindo ao IMDV!");
            System.out.println("Selecione uma opção de Menu:");
            System.out.println("1. MENU ADMIN");
            System.out.println("2. MENU CLIENTE");
            System.out.println("3. Sair da plataforma IMDV");
            System.out.println("__________________________________________");

            System.out.println();
            System.out.print("Digite a opção desejada: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou o MENU ADMIN.");

                    break;
                case 2:
                    System.out.println("Você selecionou o MENU CLIENTE.");

                    break;
                case 3:
                    System.out.println("Saindo da plataforma IMDV...");
                    break;
                default:
                    System.out.println("Opção inválida! Selecione 1 ou 2 para menus ou 3 para sair.");
                    break;
            }
        } while (opcao != 3);
    }
}