package Cesae_Resort.Models;

import java.util.ArrayList;
import java.io.*;

/**
 * Classe responsável por carregar as experiências do ficheiro CSV.
 * Cada linha do ficheiro representa uma experiência com os seguintes campos:
 * id, nome, idGuia, precoAdulto, precoCrianca.
 */
public class ExperienciaModel {
    private String ficheiroExperiencias = "Files/experiencias.csv";

    public ArrayList<Experiencia> carregarExperiencias() {
        ArrayList<Experiencia> experiencias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroExperiencias))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                String id = partes[0];
                String nome = partes[1];
                String idGuia = partes[2];
                double precoAdulto = Double.parseDouble(partes[3]);
                double precoCrianca = Double.parseDouble(partes[4]);
                experiencias.add(new Experiencia(id, nome, idGuia, precoAdulto, precoCrianca));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler experiências: " + e.getMessage());
        }
        return experiencias;
    }
}