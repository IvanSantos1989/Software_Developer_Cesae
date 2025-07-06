package Cesae_Resort.Models;

/** * Classe que representa uma venda de experiência no Cesae Resort.
 * Contém informações sobre a experiência vendida e o tipo de cliente (adulto ou criança).
 */
public class VendaExperiencia {
    private String idExperiencia;
    private String tipoCliente; // "adulto" ou "crianca"

    public VendaExperiencia(String idExperiencia, String tipoCliente) {
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
    }

    public String getIdExperiencia() { return idExperiencia; }
    public String getTipoCliente() { return tipoCliente; }
}