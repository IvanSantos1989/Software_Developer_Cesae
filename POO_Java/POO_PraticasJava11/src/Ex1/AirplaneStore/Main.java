package Ex1.AirplaneStore;

import Ex1.Avioes.AviaoCombate;
import Ex1.Avioes.JatoPrivado;
import Ex1.Enums.Arma;
import Ex1.Enums.CategoriaJato;
import Ex1.Enums.InstalacaoJato;

public class Main {
    public static void main(String[] args) {

        JatoPrivado cessna = new JatoPrivado(1200, "Cessna XPTO", 2020, 4500, 12.5, 5.75, 2, 2, 3500, 850, 10000, 12, 500, CategoriaJato.LIGHT_JET);
        cessna.adicionarInstalacao(InstalacaoJato.WC);
        cessna.adicionarInstalacao(InstalacaoJato.WIFI);
        cessna.adicionarInstalacao(InstalacaoJato.SUITE);

        JatoPrivado gulfstream = new JatoPrivado(2350, "Gulstream F500", 2012, 5600, 22, 8.6, 3, 4, 6700, 980, 15000, 18, 1000, CategoriaJato.MIDSIZE_JET);
        gulfstream.adicionarInstalacao(InstalacaoJato.WC);
        gulfstream.adicionarInstalacao(InstalacaoJato.CHUVEIRO);
        gulfstream.adicionarInstalacao(InstalacaoJato.TOMADAS);
        gulfstream.adicionarInstalacao(InstalacaoJato.WIFI);

        JatoPrivado boeing = new JatoPrivado(4411, "747", 2018, 8900, 25, 12, 2.9, 4, 5000, 980, 20000, 120, 4800, CategoriaJato.HEAVY_JET);
        boeing.adicionarInstalacao(InstalacaoJato.WC);
        boeing.adicionarInstalacao(InstalacaoJato.WC);
        boeing.adicionarInstalacao(InstalacaoJato.TOMADAS);
        boeing.adicionarInstalacao(InstalacaoJato.WIFI);
        boeing.adicionarInstalacao(InstalacaoJato.CINEMA);

        AviaoCombate f16 = new AviaoCombate(122, "F16", 2018, 700, 7.5, 4, 0.9, 2, 1200, 1400, 40000, "USA", false);
        f16.adicionarArma(Arma.METRALHADORAS);
        f16.adicionarArma(Arma.FOGUETES);;

        AviaoCombate f22 = new AviaoCombate(133, "F22", 2022, 650, 7.8, 4.2, 1, 2, 1500, 1800, 45000, "USA", true);
        f22.adicionarArma(Arma.MISSEIS);
        f22.adicionarArma(Arma.TORPEDOS);
        f22.adicionarArma(Arma.FOGUETES);


        Catalogo ct = new Catalogo();

        ct.adquirirAviao(cessna);
        ct.adquirirAviao(gulfstream);
        ct.adquirirAviao(f16);
        ct.adquirirAviao(f22);
        ct.adquirirAviao(boeing);

        ct.imprimirCatalogoCombate();


    }
}