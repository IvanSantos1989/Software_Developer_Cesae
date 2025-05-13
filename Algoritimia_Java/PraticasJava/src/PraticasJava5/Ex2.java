package PraticasJava5;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double[] vetor = new double[6];
        double somaElementos = 0;

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextDouble();
        }

        // Calcular a soma dos elementos
        for (int i = 0; i < vetor.length; i++) {
            somaElementos = somaElementos + vetor[i];
        }

        System.out.println("Soma dos Elementos: " + somaElementos);

    }
}