package Cesae_Resort.Controllers;

import Cesae_Resort.Models.Quarto;
import Cesae_Resort.Models.QuartoModel;
import Cesae_Resort.View.ClienteView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar as funcionalidades do cliente no resort.
 * Permite ao cliente consultar quartos disponíveis, experiências e avaliar experiências.
 */
public class ClienteController {
    public void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n-- Menu Cliente --");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis");
            System.out.println("3. Consultar Experiência Favorita");
            System.out.println("4. Consultar Experiência Top-Seller");
            System.out.println("5. Avaliar uma Experiência");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    consultarQuartosDisponiveis(); // opção escolhida por mim para implementação
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Funcionalidade não implementada.");
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Consulta os quartos disponíveis no resort.
     * Exibe uma lista de quartos com suas tipologias e preços por semana.
     */
    public void consultarQuartosDisponiveis() {
        QuartoModel quartoModel = new QuartoModel();
        ArrayList<Quarto> quartos = quartoModel.getTodosOsQuartos();

        ClienteView view = new ClienteView();
        view.mostrarQuartos(quartos);
    }

    // Só assinaturas para Javadoc:
    public void consultarExperienciasDisponiveis() {}
    public void consultarExperienciaFavorita() {}
    public void consultarExperienciaTopSeller() {}
    public void avaliarExperiencia() {}
}