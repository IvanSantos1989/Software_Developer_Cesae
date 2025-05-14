package PraticasJava5;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[] vetor = new int[5];

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        int maiorElemento = -1;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {

                if (maiorElemento % 2 != 0) {
                    maiorElemento = vetor[i];
                }

                if (vetor[i] > maiorElemento) {
                    maiorElemento = vetor[i];
                }

            }
        }

        if (maiorElemento % 2 == 0) {
            System.out.println("Maior Par: " + maiorElemento);
        } else {
            System.out.println("Não há pares");
        }


    }
}