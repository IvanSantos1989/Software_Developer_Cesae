package PraticasJava5;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[3][3];
        int somaDiagonalPrincipal = 0;

        // Ler matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("_____________________________________");

        // Somar os elementos a matriz (diagonal principal)
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (linha == coluna) {
                    somaDiagonalPrincipal += matriz[linha][coluna];
                }
            }
        }

        System.out.println("Soma dos Elementos: " + somaDiagonalPrincipal);

    }
}