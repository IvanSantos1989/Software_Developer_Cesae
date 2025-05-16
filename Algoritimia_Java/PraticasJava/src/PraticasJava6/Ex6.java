package PraticasJava6;

import java.util.Scanner;

import static PraticasJava6.Ex5.*; // Importa todas as funções do Ex5

public class Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao;

        System.out.println("***** Programa de Análise de um Vetor *****");
        System.out.print("Insira o tamanho do vetor: ");
        int[] vetor = new int[input.nextInt()];

        do {
            System.out.println("\n\n***** Escolha a opção para a Análise *****");
            System.out.println("1. Verificar se o vetor é crescente");
            System.out.println("2. Verificar o maior número do vetor");
            System.out.println("3. Verificar o menor número do vetor");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {

                case 1: // Verificar se o vetor é crescente
                    if (crescente(vetor)) {
                        System.out.println("O vetor é crescente.");
                    } else {
                        System.out.println("O vetor não é crescente.");
                    }
                    break;

                case 2: // Verificar o maior número do vetor
                    System.out.println("O maior número é: " + maiorN(vetor));
                    break;

                case 3: // Verificar o menor número do vetor
                    System.out.println("O menor número é: " + menorN(vetor));
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

    }

}