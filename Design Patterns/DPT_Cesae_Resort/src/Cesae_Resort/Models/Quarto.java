package Cesae_Resort.Models;

/**
 * Classe que representa um quarto no resort.
 * Cada quarto tem um número e uma tipologia associada.
 */

public class Quarto {
    private int numQuarto;
    private Tipologia tipologia;

    public Quarto(int numQuarto, Tipologia tipologia) {
        this.numQuarto = numQuarto;
        this.tipologia = tipologia;
    }

    public int getNumQuarto() { return numQuarto; }
    public String getTipologia() { return tipologia.getDescricao(); }
    public double getPrecoPorSemana() { return tipologia.getPrecoPorSemana(); }
}