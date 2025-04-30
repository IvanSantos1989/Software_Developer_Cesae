package PraticasJava3;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int numero, antecessor, sucessor;

        // Ler numero
        System.out.print("Insira um número: ");
        numero = input.nextInt();

        antecessor = numero - 5;
        sucessor = numero + 5;

        while (antecessor <= sucessor) {
            if (antecessor != numero) {
                System.out.println(antecessor);
            }

            antecessor++;
        }

    }
}