package Cesae_Resort.Models;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe responsável por carregar e manipular os dados dos quartos e suas tipologias.
 * Os dados são lidos de arquivos CSV.
 */

public class QuartoModel {
    private String ficheiroQuartos = "Files/quartos.csv";
    private String ficheiroTipologias = "Files/tipologia.csv";

    // Carrega todas as tipologias existentes.
    public ArrayList<Tipologia> carregarTipologias() {
        ArrayList<Tipologia> tipologias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroTipologias))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String descricao = partes[1];
                double preco = Double.parseDouble(partes[2]);
                tipologias.add(new Tipologia(id, descricao, preco));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler tipologias: " + e.getMessage());
        }
        return tipologias;
    }

    // Carrega todos os quartos, associando a cada um a sua tipologia correspondente.
    public ArrayList<Quarto> getTodosOsQuartos() {
        ArrayList<Quarto> quartos = new ArrayList<>();
        ArrayList<Tipologia> tipologias = carregarTipologias();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroQuartos))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                int numQuarto = Integer.parseInt(partes[0]);
                int idTipologia = Integer.parseInt(partes[1]);

                // Busca a tipologia correspondente
                Tipologia tipologia = null;
                for (Tipologia t : tipologias) {
                    if (t.getId() == idTipologia) {
                        tipologia = t;
                        break;
                    }
                }
                if (tipologia != null) {
                    quartos.add(new Quarto(numQuarto, tipologia));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler quartos: " + e.getMessage());
        }
        return quartos;
    }
}