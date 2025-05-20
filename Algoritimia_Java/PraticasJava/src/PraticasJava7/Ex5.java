package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex5 {
    /**
     * Função que calcula a soma dos números inteiros presentes num ficheiro
     * @param caminho Caminho para o ficheiro a analisar
     * @return Soma dos números presentes no ficheiro
     * @throws FileNotFoundException Caso não encontre o ficheiro
     */
    public static int somarFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int soma = 0;

        while (sc.hasNextInt()) {
            soma += sc.nextInt();
        }

        return soma;
    }

    public static void main(String[] args) throws FileNotFoundException {

        int somaFicheiro1, somaFicheiro2;

        somaFicheiro1 = somarFicheiro("Ficheiros/exercicio_05_31.txt");
        somaFicheiro2 = somarFicheiro("Ficheiros/exercicio_05_1999.txt");

        if (somaFicheiro1 > somaFicheiro2) {
            System.out.println("O ficheiro 1 é maior: " + somaFicheiro1);
        } else {
            System.out.println("O ficheiro 2 é maior: " + somaFicheiro2);
        }

    }
}