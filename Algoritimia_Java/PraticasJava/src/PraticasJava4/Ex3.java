package PraticasJava4;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        // Import do Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int numSecreto, palpite, contadorTentativas=0;

        // Ler numSecreto
        System.out.print("Jogador 1 - Introduza um número: ");
        numSecreto = input.nextInt();

        // Ciclo para imprimir 20 enters
        for(int i =0; i<20; i++){
            System.out.println();
        }

        do {

            // Jogador 2 tenta acertar
            System.out.print("Jogador 2 - Tente adivinhar: ");
            palpite = input.nextInt();

            contadorTentativas++;

            if (palpite > numSecreto) {
                System.out.println("Errado, o seu palpite é superior");
            }

            if (palpite < numSecreto) {
                System.out.println("Errado, o seu palpite é inferior");
            }


        } while (palpite != numSecreto);

        System.out.println("Acertou! Foram precisas " + contadorTentativas + " tentativas");

    }
}