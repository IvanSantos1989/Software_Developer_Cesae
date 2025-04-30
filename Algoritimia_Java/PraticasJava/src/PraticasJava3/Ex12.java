package PraticasJava3;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int numeroIntroduzido = 0, intervalo_00_25 = 0, intervalo_26_50 = 0, intervalo_51_75 = 0, intervalo_76_100 = 0;

        while (numeroIntroduzido >= 0) {
            // Ler numero
            System.out.print("Insira um número: ");
            numeroIntroduzido = input.nextInt();

            if (numeroIntroduzido >= 0 && numeroIntroduzido <= 25) {
                intervalo_00_25++;
            }

            if (numeroIntroduzido >= 26 && numeroIntroduzido <= 50) {
                intervalo_26_50++;
            }

            if (numeroIntroduzido >= 51 && numeroIntroduzido <= 75) {
                intervalo_51_75++;
            }

            if (numeroIntroduzido >= 76 && numeroIntroduzido <= 100) {
                intervalo_76_100++;
            }

        }

        System.out.println(" [00,25]: " + intervalo_00_25);
        System.out.println(" [26,50]: " + intervalo_26_50);
        System.out.println(" [51,75]: " + intervalo_51_75);
        System.out.println("[76,100]: " + intervalo_76_100);
    }
}