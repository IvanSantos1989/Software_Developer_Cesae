package PraticasJava2;

import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int a, b, c;
        String ordem;

        // Ler numeros
        System.out.print("Insira o 1º número: ");
        a = input.nextInt();

        System.out.print("Insira o 2º número: ");
        b = input.nextInt();

        System.out.print("Insira o 3º número: ");
        c = input.nextInt();

        // Ler ordem
        System.out.print("Crescente (C) ou Decrescente (D): ");
        ordem = input.next();

        switch (ordem) {
            case "C":

                // Ordem Crescente
                if (a < b && a < c) { // a ... ...

                    if (b < c) { // a b c
                        System.out.println(a + " " + b + " " + c);
                    } else { // a c b
                        System.out.println(a + " " + c + " " + b);
                    }
                }

                if (b < a && b < c) { // b ... ...

                    if (a < c) { // b a c
                        System.out.println(b + " " + a + " " + c);
                    } else { // b c a
                        System.out.println(b + " " + c + " " + a);
                    }
                }

                if (c < a && c < b) { // c ... ...

                    if (a < b) { // c a b
                        System.out.println(c + " " + a + " " + b);
                    } else { // c b a
                        System.out.println(c + " " + b + " " + a);
                    }
                }

                break;

            case "D":

                // Ordem Drescescente
                if (a < b && a < c) {

                    if (b < c) {
                        System.out.println(c + " " + b + " " + a);
                    } else {
                        System.out.println(b + " " + c + " " + a);
                    }
                }

                if (b < a && b < c) {

                    if (a < c) {
                        System.out.println(c + " " + a + " " + b);
                    } else {
                        System.out.println(a + " " + c + " " + b);
                    }
                }

                if (c < a && c < b) {

                    if (a < b) {
                        System.out.println(b + " " + a + " " + c);
                    } else {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
                break;
        }
    }
}