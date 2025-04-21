package PraticasJava1;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        // ler dois números e fazer operações aritimeticas
        Scanner input = new Scanner(System.in);

        //variaveis
        int num1, num2, subtracao, divisao, multiplicacao;

        //ler num1
        System.out.print("Digite o número 1: ");
        num1 = input.nextInt();

        //ler num2
        System.out.print("Digite o número 2: ");
        num2 = input.nextInt();

        //calculos
        int soma = num1 + num2;
         divisao = num1 / num2;
         subtracao = num1 - num2;
         multiplicacao = num1 * num2;

        //resultados
        System.out.println("Soma: " + soma);
        System.out.println("Divisão: " + divisao);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);

        input.close();
    }
}
