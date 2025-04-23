package PraticasJava1;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        double preco1, preco2, preco3, totalNormal, totalDesconto;

        // Ler valores
        System.out.print("Insira o preço1: ");
        preco1 = input.nextDouble();

        System.out.print("Insira o preço2: ");
        preco2 = input.nextDouble();

        System.out.print("Insira o preço3: ");
        preco3 = input.nextDouble();

        // total normal
        totalNormal = preco1 + preco2 + preco3;

        // total com desconto
        totalDesconto = totalNormal * 0.9;

        // Apresentar valores
        System.out.println("\nTotal sem desconto: " + totalNormal);
        System.out.println("Total com 10% de desconto: " + totalDesconto);
    }
}