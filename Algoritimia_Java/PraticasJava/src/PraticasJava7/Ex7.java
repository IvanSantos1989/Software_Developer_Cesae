package PraticasJava7;

import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex7 {
    //public static void contarLinhasePalavras(String caminhoFicheiro) throws FileNotFoundException {

        /**
         * Função que conta o número de linhas e palavras de um ficheiro
         */
        /*File ficheiro = new File(caminhoFicheiro);
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
    }*/

        public static int contarLinhas(String caminho) throws FileNotFoundException {

            File ficheiro = new File(caminho);
            Scanner sc = new Scanner(ficheiro);

            int contagemLinhas = 0;

            while (sc.hasNextLine()) {
                sc.nextLine();
                contagemLinhas++;
            }

            System.out.println("total de linhas: " + contagemLinhas);
            return contagemLinhas;
        }

    public static int contarPalavras(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemPalavras = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(" ");

            contagemPalavras += linhaSeparada.length;
        }

        System.out.println("total de palavras: " + contagemPalavras);
        return contagemPalavras;
    }

    public static void main(String[] args) throws FileNotFoundException {

        contarLinhas("Ficheiros/exercicio_07.txt");
        contarPalavras("Ficheiros/exercicio_07.txt");

    }
}