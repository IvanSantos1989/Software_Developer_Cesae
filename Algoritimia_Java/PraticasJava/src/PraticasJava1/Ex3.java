package PraticasJava1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {

        // Criação do Scanner - Vamos ler inputs do utilizador
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int comprimento, largura, perimetro, area;

        // Ler dimensões
        System.out.print("Insira o comprimento: ");
        comprimento = input.nextInt();

        System.out.print("Insira a largura: ");
        largura = input.nextInt();

        // Calcular e apresentar o perimetro
        perimetro = comprimento + comprimento + largura + largura;

        System.out.println("Perimetro: " + perimetro);

        // Calcular e apresentar a area
        area = comprimento * largura;

        System.out.println("Área: " + area);

    }
}