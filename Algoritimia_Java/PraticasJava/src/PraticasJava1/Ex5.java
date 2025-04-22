package PraticasJava1;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double num1, num2, num3, mediaAritmetica, mediaPonderada;

        // Ler valores
        System.out.print("Insira o valor 1: ");
        num1 = input.nextDouble();

        System.out.print("Insira o valor 2: ");
        num2 = input.nextDouble();

        System.out.print("Insira o valor 3: ");
        num3 = input.nextDouble();

        // Calcular e apresentar media aritmetica
        mediaAritmetica = (num1 + num2 + num3) / 3;
        System.out.println("Média Aritmética: " + mediaAritmetica);

        // Calcular e apresentar media ponderada
        mediaPonderada = (num1 * 0.2) + (num2 * 0.3) + (num3 * 0.5);
        System.out.println("Média Ponderada: " + mediaPonderada);
    }
}