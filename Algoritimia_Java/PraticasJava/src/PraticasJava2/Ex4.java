package PraticasJava2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int lugar;

        // Ler lugar
        System.out.print("Insira o seu lugar na corrida: ");
        lugar = input.nextInt();

        if (lugar == 1) {
            System.out.println("Ganhou 10 pontos");
        }

        if (lugar == 2) {
            System.out.println("Ganhou 8 pontos");
        }

        if (lugar == 3) {
            System.out.println("Ganhou 6 pontos");
        }

        if (lugar == 4) {
            System.out.println("Ganhou 5 pontos");
        }

        if (lugar == 5) {
            System.out.println("Ganhou 4 pontos");
        }

        if (lugar == 6) {
            System.out.println("Ganhou 3 pontos");
        }

        if (lugar == 7) {
            System.out.println("Ganhou 2 pontos");
        }

        if (lugar == 8) {
            System.out.println("Ganhou 1 ponto");
        }

        if( lugar >= 9 ){
            System.out.println("Não ganhou pontos");
        }

    }
}