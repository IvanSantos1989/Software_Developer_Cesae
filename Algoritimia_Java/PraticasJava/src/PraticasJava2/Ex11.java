package PraticasJava2;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        double saldo, movimento;

        // Ler informações
        System.out.print("Insira o seu saldo: ");
        saldo = input.nextDouble();

        System.out.print("Valor a movimentar: ");
        movimento = input.nextDouble();

        if (saldo + movimento >= 0) { // Movimento válida

            saldo = saldo + movimento; // Atualizar o saldo
            System.out.println("Transação Efetuada");

        } else { // Movimento inválido
            System.out.println("Transação Inválida");
        }

        System.out.println("Saldo Atual: " + saldo);
    }
}