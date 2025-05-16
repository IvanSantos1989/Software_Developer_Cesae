package PraticasJava6;

import java.util.Scanner;



public class Demonstracao {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variaveis
        int num1, num2, res, res2,resultado=0;

        // Ler numeros
        System.out.print("Introduza um número: ");
        num1 = input.nextInt( );

        System.out.print("Introduza um número: ");
        num2 = input.nextInt( );

        double x=Math.PI;

        // Invocar a função
        res = num1;
        System.out.println("Módulo Dif. Int.: " + res);

        res2 = num2;
        System.out.println("Módulo Dif. Int.: " + res2);
    }
}