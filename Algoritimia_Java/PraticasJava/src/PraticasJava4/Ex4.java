package PraticasJava4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int numero;
        boolean primo = true;

        // Ler num
        System.out.print("Introduza um número: ");
        numero = input.nextInt();

        if (numero <= 1) {
            primo = false;
        }

        for (int divisor = 2; divisor < numero; divisor++) {
            if (numero % divisor == 0) {
                primo = false;
            }
        }

        if (primo) {
            System.out.println("Primo");
        } else {
            System.out.println("Não primo");
        }

    }
}