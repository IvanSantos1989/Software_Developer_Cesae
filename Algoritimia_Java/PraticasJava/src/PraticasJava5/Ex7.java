package PraticasJava5;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int[] vetor = new int[5];
        int maiorpar = vetor[0];
        boolean encontroupar = false;

        // Ler vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira no vetor[" + i + "]: ");
            vetor[i] = input.nextInt();
        }

        // Verificar maior par
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) { // Verifica se o número é par
                if ( vetor[i] > maiorpar) { // Verifica se é o maior par
                    maiorpar = vetor[i];
                    encontroupar = true; // Marca que encontrou um par maior
                }
            }
        }

        if (encontroupar) { // Se encontrou um par maior
            System.out.println("O maior par é: " + maiorpar);
        } else {
            System.out.println("Não há números pares no vetor."); // caso não tenha nenhum par no vetor
    }
}
}