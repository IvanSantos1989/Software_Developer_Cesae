package Ex6;

public class Atleta {
    private String nome;
    private String modalidadeDesportiva;
    private double altura;
    private double peso;
    private String paisOrigem;
    private int ranking;

    public Atleta(String nome, String modalidadeDesportiva, double altura, double peso, String paisOrigem, int ranking) {
        this.nome = nome;
        this.modalidadeDesportiva = modalidadeDesportiva;
        this.altura = altura;
        this.peso = peso;
        this.paisOrigem = paisOrigem;
        this.ranking = ranking;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void exibirDetalhes() {
        System.out.println(this.nome + " | " + this.modalidadeDesportiva + " | " + this.paisOrigem + " | Ranking: " + this.ranking);
    }
}