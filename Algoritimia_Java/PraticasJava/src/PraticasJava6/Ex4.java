package PraticasJava6;

import java.util.Scanner;

import static PraticasJava6.Ex3.*;

public class Ex4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numero, opcao;

        System.out.print("Insira um número: ");
        numero = input.nextInt();

        do {
            System.out.println("\n\n***** Programa de Análise de um Número: " + numero + " *****");
            System.out.println("1. Par ou Ímpar");
            System.out.println("2. Positivo ou Negativo");
            System.out.println("3. Primo");
            System.out.println("4. Perfeito");
            System.out.println("5. Triangular");
            System.out.println("6. Trocar de Número");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1: // Par ou Ímpar

                    if(par(numero)){
                        System.out.println("Par");
                    }else{
                        System.out.println("Impar");
                    }

                    break;

                case 2: // Positivo ou Negativo

                    if(positivo(numero)){
                        System.out.println("Positivo");
                    }else{
                        System.out.println("Negativo");
                    }
                    break;

                case 3: // Primo

                    if(primo(numero)){
                        System.out.println("Primo");
                    }else{
                        System.out.println("Não Primo");
                    }
                    break;

                case 4: // Perfeito

                    if(perfeito(numero)){
                        System.out.println("Perfeito");
                    }else{
                        System.out.println("Não Perfeito");
                    }
                    break;

                case 5: // Triangular

                    if(triangular(numero)){
                        System.out.println("Triangular");
                    }else{
                        System.out.println("Não triangular");
                    }
                    break;

                case 6: // Trocar de número

                    System.out.print("Insira um número: ");
                    numero = input.nextInt();

                    break;

                case 7: // Especial

                    if(par(numero) && positivo(numero) && primo(numero)){
                        System.out.println("É par, positivo e primo ao mesmo tempo");
                    }

                case 0: // Sair
                    System.out.println("A encerrar programa...");
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);

    }
}