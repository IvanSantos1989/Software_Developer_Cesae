package Cesaeland.Views;

import Cesaeland.Controllers.ClientController;
import java.util.Scanner;

public class MenuClienteView {
    private Scanner scanner = new Scanner(System.in);
    private ClientController clientController;

    // Constructor receives the controller
    public MenuClienteView(ClientController clientController) {
        this.clientController = clientController;
    }

    public void executarMenuCliente() {
        int opcao;

        do {
            System.out.println("\n===== MENU CLIENTE =====");
            System.out.println("1 - Consultar atrações disponíveis");
            System.out.println("2 - Consultar atrações favoritas");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    clientController.listarAtracoesDisponiveis();
                    break;
                case 2:
                    clientController.listarAtracoesFavoritas();
                    break;
                case 0:
                    System.out.println("A sair do menu Cliente...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}