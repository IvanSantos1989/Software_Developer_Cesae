package Ex3;

public class Retangulo {
    private String cor;
    private double altura;
    private double largura;

    /**
     * Método construtor para Retangulo
     * @param cor Cor do Retângulo
     * @param altura Altura do Retângulo (m.)
     * @param largura Largura do Retângulo (m.)
     */
    public Retangulo(String cor, double altura, double largura) {
        this.cor = cor;
        this.altura = altura;
        this.largura = largura;
    }

    public double calcularPerimetro() {
        return this.largura + this.largura + this.altura + this.altura;
    }

    public double calcularArea() {
        return this.altura * this.largura;
    }
}