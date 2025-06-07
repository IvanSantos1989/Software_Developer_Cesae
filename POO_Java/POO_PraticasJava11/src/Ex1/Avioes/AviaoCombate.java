package Ex1.Avioes;

import Ex1.Enums.Arma;

import java.util.ArrayList;

public class AviaoCombate extends Aviao {
    private String paisOrigem;
    private boolean camuflagem;
    private ArrayList<Arma> arsenal;

    public AviaoCombate(int serial, String modelo, int anoFabrico, double peso, double cmpFuselagem, double envAsas, double altCauda, int numMotores, double autonomia, double velocidadeMax, double preco, String paisOrigem, boolean camuflagem) {
        super(serial, modelo, anoFabrico, peso, cmpFuselagem, envAsas, altCauda, numMotores, autonomia, velocidadeMax, preco);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.arsenal = new ArrayList<Arma>();
    }

    public void adicionarArma(Arma armaNova) {
        if (this.arsenal.size() < 3) {
            this.arsenal.add(armaNova);
        }
    }

    public void removerArma(Arma armaRemover) {
        this.arsenal.remove(armaRemover);
    }

//    public void exibirDetalhesAviaoCombate() {
//        super.exibirDetalhes();
//        System.out.println("País Origem: " + this.paisOrigem + " | Camuflagem: " + this.camuflagem);
//        System.out.println("Arsenal: " + this.arsenal);
//    }

    public void demonstrarArsenal(){
        System.out.println("\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8\uD83E\uDDE8");
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("País Origem: " + this.paisOrigem + " | Camuflagem: " + this.camuflagem);
        System.out.println("Arsenal: " + this.arsenal);
    }
}