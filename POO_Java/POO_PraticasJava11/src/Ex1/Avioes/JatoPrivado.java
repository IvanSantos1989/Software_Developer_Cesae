package Ex1.Avioes;

import Ex1.Enums.CategoriaJato;
import Ex1.Enums.InstalacaoJato;

import java.util.ArrayList;

public class JatoPrivado extends Aviao {

    private int lotacao;
    private double capacidadeBagagem;
    private CategoriaJato categoria;
    private ArrayList<InstalacaoJato> comodidades;

    public JatoPrivado(int serial, String modelo, int anoFabrico, double peso, double cmpFuselagem, double envAsas, double altCauda, int numMotores, double autonomia, double velocidadeMax, double preco, int lotacao, double capacidadeBagagem, CategoriaJato categoria) {
        super(serial, modelo, anoFabrico, peso, cmpFuselagem, envAsas, altCauda, numMotores, autonomia, velocidadeMax, preco);
        this.lotacao = lotacao;
        this.capacidadeBagagem = capacidadeBagagem;
        this.categoria = categoria;
        this.comodidades = new ArrayList<InstalacaoJato>();
    }

    public void adicionarInstalacao(InstalacaoJato instalacaoNova) {
        this.comodidades.add(instalacaoNova);
    }

    public void removerInstalacao(InstalacaoJato instalacaoRemover) {
        this.comodidades.remove(instalacaoRemover);
    }

//    public void exibirDetalhesJato() {
//        super.exibirDetalhes();
//        System.out.println("Lotação: " + this.lotacao + " | Cap. Bagagem: " + this.capacidadeBagagem + " cm3 | " + this.categoria);
//        System.out.println("Instalações: " + this.comodidades);
//    }


    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Lotação: " + this.lotacao + " | Cap. Bagagem: " + this.capacidadeBagagem + " cm3 | " + this.categoria);
        System.out.println("Instalações: " + this.comodidades);
    }
}