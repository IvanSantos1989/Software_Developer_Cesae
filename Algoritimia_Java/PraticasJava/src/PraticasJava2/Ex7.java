package PraticasJava2;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int numero;

        // Ler numero
        System.out.print("Insira um número: ");
        numero = input.nextInt();

        // Apresentar se é par ou impar
        if(numero % 2 ==0){
            System.out.println("É par");
        }else{
            System.out.println("É impar");
        }
    }
}