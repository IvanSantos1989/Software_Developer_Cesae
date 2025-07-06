package Cesae_Resort.View;

import Cesae_Resort.Models.Experiencia;
import Cesae_Resort.Models.VendaExperiencia;
import java.util.ArrayList;

/**
 * Classe responsável por exibir o histórico de experiências de um guia.
 * Exibe o nome da experiência, número de crianças e adultos, e o total arrecadado.
 */
public class GuiaView {
    public void mostrarHistorico(ArrayList<Experiencia> experiencias, ArrayList<VendaExperiencia> vendas) {
        System.out.println("\nHistórico de Experiências deste Guia:");
        System.out.println("Experiência         | Crianças | Adultos | Total €");
        for (Experiencia exp : experiencias) {
            int totalCriancas = 0;
            int totalAdultos = 0;
            double totalValor = 0;
            for (VendaExperiencia venda : vendas) {
                if (venda.getIdExperiencia().equals(exp.getId())) {
                    if (venda.getTipoCliente().equals("crianca")) {
                        totalCriancas++;
                        totalValor += exp.getPrecoCrianca();
                    } else if (venda.getTipoCliente().equals("adulto")) {
                        totalAdultos++;
                        totalValor += exp.getPrecoAdulto();
                    }
                }
            }
            System.out.printf("%-20s | %8d | %7d | %7.2f\n", exp.getNome(), totalCriancas, totalAdultos, totalValor);
        }
    }
}