package ProjetoIMDV;

import Bibliotecas.FunctionsAdmin;
import Bibliotecas.FunctionsClient;

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
            System.out.print("Qual o seu tipo de utilizador? ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você selecionou o MENU ADMIN.");
                    Scanner inputAdmin = new Scanner(System.in);
                    System.out.print("Qual o seu utilizador? ");
                    String utilizador = inputAdmin.nextLine();
                    System.out.print("Qual a sua password? ");
                    String password = inputAdmin.nextLine();
                    // Verifica se o utilizador e a password estão corretos baseando-se num ficheiro com array
                    // de strings com os utilizadores e passwords
                    String[][] utilizadores = FunctionsAdmin.lerFicheiroUtilizadores("FicheirosIMDV/IMDV_AdminLogin.csv");



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