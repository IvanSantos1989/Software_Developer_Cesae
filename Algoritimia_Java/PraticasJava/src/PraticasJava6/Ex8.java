package PraticasJava6;

import java.util.Scanner;

public class Ex8 {
    public static int somatorioMatrizes(int[][] matriz1, int[][] matriz2) {

        int somatorio = 0;

        for (int linha = 0; linha < matriz1.length; linha++) {
            for (int coluna = 0; coluna < matriz1[0].length; coluna++) {
                somatorio += matriz1[linha][coluna] + matriz2[linha][coluna];
            }
        }

        return somatorio;
    }

    public static void somaMatrizes(int[][] matriz1, int[][] matriz2) {

        int[][] matrizSoma = new int[matriz1.length][matriz1[0].length];

        // Somar matrizes
        for (int linha = 0; linha < matriz1.length; linha++) {
            for (int coluna = 0; coluna < matriz1[0].length; coluna++) {
                matrizSoma[linha][coluna] = matriz1[linha][coluna] + matriz2[linha][coluna];
            }
        }

        // Imprimir o resultado
        for (int linha = 0; linha < matriz1.length; linha++) {
            for (int coluna = 0; coluna < matriz1[0].length; coluna++) {
                System.out.print(matrizSoma[linha][coluna] + "|\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][2];

        // Ler matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("_____________________________________");

        System.out.println(matriz);

    }
}