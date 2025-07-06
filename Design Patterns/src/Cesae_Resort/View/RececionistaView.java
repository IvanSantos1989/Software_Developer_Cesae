package Cesae_Resort.View;

import Cesae_Resort.Models.Reserva;
import Cesae_Resort.Models.Quarto;
import java.util.ArrayList;

/**
 * Classe responsável por exibir informações sobre as reservas de quartos feitas pelos clientes.
 * Exibe uma lista de reservas com detalhes como número do quarto, tipologia, ID do cliente e datas.
 */
public class RececionistaView {
    public void mostrarReservas(ArrayList<Reserva> reservas, ArrayList<Quarto> quartos) {
        System.out.println("\nQuartos Reservados:");
        System.out.println("Num | Tipologia            | ID Cliente | Ano | Mes | Semana");
        for (Reserva r : reservas) {
            String tipologia = "";
            for (Quarto q : quartos) {
                if (q.getNumQuarto() == r.getNumQuarto()) {
                    tipologia = q.getTipologia();
                    break;
                }
            }
            System.out.printf("%3d | %-19s | %-10s | %3d | %3d | %3d\n",
                    r.getNumQuarto(), tipologia, r.getIdCliente(), r.getAno(), r.getMes(), r.getSemana());
        }
    }
}