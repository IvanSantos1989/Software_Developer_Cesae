package Ex1;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int anoFabrico;
    private int potenciaCv;
    private int cc;
    private TipoCombustivel combustivel;
    private double consumoL100Km;

    public Carro(String marca, String modelo, String cor, int anoFabrico, int potenciaCv, int cc, TipoCombustivel combustivel, double consumoL100Km) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.potenciaCv = potenciaCv;
        this.cc = cc;
        this.combustivel = combustivel;
        this.consumoL100Km = consumoL100Km;
    }

    public int getIdade() {
        return 2025 - this.anoFabrico;
    }

    public void ligar() {

        if (this.getIdade() > 30) { // Carro com mais de 30 anos

            if (this.combustivel.equals(TipoCombustivel.DIESEL)) {
                System.out.println("Deita um pouco de fumo... Custa a pegar... O carro está ligado!");
                System.out.println("Vrum-vrum-vrum");
            } else {
                System.out.println("Custa a pegar... O carro está ligado!");
                System.out.println("Vrum-vrum-vrum");
            }

        } else { // Carro recente

            if (this.potenciaCv >= 250) {
                System.out.println("O carro está ligado!");
                System.out.println("VRUMMMMMMMMMMMM");
            } else {
                System.out.println("O carro está ligado!");
                System.out.println("Vrummmmmmmmmmmm");
            }

        }

    }

    public Carro corrida(Carro adversario) {

        if (this.potenciaCv > adversario.potenciaCv) {
            // Ganha o meu carro por cv
            return this;
        } else {

            if (this.potenciaCv < adversario.potenciaCv) {
                // Ganha o adversario por cv
                return adversario;
            } else {
                // Empate de cv

                if (this.cc > adversario.cc) {
                    // Ganha o meu carro por cc
                    return this;
                } else {

                    if (this.cc < adversario.cc) {
                        // Ganha o adversario por cc
                        return adversario;
                    } else {
                        // Empate de cc

                        if (this.getIdade() < adversario.getIdade()) {
                            // Ganha o meu carro por idade
                            return this;
                        } else {

                            if (this.getIdade() > adversario.getIdade()) {
                                // Ganha o adversario por idade
                                return adversario;
                            } else {
                                // Empate
                                return null;
                            }

                        }
                    }

                }

            }

        }
    }

    public void exibirDetalhes() {
        System.out.println(this.marca + " " + this.modelo + " | " + this.anoFabrico + " | " + this.cor);
    }
}