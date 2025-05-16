package PraticasJava6;

import java.util.Scanner;

public class Ex5 {

    /**
     * Método que recebe um vetor de inteiros e retorna o maior número do vetor.
     * @param vetor Vetor de inteiros
     * @return menor número do vetor
     */
    public static int maiorN(int[] vetor) {
        Scanner input = new Scanner(System.in);

        // preencher o vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        int maiorN = vetor[0];

        // Verificar o maior número
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maiorN) {
                maiorN = vetor[i];
            }
        }
        return maiorN;

    }

    /**
     * Método que recebe um vetor de inteiros e retorna o menor número do vetor.
     * @param vetor Vetor de inteiros
     * @return menor número do vetor
     */
    public static int menorN(int[] vetor) {
        Scanner input = new Scanner(System.in);

        // preencher o vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        int menorN = vetor[0];

        // Verificar o menor número
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < menorN) {
                menorN = vetor[i];
            }
        }
        return menorN;

    }

    //função para verificar se o vetor é crescente
    public static boolean crescente(int[] vetor) {
        Scanner input = new Scanner(System.in);

        // preencher o vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }
        return true;
    }
}