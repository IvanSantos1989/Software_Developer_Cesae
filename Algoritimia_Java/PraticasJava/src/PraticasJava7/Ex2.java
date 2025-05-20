package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ex2 {
    /**
     * Função que escreve uma mensagem num ficheiro
     * @param caminho Caminho do ficheiro
     * @param mensagem Mensagem a escrever
     * @throws FileNotFoundException Caso o ficheiro não exista
     */
    public static void escreverFicheiro(String caminho, String mensagem) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        PrintWriter pw = new PrintWriter(ficheiro);

        pw.println(mensagem);

        pw.close();
    }

    public static void main(String[] args) throws FileNotFoundException {

        escreverFicheiro("Ficheiros/exercicio_02.txt","Olá mundo :D");
    }
}