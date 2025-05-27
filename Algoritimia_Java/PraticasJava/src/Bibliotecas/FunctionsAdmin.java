package Bibliotecas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunctionsAdmin {
    // aqui nessa função vamos imprimir o ficheiro de ratings
    public static void imprimirFicheiro(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            System.out.println(linha);
        }
    }

    // função para contar o número de linhas do ficheiro de ratings, exceto a primeira linha (cabeçalho)
    public static int linhasRatings(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        int contagemLinhas = 0;

        // Ler a primeira linha (cabeçalho) e ignorá-la
        if (reader.hasNextLine()) {
            reader.nextLine();
        }

        while (reader.hasNextLine()) {
            reader.nextLine();
            contagemLinhas++;
        }
        System.out.println("Total de Ratings: " + contagemLinhas);
        return contagemLinhas;
    }


    // função para contar o número de linhas exceto do cabeçalho e depois imprimir a lista de estúdios sem os repetidos
    public static void listarEstudios(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        int contagemLinhas = 0;

        // Ler a primeira linha (cabeçalho) e ignorá-la
        if (reader.hasNextLine()) {
            reader.nextLine();
        }

        while (reader.hasNextLine()) {
            reader.nextLine();
            contagemLinhas++;
        }

        reader = new Scanner(ficheiro); // lendo o ficheiro novamente

        String[] estudiosArray = new String[contagemLinhas]; // Array para armazenar a quantidade de estúdios
        int total = 0; // Contador de estúdios

        // Ler a primeira linha (cabeçalho) e ignorá-la
        if (reader.hasNextLine()) {
            reader.nextLine();
        }


        while (reader.hasNextLine()) {
            String[] colunaEstudio = reader.nextLine().split(";");

            if (colunaEstudio.length > 5) {
                String estudio = colunaEstudio[5];

                // Vamos ver se o estúdio já está na lista
                boolean encontradoNaLista = false;
                for (int i = 0; i < total; i++) {
                    if (estudiosArray[i].equals(estudio)) {
                        encontradoNaLista = true;
                        break;
                    }
                }

                // Se o estúdio não estiver na lista, vamos adicioná-lo
                if (!encontradoNaLista) {
                    estudiosArray[total++] = estudio;
                    System.out.println(estudio);
                }
            }
        }
    }
}