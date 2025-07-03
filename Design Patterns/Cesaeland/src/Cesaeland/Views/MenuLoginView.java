package Cesaeland.Views;

import Cesaeland.Controllers.ClientController;
import Cesaeland.Controllers.EngenheiroController;
import Cesaeland.Controllers.AdminController;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLoginView {
    private Scanner scanner = new Scanner(System.in);

    // Example: these would be loaded from files in your real application
    private ArrayList atracoes = new ArrayList<>();
    private ArrayList vendas = new ArrayList<>();

    public int mostrarMenuLogin() {
        System.out.println("\n===== CESAELAND LOGIN =====");
        System.out.println("1 - Cliente");
        System.out.println("2 - Engenheiro de Manutenção");
        System.out.println("3 - Administrador");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
        return scanner.nextInt();
    }

    public String lerUsername() {
        System.out.print("Username: ");
        return scanner.next();
    }

    public String lerPassword() {
        System.out.print("Password: ");
        return scanner.next();
    }

    public void executarMenuLogin() {
        int opcao;

        do {
            opcao = mostrarMenuLogin();

            switch (opcao) {
                case 1:
                    System.out.println("[LOGIN] A entrar como Cliente (sem autenticação)...");
                    ClientController clientController = new ClientController(atracoes);
                    MenuClienteView menuCliente = new MenuClienteView(clientController);
                    menuCliente.executarMenuCliente();
                    break;
                case 2:
                    System.out.println("[LOGIN] Engenheiro selecionado.");
                    String userEng = lerUsername();
                    String passEng = lerPassword();
                    // TODO: Authenticate engineer using userEng and passEng
                    EngenheiroController engController = new EngenheiroController();
                    MenuEngenheiroView menuEng = new MenuEngenheiroView(engController);
                    menuEng.executarMenuEngenheiro();
                    break;
                case 3:
                    System.out.println("[LOGIN] Administrador selecionado.");
                    String userAdmin = lerUsername();
                    String passAdmin = lerPassword();
                    // TODO: Authenticate admin using userAdmin and passAdmin
                    AdminController adminController = new AdminController(atracoes, vendas);
                    MenuAdminView menuAdmin = new MenuAdminView(adminController);
                    menuAdmin.executarMenuAdmin();
                    break;
                case 0:
                    System.out.println("A sair da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}