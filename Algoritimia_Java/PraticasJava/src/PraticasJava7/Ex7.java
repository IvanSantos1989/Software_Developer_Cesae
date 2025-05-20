package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex7 {
    public static void contarLinhasePalavras(String caminhoFicheiro) throws FileNotFoundException {

        /**
         * Função que conta o número de linhas e palavras de um ficheiro
         * @param caminhoFicheiro Caminho do ficheiro
         * @throws FileNotFoundException Caso o ficheiro não exista
         */
        File ficheiro = new File(caminhoFicheiro);
        Scanner reader = new Scanner(ficheiro);

        int numLinhas = 0;
        int numPalavras = 0;

        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            numLinhas++;
            String[] palavras = linha.split(" ");
            numPalavras += palavras.length;
        }

        System.out.println("Número de linhas: " + numLinhas);
        System.out.println("Número de palavras: " + numPalavras);
    }

    public static void main(String[] args) throws FileNotFoundException {
        contarLinhasePalavras("Ficheiros/exercicio_07.txt");
    }
}