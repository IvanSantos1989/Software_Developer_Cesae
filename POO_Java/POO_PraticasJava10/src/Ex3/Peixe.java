package Ex3;

public class Peixe {
    private String especie;
    private double peso;
    private double precoKg;

    public Peixe(String especie, double peso, double precoKg) {
        this.especie = especie;
        this.peso = peso;
        this.precoKg = precoKg;
    }

    public String getEspecie() {
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void exibirDetalhes() {
        System.out.println(this.especie + " | " + this.peso + " Kg. | Preço: " + this.precoKg + " €/Kg.");
    }
}