package Ex3;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome;
    private String cor;
    private int anoFabrico;
    private int numTripulantes;
    private double capacidadeCarga;
    private MarcaBarco marca;
    private ArrayList<Peixe> peixesPescado;
    private ArrayList<Marisco> mariscoPescado;

    public BarcoPesca(String nome, String cor, int anoFabrico, int numTripulantes, double capacidadeCarga, MarcaBarco marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.numTripulantes = numTripulantes;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.peixesPescado = new ArrayList<Peixe>();
        this.mariscoPescado = new ArrayList<Marisco>();
    }

    public void pescarPeixe(Peixe peixeNovo) {

        if (this.cargaAtual() + peixeNovo.getPeso() <= this.capacidadeCarga) {
            // Barco pode com o peixe novo, já tendo em conta a carga atual (o que já está pescado)
            this.peixesPescado.add(peixeNovo);
            System.out.println(peixeNovo.getPeso() + " Kg. de " + peixeNovo.getEspecie() + " pescados.");
        } else {
            // Barco não tem capacidade para aguentar com este peixe novo
            System.out.println("O " + this.nome + " não tem capacidade para pescar " + peixeNovo.getEspecie());
        }

    }

    public void pescarMarisco(Marisco mariscoNovo) {

        if (this.cargaAtual() + mariscoNovo.getPeso() <= this.capacidadeCarga) {
            // Barco pode com o marisco novo, já tendo em conta a carga atual (o que já está pescado)
            this.mariscoPescado.add(mariscoNovo);
            System.out.println(mariscoNovo.getPeso() + " Kg. de " + mariscoNovo.getEspecie() + " pescados.");
        } else {
            // Barco não tem capacidade para aguentar com este marisco novo
            System.out.println("O " + this.nome + " não tem capacidade para pescar " + mariscoNovo.getEspecie());
        }

    }

    public void largarPeixe(Peixe peixeLargar) {
        this.peixesPescado.remove(peixeLargar);
        System.out.println(peixeLargar.getEspecie() + " largados...");
    }

    public void largarMarisco(Marisco mariscoLargar) {
        this.mariscoPescado.remove(mariscoLargar);
        System.out.println(mariscoLargar.getEspecie() + " largados...");
    }

    public double cargaAtual() {
        double cargaAtual = 0;

        for (Peixe peixeAtual : this.peixesPescado) {
            cargaAtual += peixeAtual.getPeso();
        }

        for (Marisco mariscoAtual : this.mariscoPescado) {
            cargaAtual += mariscoAtual.getPeso();
        }

        return cargaAtual;
    }


    public double calcularValorTotal() {
        double valorTotal = 0;

        for (Peixe peixeAtual : this.peixesPescado) {
            valorTotal += peixeAtual.getPeso() * peixeAtual.getPrecoKg();
        }

        for (Marisco mariscoAtual : this.mariscoPescado) {
            valorTotal += mariscoAtual.getPeso() * mariscoAtual.getPrecoKg();
        }

        return valorTotal;
    }

    public double salarioTripulacao() {
        return (this.calcularValorTotal() * 0.6) / this.numTripulantes;
    }


    public void exibirDetalhes() {
        System.out.println("\n********** " + this.nome + " | " + this.cor + " | Ano Construção: " + this.anoFabrico + " | " + this.marca + " **********");
        System.out.println("Num. Tripulantes: " + this.numTripulantes + " | Carga: " + this.cargaAtual() + "/" + this.capacidadeCarga + " Kg. | " + this.calcularValorTotal() + " €" + " | Salário Atual Individual: " + this.salarioTripulacao() + " €");
        System.out.println("\nCarga de Peixe: ");

        // Listar o peixe
        for (Peixe peixeAtual : this.peixesPescado) {
            peixeAtual.exibirDetalhes();
        }

        System.out.println("\nCarga de Marisco: ");
        // Listar o marisco
        for (Marisco mariscoAtual : this.mariscoPescado) {
            mariscoAtual.exibirDetalhes();
        }

        System.out.println("\n********************************************************************************\n");
    }
}