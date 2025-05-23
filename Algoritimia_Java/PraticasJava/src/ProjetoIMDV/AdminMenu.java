package ProjetoIMDV;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Bibliotecas.FunctionsAdmin.*;

public class AdminMenu {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("MENU ADMIN");
            System.out.println("Selecione uma opção de Menu:");
            System.out.println("1. Consultar ficheiro de ratings");
            System.out.println("2. Ver o total de ratings");
            System.out.println("3. Ver todos os estúdios avaliados");
            System.out.println("4. Voltar ao menu principal");
            System.out.println("5. Sair do plataforma IMDV");
            System.out.println("__________________________________________");

            System.out.print("Qual a sua opção? ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Consultando ficheiro de ratings...");
                    System.out.println();
                    imprimirFicheiro("FicheirosIMDV/IMDV.csv");
                    break;

                case 2:
                    System.out.println("Verificando o total de ratings...");
                    System.out.println();
                    linhasRatings("FicheirosIMDV/IMDV.csv");
                    break;

                case 3:
                    System.out.println("Verificando todos os estúdios avaliados...");
                    System.out.println();
                    listarEstudios("FicheirosIMDV/IMDV.csv");
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