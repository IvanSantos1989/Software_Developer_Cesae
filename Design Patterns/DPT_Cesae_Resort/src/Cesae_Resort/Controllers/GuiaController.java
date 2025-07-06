package Cesae_Resort.Controllers;

import Cesae_Resort.Models.Experiencia;
import Cesae_Resort.Models.ExperienciaModel;
import Cesae_Resort.Models.VendaExperiencia;
import Cesae_Resort.Models.VendaExperienciaModel;
import Cesae_Resort.View.GuiaView;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por controlar as ações do guia no Cesae Resort.
 * Permite ao guia consultar o histórico de experiências que ele gerencia.
 */
public class GuiaController {
    private String idGuia;

    public GuiaController(String idGuia) {
        this.idGuia = idGuia;
    }

    public void menuGuia() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n-- Menu Guia --");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    consultarHistoricoExperiencias(); // única funcionalidade no menu do guia
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
     * Consulta o histórico de experiências gerenciadas pelo guia.
     * Exibe uma lista de experiências com o número de crianças, adultos e o total arrecadado.
     */
    public void consultarHistoricoExperiencias() {
        ExperienciaModel experienciaModel = new ExperienciaModel();
        VendaExperienciaModel vendaModel = new VendaExperienciaModel();
        ArrayList<Experiencia> experiencias = experienciaModel.carregarExperiencias();
        ArrayList<VendaExperiencia> vendas = vendaModel.carregarVendas();
        ArrayList<Experiencia> minhasExperiencias = new ArrayList<>();

        for (Experiencia exp : experiencias) {
            if (exp.getIdGuia().equals(idGuia)) {
                minhasExperiencias.add(exp);
            }
        }

        GuiaView view = new GuiaView();
        view.mostrarHistorico(minhasExperiencias, vendas);
    }
}