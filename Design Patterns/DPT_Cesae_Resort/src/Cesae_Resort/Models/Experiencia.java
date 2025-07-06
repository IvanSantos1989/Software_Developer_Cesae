package Cesae_Resort.Models;

/**
 * Classe que representa uma experiência no Cesae Resort.
 * Contém informações sobre o ID, nome, guia responsável e preços para adultos e crianças.
 */
public class Experiencia {
    private String id;
    private String nome;
    private String idGuia;
    private double precoAdulto;
    private double precoCrianca;

    public Experiencia(String id, String nome, String idGuia, double precoAdulto, double precoCrianca) {
        this.id = id;
        this.nome = nome;
        this.idGuia = idGuia;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getIdGuia() { return idGuia; }
    public double getPrecoAdulto() { return precoAdulto; }
    public double getPrecoCrianca() { return precoCrianca; }
}