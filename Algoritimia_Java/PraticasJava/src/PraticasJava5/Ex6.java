package PraticasJava5;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Escreva um programa que lê um array de tamanho 10 e verifica se os elementos estão em ordem crescente.

        // Declarar variáveis
        int[] vetor = new int[5];
        boolean crescente = true;

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        // Verificar se o vetor está em ordem crescente
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                crescente = false;
                break;
            }
        }

        if (crescente) {
            System.out.println("O vetor está em ordem crescente.");
        } else {
            System.out.println("O vetor não está em ordem crescente.");
        }
    }
}