package Cesaeland.Views;

import java.util.Scanner;

public class MenuAdminView {
    private Scanner scanner = new Scanner(System.in);
    private AdminController adminController;

    // Construtor que recebe o controlador
    public MenuAdminView(AdminController adminController) {
        this.adminController = adminController;
    }

    public void executarMenuAdmin() {
        int opcao;

        do {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("1 - Consultar total de vendas");
            System.out.println("2 - Consultar total de lucro");
            System.out.println("3 - Consultar vendas e lucro por mês");
            System.out.println("4 - Atração mais procurada (adultos)");
            System.out.println("5 - Atração mais procurada (crianças)");
            System.out.println("6 - Atração mais procurada (geral)");
            System.out.println("7 - Atração mais lucrativa");
            System.out.println("8 - Atração menos lucrativa");
            System.out.println("9 - Atração com melhor preço/tempo");
            System.out.println("10 - Adicionar novo login");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adminController.consultarTotalVendas();
                    break;
                case 2:
                    adminController.consultarLucroTotal();
                    break;
                case 3:
                    adminController.consultarVendasLucroPorMes();
                    break;
                case 4:
                    adminController.atracaoMaisProcuradaPorAdultos();
                    break;
                case 5:
                    adminController.atracaoMaisProcuradaPorCriancas();
                    break;
                case 6:
                    adminController.atracaoMaisProcuradaGeral();
                    break;
                case 7:
                    adminController.atracaoMaisLucrativa();
                    break;
                case 8:
                    adminController.atracaoMenosLucrativa();
                    break;
                case 9:
                    adminController.atracaoMelhorPrecoTempo();
                    break;
                case 10:
                    adminController.adicionarNovoLogin();
                    break;
                case 0:
                    System.out.println("A sair do menu Administrador...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}