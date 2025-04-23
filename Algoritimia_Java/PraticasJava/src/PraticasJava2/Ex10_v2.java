package PraticasJava2;

import java.util.Scanner;

public class Ex10_v2 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int num1, num2, resultado;
        String operacao;

        // Ler numeros
        System.out.print("Insira o 1º número: ");
        num1 = input.nextInt();

        System.out.print("Insira o 2º número: ");
        num2 = input.nextInt();

        // Ler operacao
        System.out.print("Operação pretendida ( + - * / ): ");
        operacao = input.next();

        if (operacao.equals("+")) { // operacao == "+"
            resultado = num1 + num2;
            System.out.println("Soma: " + resultado);
        } else if (operacao.equals("-")) {
            resultado = num1 - num2;
            System.out.println("Subtração: " + resultado);
        } else if (operacao.equals("*")) {
            resultado = num1 * num2;
            System.out.println("Multiplicação: " + resultado);
        } else if (operacao.equals("/")) {
            resultado = num1 / num2;
            System.out.println("Divisão: " + resultado);
        } else {
            System.out.println("Operação não reconhecida");
        }

    }
}