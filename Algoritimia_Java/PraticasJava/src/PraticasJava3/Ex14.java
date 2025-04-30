package PraticasJava3;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int contador = 1, quantidade, numAnterior, numAtual;
        boolean crescente = true;

        System.out.print("Quantos números quer introduzir: ");
        quantidade = input.nextInt();

        // Ler numero
        System.out.print("Insira um número: ");
        numAnterior = input.nextInt();

        while (contador < quantidade) {
            // Ler numero
            System.out.print("Insira um número: ");
            numAtual = input.nextInt();

            if (numAtual <= numAnterior) {
                // Deixa de ser crescente
                crescente=false;
            }

            numAnterior = numAtual;

            contador++;
        }

        if(crescente){ // crescente == true
            System.out.println("Crescente");
        }else{
            System.out.println("Não crescente");
        }

    }
}