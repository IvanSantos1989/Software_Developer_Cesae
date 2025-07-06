package Cesae_Resort;

import Cesae_Resort.Models.LoginModel;
import Cesae_Resort.Controllers.ClienteController;
import Cesae_Resort.Controllers.RececionistaController;
import Cesae_Resort.Controllers.GuiaController;
import Cesae_Resort.Controllers.AdminController;
import java.util.Scanner;

/**
 * menu principal onde o utilizador pode escolher entre o menu do cliente ou fazer login a depender do seu perfil e ver algumas funcionalidades
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- CESAE Resort -----");
            System.out.println("1. Menu Cliente (acesso público)");
            System.out.println("2. Login (Admin/Rececionista/Guia)");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                ClienteController clienteController = new ClienteController();
                clienteController.menuCliente();

            } else if (opcao == 2) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                LoginModel loginModel = new LoginModel();
                String tipoAcesso = loginModel.autenticar(username, password);

                if (tipoAcesso == null) {
                    System.out.println("Credenciais inválidas!");
                } else if (tipoAcesso.equalsIgnoreCase("ADMIN")) {
                    AdminController adminController = new AdminController();
                    adminController.menuAdmin();
                } else if (tipoAcesso.equalsIgnoreCase("GESTAO")) {
                    RececionistaController rececionistaController = new RececionistaController();
                    rececionistaController.menuRececionista();
                } else if (tipoAcesso.equalsIgnoreCase("GUIA")) {
                    GuiaController guiaController = new GuiaController(username);
                    guiaController.menuGuia();
                } else {
                    System.out.println("Perfil não reconhecido!");
                }
            } else if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}