package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex6 {
    public static void idadeMaior (String caminhoFicheiro) throws FileNotFoundException {

        File ficheiro = new File(caminhoFicheiro);
        Scanner reader = new Scanner(ficheiro);

        int maiorIdade = 0;
        String nomeMaiorIdade = "";

        // achar a maior idade
        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            String[] partes = linha.split(",");
            String nome = partes[0];
            int idade = Integer.parseInt(partes[1]);

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeMaiorIdade = nome;
            }
        }
        System.out.println("Pessoa mais velha: " + nomeMaiorIdade + " com " + maiorIdade + " anos.");
    }

    public static void main(String[] args) throws FileNotFoundException {

        idadeMaior("Ficheiros/exercicio_06.txt");
    }
}