package Ex1.Avioes;

public class Aviao {
    private int serial;
    private String modelo;
    private int anoFabrico;
    private double peso;
    private double cmpFuselagem;
    private double envAsas;
    private double altCauda;
    private int numMotores;
    private double autonomia;
    private double velocidadeMax;
    private double preco;

    public Aviao(int serial, String modelo, int anoFabrico, double peso, double cmpFuselagem, double envAsas, double altCauda, int numMotores, double autonomia, double velocidadeMax, double preco) {
        this.serial = serial;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.peso = peso;
        this.cmpFuselagem = cmpFuselagem;
        this.envAsas = envAsas;
        this.altCauda = altCauda;
        this.numMotores = numMotores;
        this.autonomia = autonomia;
        this.velocidadeMax = velocidadeMax;
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println(this.modelo + " | " + this.anoFabrico + " | " + this.serial + " | Preço: " + this.preco + " €");
        System.out.println("Específicações Técnicas - Peso: " + this.peso + " Kg. | Cmp. Fuselagem: " + this.cmpFuselagem + " m. | Env. Asas: " + this.envAsas + " m.");
        System.out.println("Características - Num. Motores: " + this.numMotores + " | Autonomia: " + this.autonomia + " Km. | Vel. Máx: " + this.velocidadeMax + " Km/h");

    }
}