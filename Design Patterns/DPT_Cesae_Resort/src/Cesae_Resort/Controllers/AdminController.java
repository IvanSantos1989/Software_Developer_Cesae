package Cesae_Resort.Controllers;

import Cesae_Resort.Models.QuartoModel;
import Cesae_Resort.Models.Quarto;
import Cesae_Resort.View.AdminView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar as funcionalidades do menu do administrador.
 * Permite consultar receitas, reservas mensais, tipologia de quarto mais reservada,
 * experiências mais procuradas e lucrativas, e adicionar novos logins.
 */
public class AdminController {
    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n-- Menu Administrador --");
            System.out.println("1. Consultar Total de reservas, passadas e futuras");
            System.out.println("2. Consultar Total de Receitas");
            System.out.println("3. Consultar Reservas/Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos)");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças)");
            System.out.println("7. Consultar Experiência Mais Lucrativa");
            System.out.println("8. Consultar Experiência Menos Lucrativa");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana");
            System.out.println("10. Adicionar Novo Login");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                    System.out.println("Funcionalidade não implementada.");
                    break;
                case 9:
                    consultarQuartoMelhorPrecoSemana(); // funcionadade escolhida para implementação
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
     * Consulta o quarto com o melhor preço por semana.
     * Percorre todos os quartos cadastrados e exibe aquele com o maior preço por semana.
     */
    public void consultarQuartoMelhorPrecoSemana() {
        QuartoModel quartoModel = new QuartoModel();
        ArrayList<Quarto> quartos = quartoModel.getTodosOsQuartos();
        Quarto melhorQuarto = null;
        for (Quarto q : quartos) {
            if (melhorQuarto == null || q.getPrecoPorSemana() > melhorQuarto.getPrecoPorSemana()) {
                melhorQuarto = q;
            }
        }

        AdminView view = new AdminView();
        view.mostrarQuartoMelhorPrecoSemana(melhorQuarto);
    }

    // Só assinaturas para Javadoc:
    public void consultarTotalReservasPassadasEFuturas() {}
    public void consultarTotalReceitas() {}
    public void consultarReceitasMensais(int ano, int mes) {}
    public void consultarTipologiaQuartoMaisReservada() {}
    public void consultarExperienciaMaisProcuradaAdultos() {}
    public void consultarExperienciaMaisProcuradaCriancas() {}
    public void consultarExperienciaMaisLucrativa() {}
    public void consultarExperienciaMenosLucrativa() {}
    public void adicionarNovoLogin() {}
}