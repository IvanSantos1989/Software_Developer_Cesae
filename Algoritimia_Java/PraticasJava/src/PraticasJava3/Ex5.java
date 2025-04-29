package PraticasJava3;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numero;
        String mensagem;

        System.out.print("Digite um número: ");
        numero = input.nextInt();
        input.nextLine(); // Consumir a quebra de linha pendente (limpeza de buffer)

        System.out.print("Digite uma mensagem: ");
        mensagem = input.nextLine();

        int contador = 0;
        while (contador < numero) {
            System.out.println(mensagem);
            contador = contador + 1;
        }
    }
}