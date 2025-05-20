package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static PraticasJava7.Ex1.imprimirFicheiro;

public class Ex4 {
    /**
     * Função que imprime o conteúdo de um ficheiro na consola
     */
    /*public static void imprimirFicheiro(String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

    }*/

    public static void main(String[] args) throws FileNotFoundException {

        imprimirFicheiro("Ficheiros/exercicio_04.csv");

    }
}