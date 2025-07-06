package Cesae_Resort.View;

import Cesae_Resort.Models.Quarto;

/**
 * Classe responsável por exibir informações administrativas do Cesae Resort.
 * Exibe o quarto com melhor preço por semana.
 */
public class AdminView {
    public void mostrarQuartoMelhorPrecoSemana(Quarto melhorQuarto) {
        if (melhorQuarto != null) {
            System.out.println("Quarto com melhor preço/semana:");
            System.out.println("Num: " + melhorQuarto.getNumQuarto() +
                    ", Tipologia: " + melhorQuarto.getTipologia() +
                    ", Preço/semana: " + melhorQuarto.getPrecoPorSemana());
        } else {
            System.out.println("Não existem quartos cadastrados.");
        }
    }
}