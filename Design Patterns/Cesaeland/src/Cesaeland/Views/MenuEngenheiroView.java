package Cesaeland.Views;

import Cesaeland.Controllers.EngenheiroController;
import java.util.Scanner;

public class MenuEngenheiroView {
    private Scanner scanner = new Scanner(System.in);
    private EngenheiroController engenheiroController;

    public MenuEngenheiroView(EngenheiroController engenheiroController) {
        this.engenheiroController = engenheiroController;
    }

    public void executarMenuEngenheiro() {
        int opcao;

        do {
            System.out.println("\n===== MENU ENGENHEIRO DE MANUTENÇÃO =====");
            System.out.println("1 - Consultar próximas revisões");
            System.out.println("2 - Consultar histórico de revisões");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    engenheiroController.consultarProximasRevisoes();
                    break;
                case 2:
                    engenheiroController.consultarHistoricoRevisoes();
                    break;
                case 0:
                    System.out.println("A sair do menu Engenheiro...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}