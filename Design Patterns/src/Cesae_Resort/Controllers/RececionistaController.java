package Cesae_Resort.Controllers;

import Cesae_Resort.Models.Quarto;
import Cesae_Resort.Models.QuartoModel;
import Cesae_Resort.Models.Reserva;
import Cesae_Resort.Models.ReservaModel;
import Cesae_Resort.View.RececionistaView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por controlar as ações do recepcionista no Cesae Resort.
 * Permite ao recepcionista consultar quartos disponíveis, quartos reservados,
 * reservas atuais, efetuar reservas e reservar experiências.
 */
public class RececionistaController {
    public void menuRececionista() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n-- Menu Rececionista --");
            System.out.println("1. Consultar Quartos Disponíveis (semana atual)");
            System.out.println("2. Consultar Quartos Reservados");
            System.out.println("3. Consultar Reservas Atuais (semana atual)");
            System.out.println("4. Efetuar uma Reserva");
            System.out.println("5. Reservar uma Experiência");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 2:
                    consultarQuartosReservados(); // única funcionalidade implementada
                    break;
                case 1:
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
     * Consulta os quartos reservados no resort.
     * Exibe uma lista de reservas com o número do quarto, tipologia, ID do cliente,
     * ano, mês e semana da reserva.
     */
    public void consultarQuartosReservados() {
        ReservaModel reservaModel = new ReservaModel();
        QuartoModel quartoModel = new QuartoModel();
        ArrayList<Reserva> reservas = reservaModel.carregarReservas();
        ArrayList<Quarto> quartos = quartoModel.getTodosOsQuartos();

        RececionistaView view = new RececionistaView();
        view.mostrarReservas(reservas, quartos);
    }

    // Só assinaturas para Javadoc:
    public void consultarQuartosDisponiveisSemanaAtual() {}
    public void consultarReservasAtuais() {}
    public void efetuarReserva() {}
    public void reservarExperiencia() {}
}