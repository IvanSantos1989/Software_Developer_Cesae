package PraticasJava2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double salario = 0, taxa20, taxa30, taxa35, taxa40;

        System.out.print("Insira o seu salario: ");
        salario = input.nextDouble();

        taxa20 = salario * 0.2;
        taxa30 = salario * 0.3;
        taxa35 = salario * 0.35;
        taxa40 = salario * 0.4;

        if (salario <= 15000) {
            System.out.println("taxa de 20%, paga: " + taxa20);
        }

        if (salario > 15000 && salario <= 20000) {
            System.out.println("taxa de 30%, paga: " + taxa30);
        }

        if (salario > 20000 && salario <= 25000) {
            System.out.println("taxa de 35%, paga: " + taxa35);
        }

        if (salario > 40000) {
            System.out.println("taxa de 40%, paga: " + taxa40);
        }
    }
}
