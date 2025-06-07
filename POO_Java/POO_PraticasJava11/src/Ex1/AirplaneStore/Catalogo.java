package Ex1.AirplaneStore;

import Ex1.Avioes.Aviao;
import Ex1.Avioes.AviaoCombate;
import Ex1.Avioes.JatoPrivado;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Aviao> avioesDisponiveis;

    public Catalogo() {
        this.avioesDisponiveis = new ArrayList<Aviao>();
    }

    public void adquirirAviao(Aviao aviaoNovo) {
        this.avioesDisponiveis.add(aviaoNovo);
    }

    public void venderAviao(Aviao aviaoVendido) {
        this.avioesDisponiveis.remove(aviaoVendido);
    }

    public void imprimirCatalogo() {

//        System.out.println("\n\n*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* Catálogo de Aviões Disponíveis *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
//        for (Aviao aviaoAtual : this.avioesDisponiveis) {
//            System.out.print("\n✈ ");
//
//            if (aviaoAtual instanceof JatoPrivado) {
//                JatoPrivado jp = (JatoPrivado) aviaoAtual;
//                jp.exibirDetalhesJato();
//            }
//
//            if (aviaoAtual instanceof AviaoCombate) {
//                AviaoCombate ac = (AviaoCombate) aviaoAtual;
//                ac.exibirDetalhesAviaoCombate();
//            }
//        }

        System.out.println("\n\n*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* Catálogo de Aviões Disponíveis *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        for (Aviao aviaoAtual : this.avioesDisponiveis) {
            System.out.print("\n✈ ");
            aviaoAtual.exibirDetalhes();
        }



    }

    public void imprimirCatalogoCombate(){
        System.out.println("\n\n*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* \uD83E\uDDE8 Catálogo de Aviões de Combate Disponíveis \uD83E\uDDE8 *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        for (Aviao aviaoAtual : this.avioesDisponiveis) {

            if(aviaoAtual instanceof AviaoCombate){
                AviaoCombate ac = (AviaoCombate) aviaoAtual;
                System.out.print("\n✈ ");
                ac.exibirDetalhes();
                ac.demonstrarArsenal();
            }

        }
    }
}