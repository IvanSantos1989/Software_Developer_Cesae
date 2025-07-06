package Cesae_Resort.View;

import Cesae_Resort.Models.Quarto;
import java.util.ArrayList;

/**
 * Classe responsável por exibir informações sobre os quartos disponíveis para o cliente.
 * Exibe uma lista de quartos com suas tipologias e preços.
 */

public class ClienteView {
    public void mostrarQuartos(ArrayList<Quarto> quartos) {
        System.out.println("\nQuartos Disponíveis:");
        System.out.println("Num | Tipologia | Preço/semana");
        for (Quarto q : quartos) {
            System.out.printf("%3d | %-9s | %.2f€\n", q.getNumQuarto(), q.getTipologia(), q.getPrecoPorSemana());
        }
    }
}