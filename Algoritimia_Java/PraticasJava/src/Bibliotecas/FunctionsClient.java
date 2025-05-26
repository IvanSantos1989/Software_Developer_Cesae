package Bibliotecas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunctionsClient {

    public static void main(String[] args) throws FileNotFoundException {
            displayQuiz("FicheirosIMDV/IMDV_Quiz.csv");
    }

    public static void displayQuiz(String path) throws FileNotFoundException {

        File ficheiro = new File(path);
        Scanner reader = new Scanner(ficheiro);

        System.out.println("Quiz de Cinema:");
        while (reader.hasNextLine()) {
            String linha = reader.nextLine();
            System.out.println(linha);
        }
    }
}
