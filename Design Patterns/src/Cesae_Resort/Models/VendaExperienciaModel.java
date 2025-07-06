package Cesae_Resort.Models;

import java.util.ArrayList;
import java.io.*;

/** * Classe que representa o modelo de vendas de experiências no Cesae Resort.
 * Carrega as vendas a partir de um arquivo CSV e armazena em uma lista.
 */
public class VendaExperienciaModel {
    private String ficheiroVendas = "Files/vendas_experiencias.csv";

    public ArrayList<VendaExperiencia> carregarVendas() {
        ArrayList<VendaExperiencia> vendas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiroVendas))) {
            String linha;
            br.readLine(); // Ignora cabeçalho
            while ((linha = br.readLine()) != null) {
                if (linha.isEmpty()) continue;
                String[] partes = linha.split(",");
                String idExperiencia = partes[1];
                String tipoCliente = partes[2].toLowerCase();
                vendas.add(new VendaExperiencia(idExperiencia, tipoCliente));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler vendas: " + e.getMessage());
        }
        return vendas;
    }
}