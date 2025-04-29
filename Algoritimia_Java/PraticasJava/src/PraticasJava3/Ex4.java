package PraticasJava3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int inicio = 0, limite, salto = 1;

        // Ler limite
        System.out.print("Limite do intervalo: ");
        limite = input.nextInt();

        while (inicio <= limite) {
            System.out.println(inicio);
            inicio = inicio + salto;
        }
    }
}