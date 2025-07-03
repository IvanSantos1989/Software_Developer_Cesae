package Cesaeland.Models;

public class Atracao {
    private int idAtracao;
    private String nome;
    private double precoAdulto;
    private double precoCrianca;
    private double duracaoSegundos;
    private double custoManutencaoBilhete;
    private double custoFixoMes;

    public Atracao(int idAtracao, String nome, double precoAdulto, double precoCrianca, double duracaoSegundos, double custoManutencaoBilhete, double custoFixoMes) {
        this.idAtracao = idAtracao;
        this.nome = nome;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
        this.duracaoSegundos = duracaoSegundos;
        this.custoManutencaoBilhete = custoManutencaoBilhete;
        this.custoFixoMes = custoFixoMes;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }

    public double getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public double getCustoManutencaoBilhete() {
        return custoManutencaoBilhete;
    }

    public double getCustoFixoMes() {
        return custoFixoMes;
    }
}