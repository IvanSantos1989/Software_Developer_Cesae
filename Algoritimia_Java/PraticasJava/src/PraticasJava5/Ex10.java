package PraticasJava5;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[][] matriz = new int[3][3];
        int numeroPesquisa, contador = 0;

        // Ler matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Insira na matriz[" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("_____________________________________");

        // Ler numero a pesquisar
        System.out.print("Número a pesquisar: ");
        numeroPesquisa = input.nextInt();

        // Procurar o numero a pesquisar
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == numeroPesquisa) {
                    contador++;
                }
            }
        }

        System.out.println("O número " + numeroPesquisa + " aparece " + contador + " vezes na matriz.");

    }
}