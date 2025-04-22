package PraticasJava1;

import java.util.Scanner;

public class Ex02_MenosVar {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int numero1, numero2, resultado;

        // Ler numero 1
        System.out.print("Introduz um numero: ");
        numero1 = input.nextInt();

        // Ler numero 2
        System.out.print("Introduz um numero: ");
        numero2 = input.nextInt();

        // Calcular a soma
        resultado = numero1 + numero2;

        // Apresentar a soma
        System.out.println("Soma: " + resultado);
        
        // Calcular a subtracao
        resultado = numero1 - numero2;

        // Apresentar a subtracao
        System.out.println("Subtração: " + resultado);

        // Calcular a multiplicacao
        resultado = numero1 * numero2;

        // Apresentar a multiplicacao
        System.out.println("Multiplicação: " + resultado);

        // Calcular a divisao
        resultado = numero1 / numero2;

        // Apresentar a divisao
        System.out.println("Divisão: " + resultado);
    }
}