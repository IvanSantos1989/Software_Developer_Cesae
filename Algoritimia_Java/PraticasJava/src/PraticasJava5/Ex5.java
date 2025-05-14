package PraticasJava5;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[] vetor = new int[5];
        int somaElementos = 0, media;

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        // Calcular a soma dos elementos
        for (int i = 0; i < vetor.length; i++) {
            somaElementos = somaElementos + vetor[i];
        }

        media = somaElementos / vetor.length;

        System.out.println("Média: " + media);

    }
}