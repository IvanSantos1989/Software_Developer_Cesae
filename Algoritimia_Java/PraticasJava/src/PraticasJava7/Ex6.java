package PraticasJava7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex6 {
    public static void pessoaMaisVelha(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int idadeMaisVelha = 0;
        String nomeMaisVelha = "";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            if (Integer.parseInt(linhaSeparada[1]) > idadeMaisVelha) {
                idadeMaisVelha = Integer.parseInt(linhaSeparada[1]);
                nomeMaisVelha = linhaSeparada[0];
            }
        }

        System.out.println("_____ Pessoa Mais Velha _____");
        System.out.println(nomeMaisVelha + " com " + idadeMaisVelha + " anos!");
    }

    public static void main(String[] args) throws FileNotFoundException {

        pessoaMaisVelha("Ficheiros/exercicio_06.txt");
    }
}