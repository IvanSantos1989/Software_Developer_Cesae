package PraticasJava5;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[3][3];

        // Ler matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("_____________________________________");

        int maiorElemento = matriz[0][0];
        int menorElemento = matriz[0][0];


        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {

                // Percebemos se o elemento atual é maior
                if (matriz[linha][coluna] > maiorElemento) {
                    maiorElemento = matriz[linha][coluna];
                }

                // Percebemos se o elemento atual é menor
                if (matriz[linha][coluna] < menorElemento) {
                    menorElemento = matriz[linha][coluna];
                }

            }
        }

        System.out.println("Menor: " + menorElemento);
        System.out.println("Maior: " + maiorElemento);


        System.out.println("_____________________________________");

        // Imprimir a matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna]+"\t");
            }
            System.out.println();
        }
    }
}