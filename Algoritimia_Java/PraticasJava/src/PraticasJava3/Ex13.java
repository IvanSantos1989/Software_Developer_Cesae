package PraticasJava3;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int inicio, limite;

        // Ler valores
        System.out.print("Início do intervalo: ");
        inicio = input.nextInt();

        System.out.print("Limite do intervalo: ");
        limite = input.nextInt();

        while (inicio <= limite) {
            if (inicio % 5 == 0) {
                System.out.println(inicio);
            }

            inicio += 1;
        }
    }
}