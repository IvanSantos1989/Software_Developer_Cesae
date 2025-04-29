package PraticasJava3;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numero, back, ahead;

        System.out.print("Digite um número: ");
        numero = input.nextInt();

        back = numero - 5;
        ahead = numero + 5;

        int contador = back;

        while (contador <= ahead) {
            if (contador != numero) {
                System.out.print(contador + " ");
            }
            contador = contador + 1;
        }
    }
}