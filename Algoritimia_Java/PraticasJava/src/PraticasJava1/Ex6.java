package PraticasJava1;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int valor1, valor2;

        // Ler valores
        System.out.print("Insira o valor1: ");
        valor1 = input.nextInt();

        System.out.print("Insira o valor2: ");
        valor2 = input.nextInt();


        // Apresentar valores
        System.out.println("\nValor1: " + valor1);
        System.out.println("Valor2: " + valor2);

        // Trocar valores
        valor1 = valor1 + valor2;
        valor2 = valor1 - valor2;
        valor1 = valor1 - valor2;

        // Apresentar valores
        System.out.println("\nValor1: " + valor1);
        System.out.println("Valor2: " + valor2);

    }
}