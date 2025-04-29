package PraticasJava3;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int inicio, fim, intervalo;

        System.out.print("primeiro número: ");
        inicio = input.nextInt();

        System.out.print("último número: ");
        fim = input.nextInt();

        System.out.println("Números múltiplos de 5 no intervalo:");
        intervalo = inicio;

        while (intervalo <= fim) {
            if (intervalo %5 ==0){
                System.out.println(intervalo);
            }
            intervalo += 1;
        }
    }
}