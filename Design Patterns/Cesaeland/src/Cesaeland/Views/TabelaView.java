package Cesaeland.Views;

import java.util.List;
import Models.Atracao;
import java.util.ArrayList;

public class TabelaView {

    public void mostrarTabelaAtracoes(ArrayList<Atracao> atracoes) {
        System.out.println("\n===== ATRAÇÕES DISPONÍVEIS =====");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s%n", "ID", "Nome", "Adulto (€)", "Criança (€)", "Duração");
        for (Atracao a : atracoes) {
            int duracao = a.getDuracaoSegundos();
            int min = duracao / 60;
            int seg = duracao % 60;
            System.out.printf("%-5s %-20s %-10.2f %-10.2f %02d:%02d%n",
                    a.getId(), a.getNome(), a.getPrecoAdulto(), a.getPrecoCrianca(), min, seg);
        }
    }
}