package Ex2;

import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private String nome;
    private double premio;
    private ArrayList<Pessoa> listaParticipantes;

    public Sorteio(String nome, double premio) {
        this.nome = nome;
        this.premio = premio;
        this.listaParticipantes = new ArrayList<Pessoa>();
    }

    public void inscreverParticipante(Pessoa novoParticipante) {

        if (novoParticipante.getIdade() >= 18) {
            this.listaParticipantes.add(novoParticipante);
            System.out.println("Inscrito com sucesso: " + novoParticipante.getNome());
        } else {
            System.out.println("Inscrição recusada: " + novoParticipante.getNome() + " é menor de idade.");
        }

    }

    public void listarParticipantes() {
        System.out.println("\n*_*_*_*_*_*_*_*_*_* " + this.nome + " | " + this.premio + " € *_*_*_*_*_*_*_*_*_*");

        int contadorPessoas = 1;

        for (Pessoa pessoaAtual : this.listaParticipantes) {
            System.out.print("Inscrito Nº" + contadorPessoas++ + ": ");
            pessoaAtual.exibirDetalhes();
        }
    }

    public Pessoa sortearVencedor() {

        Random rd = new Random();

        int indexVencedor = rd.nextInt(this.listaParticipantes.size());

        return this.listaParticipantes.get(indexVencedor);
    }
}