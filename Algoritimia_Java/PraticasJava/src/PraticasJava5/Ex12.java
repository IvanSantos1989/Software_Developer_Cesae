package PraticasJava5;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[] vetor0 = new int[5];
        int[] vetor1 = new int[5];

        int[][] matriz = new int[5][2];


        // Ler vetor0
        for (int i = 0; i < vetor0.length; i++) {
            System.out.print("Insira no vetor0[" + i + "]: ");
            vetor0[i] = input.nextInt();
        }

        System.out.println("______________________________________");

        // Ler vetor1
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print("Insira no vetor1[" + i + "]: ");
            vetor1[i] = input.nextInt();
        }

        System.out.println("______________________________________");

        for (int i = 0; i < matriz.length; i++) {
            matriz[i][0] = vetor0[i];
            matriz[i][1] = vetor1[i];
        }

        // Imprimir a matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }
}