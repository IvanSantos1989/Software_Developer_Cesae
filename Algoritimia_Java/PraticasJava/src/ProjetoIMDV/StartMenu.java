package ProjetoIMDV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StartMenu {

    public static void main(String[] args) throws FileNotFoundException {
        printMainMenu();
    }

    public static void printMainMenu() throws FileNotFoundException {

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

                    // Pedir ao utilizador o nome de utilizador e a password apenas uma vez
                    Scanner inputAdmin = new Scanner(System.in);
                    System.out.print("Digite o seu nome de utilizador: ");
                    String username = inputAdmin.nextLine();
                    System.out.print("Digite a sua password: ");
                    String password = inputAdmin.nextLine();

                    // Abrir e ler o ficheiro CSV
                    File ficheiroUtilizadores = new File("FicheirosIMDV/IMDV_AdminLogin.csv");
                    Scanner readerUtilizadores = new Scanner(ficheiroUtilizadores);

                    boolean loginValido = false;
                    while (readerUtilizadores.hasNextLine()) {
                        String linha = readerUtilizadores.nextLine();
                        String[] partes = linha.split(";");
                        if (partes.length == 2) {
                            String nomeUtilizador = partes[0].trim();
                            String senha = partes[1].trim();

                            if (username.equals(nomeUtilizador) && password.equals(senha)) {
                                loginValido = true;
                                break; // achou, sai do while
                            }
                        }
                    }

                    if (loginValido) {
                        System.out.println("Login realizado com sucesso!");
                        AdminMenu.printAdminMenu();
                    } else {
                        System.out.println("Nome de utilizador ou password incorretos. Tente novamente.");
                    }

                    break;



                case 2:
                            System.out.println("Você selecionou o MENU CLIENTE.");
                            ClientMenu.printClientMenu();
                            break;
                        case 3:
                            System.out.println("Saindo da plataforma IMDV...");
                            break;
                        default:
                            System.out.println("Opção inválida! Selecione 1 ou 2 para menus ou 3 para sair.");
                            break;
                    }
            }
            while (opcao != 3) ;
        }
    }