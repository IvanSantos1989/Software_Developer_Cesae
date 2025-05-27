package ProjetoIMDV;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Bibliotecas.FunctionsClient.*;

public class ClientMenu {
    public static void printClientMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println();
            System.out.println("MENU CLIENTE");
            System.out.println("Selecione uma opção de Menu:");
            System.out.println("1.  Novo Registo:");
            System.out.println("2.  Ver catálogo de filmes.");
            System.out.println("3.  Ver catálogos gráficos.");
            System.out.println("4.  Ver o melhor estúdio.");
            System.out.println("5.  Ver o pior estúdio.");
            System.out.println("6.  Crítica mais recente.");
            System.out.println("7.  Quiz de Cinema.");
            System.out.println("8.  Pesquisar por estúdio.");
            System.out.println("9.  Pesquisar por categoria.");
            System.out.println("10. Voltar ao menu principal");

            System.out.print("Qual a sua opção? ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // Registar novo utilizador
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
                case 2: // Carregar catálogo de filmes
                    System.out.println("\nCarregando catálogo de filmes...");
                    printCatalogoFilmes("FicheirosIMDV/IMDV.csv");

                    break;
                case 3: // Ver catálogos gráficos no txt
                    System.out.println("\nVer catálogos gráficos:");
                    printCatalogoGraficos();

                    break;
                case 4: // Analisar o melhor estúdio pela média de ratings
                    System.out.println("Analisando o melhor estúdio...");
                    melhorEstudio("FicheirosIMDV/IMDV.csv");

                    break;
                case 5: // Analisar o pior estúdio pela média de ratings
                    System.out.println("Analisando o pior estúdio...");
                    piorEstudio("FicheirosIMDV/IMDV.csv");

                    break;
                case 6: // Imprimir a crítica mais recente/última linha do ficheiro
                    System.out.println("Crítica mais recente:");
                    System.out.println();
                    printCriticaMaisRecente("FicheirosIMDV/IMDV.csv");

                    break;
                case 7: // aqui vamos fazer um quiz de cinema perguntando ao utilizador
                    System.out.println("Quiz de Cinema:");
                    System.out.println();
                    displayQuiz("FicheirosIMDV/IMDV_Quiz.csv");

                    break;
                case 8: // Pesquisar por estúdio os filmes que ele produziu
                    System.out.println("\nPesquisar por estúdio:");
                    Scanner inputEstudio = new Scanner(System.in);
                    System.out.print("Digite o nome do estúdio: ");
                    String nomeEstudio = inputEstudio.nextLine();

                    try {
                        printCatalogoEstudio("FicheirosIMDV/IMDV.csv", nomeEstudio);
                    } catch (FileNotFoundException e) {
                        System.out.println("Erro: Ficheiro não encontrado.");
                    }

                    break;
                case 9: // Pesquisar por categoria os filmes que pertencem a essa categoria
                    System.out.print("Digite a categoria a pesquisar: ");
                    Scanner categInput = new Scanner(System.in);
                    String categoria = categInput.nextLine();
                    printCatalogoCategoria("FicheirosIMDV/IMDV.csv", categoria);

                    break;
                case 10:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Selecione uma opção válida entre 1 e 10.");
                    break;
            }
        } while (opcao != 10);
    }
}