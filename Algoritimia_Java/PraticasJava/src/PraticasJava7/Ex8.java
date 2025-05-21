package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex8 {
    /**
     * Função que calcula o total de vendas de um ficheiro CSV
     */
    /*public static void totalVendas (String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner reader = new Scanner(ficheiro);

        double somaVendas = 0.0;

        // Ler a primeira linha (cabeçalho) e ignorá-la
        if (reader.hasNextLine()) {
            reader.nextLine();
        }

        // Ler o ficheiro e calcular o total de vendas
        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] colunas = linha.split(",");
            int quantidade = Integer.parseInt(colunas[2]);
            double valorUnit = Double.parseDouble(colunas[3]);

            somaVendas += valorUnit * quantidade;
        }
        System.out.println("Total de vendas: " + somaVendas);
    }


    public static void main(String[] args) throws FileNotFoundException {

        totalVendas("Ficheiros/exercicio_08.csv");
    }*/


    public static double valorTotalVendido(String path) throws FileNotFoundException {

        Scanner scannerFicheiro = new Scanner(new File(path));

        double totalVendido = 0;

        String linha = scannerFicheiro.nextLine();

        while (scannerFicheiro.hasNextLine()) {

            linha = scannerFicheiro.nextLine();
            String[] linhaDividida = linha.split(",");

            totalVendido += Double.parseDouble(linhaDividida[2]) * Double.parseDouble(linhaDividida[3]);

        }

        return totalVendido;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Total Vendido: " + valorTotalVendido("Ficheiros/exercicio_08.csv") + " €");
    }
}