package PraticasJava3;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numero, media, soma = 0, contador = 0;

        System.out.print("Digite um número: (-1 para sair) ");
        numero = input.nextInt();

        while (numero != -1) {
            System.out.println(numero);
            soma += numero;
            contador += 1;
            System.out.print("Digite um número: (-1 para sair) ");
            numero = input.nextInt();
        }
        media = soma / contador;
        System.out.print("Media de números: " + media);
    }
}