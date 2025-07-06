package Cesae_Resort.Models;

import java.util.ArrayList;
import java.io.*;

/**
 * Classe responsável por carregar as reservas de quartos do Cesae Resort a partir de um arquivo CSV.
 * Fornece um método para ler as reservas e retornar uma lista de objetos Reserva.
 */
public class ReservaModel {
    private String ficheiroReservas = "Files/reservas_quartos.csv";

    public ArrayList<Reserva> carregarReservas() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroReservas))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                int numQuarto = Integer.parseInt(partes[1]);
                String idCliente = partes[2];
                int ano = Integer.parseInt(partes[3]);
                int mes = Integer.parseInt(partes[4]);
                int semana = Integer.parseInt(partes[5]);
                reservas.add(new Reserva(numQuarto, idCliente, ano, mes, semana));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler reservas: " + e.getMessage());
        }
        return reservas;
    }
}