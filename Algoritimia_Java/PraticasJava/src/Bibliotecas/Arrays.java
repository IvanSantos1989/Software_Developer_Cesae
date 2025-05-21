package Bibliotecas;

import java.util.Scanner;

public class Arrays {
    public static int[] lerVetorInteiros(int tamanho) {
        int[] vetorPreencher = new int[tamanho];

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Ler vetor
        for (int i = 0; i < vetorPreencher.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetorPreencher[i] = input.nextInt();
        }

        return vetorPreencher;
    }

    public static void imprimirVetorInteiros(int[] vetor){

        // Imprimir vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "]: " + vetor[i]);
        }

    }

    public static int maiorElemento(int[] vetor){
        int maiorElemento = vetor[0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maiorElemento) {
                maiorElemento = vetor[i];
            }
        }

        return maiorElemento;
    }
}