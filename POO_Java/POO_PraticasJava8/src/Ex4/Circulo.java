package Ex4;

public class Circulo {
    private String cor;
    private double raio;

    public Circulo(double raio) {
        this.cor="Branco";
        this.raio = raio;
    }

    public Circulo(String cor, double raio) {
        this.cor = cor;
        this.raio = raio;
    }

    public double calcularPerimetro() {
        return 2 * 3.14 * this.raio;
        //return 2 * Math.PI * this.raio;
    }

    public double calcularArea() {
        return 3.14 * this.raio * this.raio;
        //return Math.PI * this.raio * this.raio;
    }
}