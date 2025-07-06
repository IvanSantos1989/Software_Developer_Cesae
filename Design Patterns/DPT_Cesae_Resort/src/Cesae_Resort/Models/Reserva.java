package Cesae_Resort.Models;

/**
 * Classe que representa uma reserva de quarto no Cesae Resort.
 * Contém informações sobre o número do quarto, ID do cliente e datas da reserva.
 */
public class Reserva {
    private int numQuarto;
    private String idCliente;
    private int ano;
    private int mes;
    private int semana;

    public Reserva(int numQuarto, String idCliente, int ano, int mes, int semana) {
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    public int getNumQuarto() { return numQuarto; }
    public String getIdCliente() { return idCliente; }
    public int getAno() { return ano; }
    public int getMes() { return mes; }
    public int getSemana() { return semana; }
}