package PraticasJava2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double salario = 0, taxa20, taxa30;

        System.out.print("Insira o seu salario: ");
        salario = input.nextDouble();

        taxa20 = salario * 0.2;
        taxa30 = salario * 0.3;

        if (salario <= 15000) {
            System.out.println("taxa de 20%, paga: " + taxa20);
        } else {
            System.out.println("taxa de 30%, paga: " + taxa30);
        }
    }
}