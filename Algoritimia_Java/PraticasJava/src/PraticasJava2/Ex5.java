package PraticasJava2;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int num1, num2;

        // Ler números
        System.out.print("Insira o número: ");
        num1 = input.nextInt();

        System.out.print("Insira outro número: ");
        num2 = input.nextInt();

        // Imprimir o maior número
        if (num1 > num2) {
            System.out.println(num2 + " " + num1);
        } else {
            System.out.println(num1 + " " + num2);
        }
    }
}